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

    //Buscar Cliente por id
    // GET, POST, PUT, DELETE

    // e uma string
    @GetMapping("/{id}")

    // Path Variable - Recebe um valor no LINK
    // Request Body - Recebe dados pelo corpo

    public ResponseEntity<?> buscarClientePorId(@PathVariable Integer id) {
        // 1. Procurar o cliente
        Cliente cliente = clienteService.buscarPorId(id);

        // 2. Se nao encontrar, retorno um erro
        if (cliente == null) {
            // Mais simples menos detalhes
            // return ResponseEntity.notFound().build();

            // Mais detalhes
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Cliente " + id + " nao encontrado!");
        }
        // 3. Se encontrar, retorno o cliente
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("{/id}")
    public ResponseEntity <?> deletarCliente (@PathVariable Integer id) {
        // 1. Verificar se o cliente existe
        Cliente cliente = clienteService.deletarCliente(id);
    
        // 2. Se nao existir retorno erro
        if (cliente == null) {
             return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Cliente " + id + " nao encontrado!");
        }
        
        // 3. Se existir retorno ok
         return ResponseEntity.ok(cliente);
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(
            @PathVariable Integer id, @RequestBody Cliente clienteNovo) {
        // 1. Tento atualizar o Cliente
        Cliente cl = clienteService.atualizarCliente(id, clienteNovo);

        // 2. Se não achar o Cliente, mostro erro
        if(cl == null) {
            return ResponseEntity.status(404)
                    .body("Cliente não encontrado!");
        }

        // 3. Se achar retorno ok
        return ResponseEntity.ok(cl);
    }

}




