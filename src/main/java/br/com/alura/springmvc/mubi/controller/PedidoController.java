package br.com.alura.springmvc.mubi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.mubi.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(Model model) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(PedidoDto pedidoDto) {
		pedidoRepository.save(pedidoDto.toPedido());
		return "pedido/formulario";
	}

}
