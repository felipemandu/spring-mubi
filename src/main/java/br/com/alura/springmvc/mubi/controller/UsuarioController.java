package br.com.alura.springmvc.mubi.controller;

import java.security.Principal;
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
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String hello(Model model, Principal principal) {
		model.addAttribute("pedidos", pedidoRepository.findAllByUser(principal.getName()));
		return "usuario/home";
	}
	
	@GetMapping("/{status}")
	public String status(@PathVariable("status") String status, Model model, Principal principal) {
		StatusPedido statusPedido = Enum.valueOf(StatusPedido.class, status.toUpperCase());
		List<Pedido> pedidos = pedidoRepository.findByUserAndStatus(principal.getName(), statusPedido);
		model.addAttribute("pedidos", pedidos);
		return "usuario/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}

}
