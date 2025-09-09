package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Pedido;
import br.com.ecommerce.API.service.ClienteService;
import br.com.ecommerce.API.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService service) {
        this.pedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> ListarPedidos(){

        List<Pedido> pedidos = pedidoService.ListarTodos();
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<Pedido> adicionarPedido(
            @RequestBody Pedido pedido
    ){
        pedidoService.fazerPedido(pedido);
        return ResponseEntity.ok(pedido);
    }
}
