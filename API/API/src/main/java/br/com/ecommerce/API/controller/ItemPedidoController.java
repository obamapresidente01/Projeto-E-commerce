package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Itempedido;
import br.com.ecommerce.API.service.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/itempedido")

public class ItemPedidoController {

    private final ItemPedidoService itempedidoService;
    public ItemPedidoController(ItemPedidoService service) {
        this.itempedidoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Itempedido>> listarItempedidos() {

        List<Itempedido> itempedidos = itempedidoService.ListarTodos();

        return ResponseEntity.ok(itempedidos);
    }
}
