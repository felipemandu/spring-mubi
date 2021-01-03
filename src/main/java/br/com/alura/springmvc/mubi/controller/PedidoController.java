package br.com.alura.springmvc.mubi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.domain.User;
import br.com.alura.springmvc.mubi.dto.PedidoDto;
import br.com.alura.springmvc.mubi.repository.PedidoRepository;
import br.com.alura.springmvc.mubi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	private PedidoRepository pedidoRepository;

	private UserRepository userRepository;
	
	@Autowired
	public PedidoController(PedidoRepository pedidoRepository, UserRepository userRepository) {
		this.pedidoRepository = pedidoRepository;
		this.userRepository = userRepository;
	}

	@GetMapping("formulario")
	public String formulario(PedidoDto pedidoDto) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid PedidoDto pedidoDto, BindingResult result) {
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext()
												.getAuthentication()
												.getName();
		User user = userRepository.findByUsername(username);
		
		Pedido pedido = pedidoDto.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		
		return "redirect:/home";
	}

}
