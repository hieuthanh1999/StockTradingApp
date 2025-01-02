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

    public void saveCompany(Company company) {
        Optional<Company> companyOptional = companyRepository.findByName(company.getName());
        if (companyOptional.isPresent() && company.getId() != 0 && companyOptional.get().getId() != company.getId()) {
            //throw new ResponseStatusException(HttpStatus.CONFLICT, "Company already exists with the same name");
        }
        companyRepository.save(company);
    }

    public void deleteCompany(int id) {
        if (companyRepository.existsById(id)) {
            Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));
            if (company.getEvents().isEmpty()) {
                companyRepository.deleteById(id);
            } else {
                throw new RuntimeException("Cannot delete company with existing events");
            }
        } else {
            throw new RuntimeException("Company not found");
        }
    }


    
}
