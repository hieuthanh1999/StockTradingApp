package com.doan.companypluscrypto.repository;

import com.doan.companypluscrypto.model.Company;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// Interface JpaRepository cung cấp các phương thức CRUD cơ bản như save, findById, findAll, delete, count, exists, …
@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Page<Company> findByNameContainingOrStockCodeContainingOrSectorContaining(String name, String stockCode, String sector, Pageable pageable);

    Optional<Company> findById(int id);

    Optional<Company> findByName(String name);
}
