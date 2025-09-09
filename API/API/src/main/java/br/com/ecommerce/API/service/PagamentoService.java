package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Pagamento;
import br.com.ecommerce.API.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository repo) {
        pagamentoRepository = repo;
    }

    public List<Pagamento> ListarTodos(){
        return pagamentoRepository.findAll();
    }

    public Pagamento fazerPagamento(Pagamento pagamento){
        return pagamentoRepository.save(pagamento);
    }
}
