package com.doan.companypluscrypto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.doan.companypluscrypto.model.Company;
import com.doan.companypluscrypto.service.CompanyService;



@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/company")
    public String company() {
        return "company";
    }

    @GetMapping("/crypto")
    public String crypto() {
        return "crypto";
    }

    @GetMapping("/company/find")
    public String findCompany(@RequestParam String name, @RequestParam String stockCode, @RequestParam String sector, Model model) {
        List<Company> resuList = companyService.findCompany(name, stockCode, sector);
        model.addAttribute("companies", resuList);
        return "/components/company-data";
    }
    
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }  
    
}
