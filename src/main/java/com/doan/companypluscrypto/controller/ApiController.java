package com.doan.companypluscrypto.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doan.companypluscrypto.model.Company;
import com.doan.companypluscrypto.model.Events;
import com.doan.companypluscrypto.service.CompanyService;
import com.doan.companypluscrypto.service.EventsService;
// @RestController là một annotation kết hợp của @Controller và @ResponseBody
@RestController
public class ApiController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EventsService eventsService;

    // Phương thức lấy thông tin của company theo id
    @GetMapping("/stock")
    public String getStock(@RequestParam String stockName) throws IOException, InterruptedException {

        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+stockName+"&apikey=HC0OMFETL900FFLO&outputsize=comapact";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();    
    }
    
    // Phương thức lấy thông tin của company theo id
    @GetMapping("/company/pagination")
    public ResponseEntity<Page<Company>> getCompanyPagination(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String stockCode
                            , @RequestParam(defaultValue = "") String sector, @RequestParam(defaultValue = "0") int page
                            , @RequestParam(defaultValue = "10") int size) throws IOException, InterruptedException {
        Page<Company> resultList = companyService.findCompany(name, stockCode, sector, PageRequest.of(page, size));
        return ResponseEntity.ok(resultList);
    }

    @GetMapping("/admin/events")
    public ResponseEntity<Page<Events>> getListEvents(@RequestParam int id,@RequestParam(defaultValue = "") String name, Model model, @RequestParam(defaultValue = "0") int page
                            , @RequestParam(defaultValue = "5") int size) {
        Page<Events> resultPage = eventsService.findEvents(id, name, PageRequest.of(page, size));
        return ResponseEntity.ok(resultPage);
    }  
    

    @GetMapping("/crypto/find")
    public String getCrypto(@RequestParam String cryptoCode) {

        String apiUrl = "https://api.coingecko.com/api/v3/coins/" + cryptoCode + "/market_chart?vs_currency=usd&days=7";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(apiUrl))
            .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error fetching data";
        }

        return response.body();
    }
}
