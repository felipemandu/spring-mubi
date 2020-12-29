package br.com.alura.springmvc.mubi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.domain.StatusPedido;
@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido statusPedido);

}
