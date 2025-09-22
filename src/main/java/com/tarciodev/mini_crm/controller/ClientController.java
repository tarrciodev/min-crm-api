package com.tarciodev.mini_crm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarciodev.mini_crm.DTO.ContactoRequestDTO;
import com.tarciodev.mini_crm.model.Client;
import com.tarciodev.mini_crm.model.Contacto;
import com.tarciodev.mini_crm.repository.ClientRepository;
import com.tarciodev.mini_crm.repository.ContactoRepository;


@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientRepository clientRepository;
    private final ContactoRepository contactoRepository;

    public ClientController(ClientRepository clientRepository, ContactoRepository contactoRepository) {
        this.clientRepository = clientRepository;
        this.contactoRepository = contactoRepository;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client payload) {
        Client client = clientRepository.save(payload);
        return ResponseEntity.created(URI.create("/client/" + client.getId())).body(client);
    }

    
   @GetMapping("/")
    public ResponseEntity<List<Client>> listAll() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @PostMapping("/{id}/contacto")
    public ResponseEntity<Contacto>createContacto(@PathVariable Long id, @RequestBody ContactoRequestDTO payload) {
        var clientExists = clientRepository.findById(id);
        if (clientExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Contacto newContacto = new Contacto();
        newContacto.setClient(clientExists.get());
        newContacto.setTipo(payload.tipo());
        newContacto.setValor(payload.email());

        Contacto contacto = contactoRepository.save(newContacto);
        return ResponseEntity.created(URI.create("/contacto/" + contacto.getId())).body(contacto);
    }

    @GetMapping("/{id}/contacto")
    public ResponseEntity<List<Contacto>> listContacto(@PathVariable Long id) {
        var clientExists = clientRepository.findById(id);
        if (clientExists.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var client = clientExists.get();
        return ResponseEntity.ok(client.getContactos());
    }
}