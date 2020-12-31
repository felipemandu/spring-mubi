package br.com.alura.springmvc.mubi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.domain.StatusPedido;
@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Long>{

	@Cacheable("pedidoPorStatus")
	List<Pedido> findByStatus(StatusPedido statusPedido, Pageable pageable);
	
	@Query("select p from Pedido p join p.user u where u.username = :user")
	List<Pedido> findAllByUser(@Param("user")String user);
	
	@Query("select p from Pedido p join p.user u where u.username = :user And p.status = :status")
	List<Pedido> findByUserAndStatus(@Param("user")String user, @Param("status")StatusPedido status);

}
