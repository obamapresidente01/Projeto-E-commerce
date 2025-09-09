package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Cliente;
import br.com.ecommerce.API.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService service) {
        this.clienteService = service;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {

        List<Cliente> clientes = clienteService.ListarTodos();

        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(
            @RequestBody Cliente cliente
    ) {
        //Tentar cadastrar meu cliente
        clienteService.cadastrarCliente(cliente);

        //Codigo 200 - OK
        //return ResponseEntity.ok(cliente);
        //Codigo 201 - Create
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}




