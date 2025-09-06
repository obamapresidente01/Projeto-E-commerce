package br.com.ecommerce.API.repository;

import br.com.ecommerce.API.model.Itempedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<Itempedido, Integer> {
}
