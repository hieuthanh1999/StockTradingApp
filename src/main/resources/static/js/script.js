
function changePage(element) {
    var page = element.getAttribute('data-page');
    var size = element.getAttribute('data-size');
    var name = element.getAttribute('data-name');
    $.ajax({
        type: 'GET',
        data: {
            page: page,
            size: size,
            stockName: name,
            name: name
        },
        url: '/company/pagination', // Replace with the actual API endpoint
        success: function(response) {
            $('#companyTable tbody').html('');
            response['content'].forEach(function(company) {
                const row = `<tr data-id="${company.id}">
                    <td>${company.name}</td>
                    <td>${company.sector}</td>
                    <td>${company.stockCode}</td>
                </tr>`;
                $('#companyTable tbody').append(row);
            });

            // Update pagination
            var paginationHtml = '<ul class="pagination justify-content-center">';
            if (response.pageable.pageNumber > 0) {
                paginationHtml += `<li class="page-item">
                    <a class="page-link" href="javascript:void(0);" data-page="${response.pageable.pageNumber - 1}" data-size="${response.pageable.pageSize}" data-name="${name ? name : ''}" onclick="changePage(this)">Previous</a>
                </li>`;
            } else {
                paginationHtml += `<li class="page-item disabled">
                    <a class="page-link" href="javascript:void(0);">Previous</a>
                </li>`;
            }
            for (var i = 0; i < response.totalPages; i++) {
                paginationHtml += `<li class="page-item ${i == response.pageable.pageNumber ? 'active' : ''}">
                    <a class="page-link" href="javascript:void(0);" data-page="${i}" data-size="${response.pageable.pageSize}" data-name="${name ? name : ''}" onclick="changePage(this)">${i + 1}</a>
                </li>`;
            }
            if (response.pageable.pageNumber < response.totalPages - 1) {
                paginationHtml += `<li class="page-item">
                    <a class="page-link" href="javascript:void(0);" data-page="${response.pageable.pageNumber + 1}" data-size="${response.pageable.pageSize}" data-name="${name ? name : ''}" onclick="changePage(this)">Next</a>
                </li>`;
            } else {
                paginationHtml += `<li class="page-item disabled">
                    <a class="page-link" href="javascript:void(0);">Next</a>
                </li>`;
            }
            paginationHtml += '</ul>';

            document.getElementById('pagination').innerHTML = paginationHtml;
            setupRowClickEvent();
        }
    });
}
google.charts.load('current', { 'packages': ['corechart'] });
var c=0;
function setupRowClickEvent() {
    $('#companyTable tbody tr').click(function(event) {
        if (!$(event.target).is('button')) {
            var stockCode = $(this).find('td').eq(2).text();
            console.log(stockCode);
            $.ajax({
                type: 'GET',
                data: {
                    stockName: stockCode.toLocaleLowerCase(),
                    dateby: 7,
                },
                url: '/stock', // Replace with the actual API endpoint
                dataType: "json",
                success: function(obj) {
                    if (obj["Error Message"]) {
                        document.getElementById('ms').innerHTML = "Không tìm thấy dữ liệu cổ phiếu";
                        document.getElementById('stockTableBody').innerHTML = '';
                        document.getElementById('chartContainer').innerHTML = '';
                        return;
                    }
                    displayStockData(obj);
                    drawChart(obj);
                }
            });
            
            var companyId = $(this).attr('data-id');
            console.log(companyId);
            $.ajax({
                url: '/company/' + companyId,
                method: 'GET',
                success: function(response) {
                    $('#companyDetails').html(response);
                },
                error: function(error) {
                    console.error('Error:', error);
                }
            });
        } else {
            console.log('Button clicked');
            console.log($(event.target).text());
            event.preventDefault();
            event.stopPropagation();
            // Manually trigger the desired action here
            console.log('Button action triggered');
        }
        

    });
    $('#companyTable tbody tr:first').trigger('click');
}

function displayStockData(data) {
    const stockTableBody = document.getElementById('stockTableBody');
    stockTableBody.innerHTML = ''; // Clear previous data
    let counter = 0;
    for (let date in data["Time Series (Daily)"]) {
        if (data["Time Series (Daily)"].hasOwnProperty(date)) {
            if (counter >= 7) break;
            const dailyData = data["Time Series (Daily)"][date];
            const row = document.createElement('tr');
            row.innerHTML = `
                <td>${date}</td>
                <td style="color: blue;">${dailyData["1. open"]}</td>
                <td style="color: green;">${dailyData["2. high"]}</td>
                <td style="color: red;">${dailyData["3. low"]}</td>
                <td style="color: orange;">${dailyData["4. close"]}</td>
                <td style="color: purple;">${dailyData["5. volume"]}</td>
            `;
            stockTableBody.appendChild(row);
            counter++;
        }
    }
}

function drawChart(data) {
    const dataPoints = [
        ['Ngày', 'Open','High','Low','Close','Volume'],
    ];

    for (let date in data["Time Series (Daily)"]) {
        if (data["Time Series (Daily)"].hasOwnProperty(date)) {
            const dailyData = data["Time Series (Daily)"][date];
            dataPoints.push([date, parseFloat(dailyData["1. open"]), parseFloat(dailyData["2. high"]), parseFloat(dailyData["3. low"]), parseFloat(dailyData["4. close"]), parseFloat(dailyData["5. volume"])]);
        }
    }
    console.log("obj");
    const chartData = google.visualization.arrayToDataTable(dataPoints);
    const options = {
        title: 'Biểu đồ giá cổ phiếu',
        legend: { position: 'bottom' },
        hAxis: { title: 'Ngày' },
        vAxis: { title: 'Giá (USD)', minValue: 0 },
        seriesType: 'line', // Biểu đồ dạng đường
        series: {
            4: { type: 'bars', targetAxisIndex: 1 } // Volume hiển thị dạng cột
        },
        vAxes: {
            0: { title: 'Giá (USD)' },
            1: { title: 'Khối lượng' }
        },
        colors: ['#4285F4', '#34A853', '#FBBC05', '#EA4335', '#9C27B0'],
    };
    
    const chart = new google.visualization.ComboChart(document.getElementById('chartContainer'));
    chart.draw(chartData, options);
}