package com.doan.companypluscrypto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doan.companypluscrypto.model.Company;
import com.doan.companypluscrypto.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public void addCompany() {
        // Add company
    }

    public void updateCompany() {
        // Update company
    }

    public void deleteCompany() {
        // Delete company
    }

    public void getCompany() {
        // Get company
    }

    public List<Company> findCompany(String name, String stockCode, String sector) {
        // TODO Auto-generated method stub
        return companyRepository.findByNameContainingOrStockCodeContainingOrSectorContaining(name, name, name);
    }

    
}
