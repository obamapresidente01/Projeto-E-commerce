package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Pedido;
import br.com.ecommerce.API.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService (PedidoRepository repo) {
        pedidoRepository = repo;
    }

    public List<Pedido> ListarTodos(){
        return pedidoRepository.findAll();
    }

    public Pedido fazerPedido(Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public Pedido buscarPorId(Integer id){
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido excluirPedido(Integer id){
        Pedido pedido = buscarPorId(id);

        if (pedido == null) {
           return null;
        }
        pedidoRepository.delete(pedido);
        return pedido;
    }
}

