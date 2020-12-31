package br.com.alura.springmvc.mubi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.springmvc.mubi.domain.StatusPedido;
import br.com.alura.springmvc.mubi.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private PedidoRepository pedidoRepository;

	@Autowired
	public HomeController(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@GetMapping
	public String pedidoEntregues(Model model) {
		Sort sort = Sort.by(Direction.ASC, "dataEntrega");
		PageRequest pageRequest = PageRequest.of(0, 10, sort);
		
		StatusPedido entregue = StatusPedido.ENTREGUE;
		
		model.addAttribute("pedidos", pedidoRepository.findByStatus(entregue, pageRequest));
		return "home";
	}
	


}
