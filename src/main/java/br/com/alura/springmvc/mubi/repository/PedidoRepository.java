package br.com.alura.springmvc.mubi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.mubi.domain.Pedido;
@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{

}
