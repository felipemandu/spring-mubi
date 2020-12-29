package br.com.alura.springmvc.mubi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.springmvc.mubi.repository.PedidoRepository;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/home")
	public String hello(Model model) {
		model.addAttribute("pedidos", pedidoRepository.findAll());
		return "home";
	}

}
