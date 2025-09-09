package br.com.ecommerce.API.controller;

import br.com.ecommerce.API.model.Pagamento;
import br.com.ecommerce.API.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamento")

public class PagamentoController {

    private final PagamentoService pagamentoService;
    public PagamentoController (PagamentoService service) {
        this.pagamentoService = service;
    }

    @GetMapping
    public ResponseEntity<List<Pagamento>> ListarPagamentos(){

        List<Pagamento> pagamentos = pagamentoService.ListarTodos();

        return ResponseEntity.ok(pagamentos);
    }

    @PostMapping
    public ResponseEntity<Pagamento> adicionarPagamento(
            @RequestBody Pagamento pagamento
    ) {
        pagamentoService.fazerPagamento(pagamento);
        return ResponseEntity.ok(pagamento);
    }
}
