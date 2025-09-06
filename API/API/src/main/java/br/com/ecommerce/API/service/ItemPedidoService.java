package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Itempedido;
import br.com.ecommerce.API.repository.ItemPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    private final ItemPedidoRepository itemPedidoRepository;

    public ItemPedidoService (ItemPedidoRepository repo) {
        itemPedidoRepository = repo;
    }

    public List<Itempedido> ListarTodos(){
        return itemPedidoRepository.findAll();
    }
}
