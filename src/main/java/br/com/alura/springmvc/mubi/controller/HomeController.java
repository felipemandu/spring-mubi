package br.com.alura.springmvc.mubi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.domain.StatusPedido;
import br.com.alura.springmvc.mubi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping
	public String hello(Model model) {
		model.addAttribute("pedidos", pedidoRepository.findAll());
		return "home";
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model) {
		StatusPedido statusPedido = Enum.valueOf(StatusPedido.class, status.toUpperCase());
		List<Pedido> pedidos = pedidoRepository.findByStatus(statusPedido);
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

}
