package br.com.alura.springmvc.mubi.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.domain.StatusPedido;
import br.com.alura.springmvc.mubi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRest {

	private PedidoRepository pedidoRepository;

	@Autowired
	public PedidoRest(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping("{status}")
	public List<Pedido> getPedidosAguardandoOfertas(@PathVariable("status") String status) {
		StatusPedido statusEnum = Enum.valueOf(StatusPedido.class, status.toUpperCase());

		Sort sort = Sort.by("id").descending();
		PageRequest page = PageRequest.of(0, 10, sort);
		return pedidoRepository.findByStatus(statusEnum, page);
	}

}
