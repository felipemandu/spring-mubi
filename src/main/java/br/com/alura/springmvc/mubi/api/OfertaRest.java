package br.com.alura.springmvc.mubi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.springmvc.mubi.domain.Oferta;
import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.dto.OfertaDto;
import br.com.alura.springmvc.mubi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/oferta")
public class OfertaRest {
	
	private PedidoRepository pedidoRepository;

	@Autowired
	public OfertaRest(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}
	
	@PostMapping
	public Oferta criaOferta(OfertaDto ofertaDto) {
		Long pedidoId = Long.parseLong(ofertaDto.getPedidoId());
		Optional<Pedido> pedidoInDb = pedidoRepository.findById(pedidoId);
		if(pedidoInDb.isEmpty()) {
			return null;
		}
		
		Pedido pedido = pedidoInDb.get();
		Oferta oferta = ofertaDto.toOferta();
		oferta.setPedido(pedido);
		pedido.addOferta(oferta);
		pedidoRepository.save(pedido);
		return oferta;
	}
	
	
	

}
