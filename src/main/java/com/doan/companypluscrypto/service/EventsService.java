package com.doan.companypluscrypto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.doan.companypluscrypto.model.Events;
import com.doan.companypluscrypto.repository.EventsRepository;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public Page<Events> findEvents(int id, String name, PageRequest of) {
        return eventsRepository.findByNameAndCompanyId(name, id, of);
    }
    
}
