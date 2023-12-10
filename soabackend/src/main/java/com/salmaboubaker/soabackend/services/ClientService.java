package com.salmaboubaker.soabackend.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salmaboubaker.soabackend.entities.Client;
import com.salmaboubaker.soabackend.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;


    public Client authenticateClient(String email, String password) {
        Client client = clientRepository.findByEmailAndPassword(email, password);
        return client;
    }
    
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Optional<Client> trouverClientParId(Long id) {
        return clientRepository.findById(id);
    }

    public Optional<Client> trouverClientParNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> trouverClientParEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    // Autres méthodes pour les opérations métier liées aux clients
}
