package com.doan.companypluscrypto.repository;

import org.springframework.stereotype.Repository;

import com.doan.companypluscrypto.model.Events;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EventsRepository extends JpaRepository<Events, Integer> {
    Page<Events> findByNameAndCompanyId(String name, Integer companyId, Pageable pageable);

    Page<Events> findEvents(int id, String name, PageRequest of);
    
}
