package com.doan.companypluscrypto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.doan.companypluscrypto.model.Company;
import com.doan.companypluscrypto.repository.CompanyRepository;
// @Service là một annotation đánh dấu một class là một Spring Bean
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
    // Phương thức tìm kiếm company theo tên, mã cổ phiếu, ngành nghề
    public Page<Company> findCompany(String name, String stockCode, String sector, Pageable pageable) {
        return companyRepository.findByNameContainingOrStockCodeContainingOrSectorContaining(name, name, name, pageable);
    }
    // Phương thức lấy thông tin của company theo id
    public Company getCompany(int id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()) {
            return company.get();
        }
        throw new RuntimeException("Company not found");
    }

    
}
