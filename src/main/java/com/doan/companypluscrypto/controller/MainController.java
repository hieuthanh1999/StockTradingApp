package com.doan.companypluscrypto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.doan.companypluscrypto.model.Company;
import com.doan.companypluscrypto.service.CompanyService;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class MainController {

    @Autowired
    private CompanyService companyService;

    // Phương thức trả về trang chủ
    @GetMapping("/")
    public String home() {
        return "redirect:/company";
    }

    // Phương thức trả về trang login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Phương thức trả về trang company
    @GetMapping("/company")
    public String company(Model model) {
        
        return "company";
    }

    // Phương thức trả về trang crypto
    @GetMapping("/crypto")
    public String crypto() {
        return "crypto";
    }

    // Phương thức tìm kiếm company theo tên, mã cổ phiếu, ngành nghề
    @GetMapping("/company/find")
    public String findCompany(@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String stockCode
                            , @RequestParam(defaultValue = "") String sector, Model model, @RequestParam(defaultValue = "0") int page
                            , @RequestParam(defaultValue = "10") int size) {
        Page<Company> resultList = companyService.findCompany(name, stockCode, sector, PageRequest.of(page, size));
        model.addAttribute("companies", resultList);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", resultList.getTotalPages());
        model.addAttribute("name", name);
        return "/components/company-data";
    }
    
    // Phương thức trả về trang access-denied
    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied";
    }  

    // Phương thức lấy thông tin của company theo id
    @GetMapping("/company/" + "{id}")
    public String getCompany(@PathVariable int id, Model model) {
        Company company = companyService.getCompany(id);
        model.addAttribute("company", company);
        return "/components/company-detail";
    }
    
}
