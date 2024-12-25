package com.doan.companypluscrypto.repository;

import com.doan.companypluscrypto.model.Company;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
    List<Company> findByNameContainingOrStockCodeContainingOrSectorContaining(String name, String stockCode, String sector);
}
