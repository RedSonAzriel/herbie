package com.herbie.sc.services;

import com.herbie.sc.data.models.Client;
import com.herbie.sc.data.repositories.ClientRepository;
import com.herbie.sc.data.specifications.ClientDatabaseFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Page<Client> getClientsForDatatable(String queryString, Pageable pageable) {

        ClientDatabaseFilter clientDatabaseFilter = new ClientDatabaseFilter(queryString);

        return clientRepository.findAll(clientDatabaseFilter, pageable);
    }
}