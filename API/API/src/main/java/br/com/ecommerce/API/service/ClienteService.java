package br.com.ecommerce.API.service;

import br.com.ecommerce.API.model.Cliente;
import br.com.ecommerce.API.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    // injeção de dependencia
    // Falar que Service depende de alguém
    private final ClienteRepository clienteRepository;


    public ClienteService (ClienteRepository repo) {
        clienteRepository = repo;

    }

    //listar
    public List<Cliente> ListarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente cadastrarCliente(Cliente cl) {

        return clienteRepository.save(cl);

    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente deletarCliente(Integer id){
        // 1. Verifico se o Cliente existe
        Cliente cliente = buscarPorId(id);

        //2. Se nao existe, retorno erro
        if (cliente == null) {
            return null;
        }
        //3. Se existir, exclua
        clienteRepository.delete(cliente);
        return cliente;
    }
}