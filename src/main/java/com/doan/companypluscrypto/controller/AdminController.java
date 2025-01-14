package com.doan.companypluscrypto.controller;


import com.doan.companypluscrypto.model.Company;
import com.doan.companypluscrypto.service.CompanyService;
import com.doan.companypluscrypto.service.EventsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EventsService eventsService;

    @GetMapping("/admin")
    public String getMethodName() {
        return "/admin/admin";
    }

    @GetMapping("/admin/company/edit/" + "{id}") 
    public String getMethodName(@PathVariable int id, Model model) {
        Company company = companyService.getCompany(id);
        model.addAttribute("company", company);
        return "/admin/edit-company";
    }

    @PostMapping("/admin/company/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/company";
    }
    
    @GetMapping("/admin/company/delete/" + "{id}")
    public String deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
        return "redirect:/company";
    }

    @GetMapping("/admin/company/add")
    public String getMethodName(Model model) {
        Company company = new Company();
        model.addAttribute("company", company);

        return "/admin/edit-company";
    }
    
}
