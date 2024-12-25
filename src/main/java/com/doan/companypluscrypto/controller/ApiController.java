package com.doan.companypluscrypto.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    
    @GetMapping("/stock")
    public String getStock() throws IOException, InterruptedException {
        String apiUrl = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=VNM&apikey=HC0OMFETL900FFLO";
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();    
    }
}
