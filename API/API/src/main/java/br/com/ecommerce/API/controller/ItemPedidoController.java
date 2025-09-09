package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Itempedido;
import br.com.ecommerce.API.service.ItemPedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itempedido")

public class ItemPedidoController {

    private final ItemPedidoService itempedidoService;
    private final ItemPedidoService itemPedidoService;

    public ItemPedidoController(ItemPedidoService service, ItemPedidoService itemPedidoService) {
        this.itempedidoService = service;
        this.itemPedidoService = itemPedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Itempedido>> listarItempedidos() {

        List<Itempedido> itempedidos = itempedidoService.ListarTodos();

        return ResponseEntity.ok(itempedidos);
    }

    @PostMapping
    public ResponseEntity<Itempedido> adicionarItempedido(
            @RequestBody Itempedido itempedido
    ) {
        itemPedidoService.adicionarItempedido(itempedido);
        return ResponseEntity.ok(itempedido);
    }
}
