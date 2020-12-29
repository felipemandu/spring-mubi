package br.com.alura.springmvc.mubi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.springmvc.mubi.domain.Pedido;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String hello(Model model) {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto("Kindle 10a. geração com iluminação embutida – Cor Preta ");
		pedido.setDataEntrega(LocalDate.now());
		pedido.setValorNegociado(new BigDecimal("100.00"));
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/61X0ISBpD-L._AC_SL1000_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Kindle-10a-gera%C3%A7%C3%A3o-ilumina%C3%A7%C3%A3o-embutida/dp/B07FQK1TS9/ref=asc_df_B07FQK1TS9/?tag=googleshopp00-20&linkCode=df0&hvadid=432951822456&hvpos=&hvnetw=g&hvrand=17688350203365422905&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001765&hvtargid=pla-901759904091&psc=1");
		pedido.setDescricao("Nunca foi tão fácil achar novas histórias com o Kindle. A Loja Kindle possui milhares de livros gratuitos e torna mais fácil descobrir novos títulos com recomendações personalizadas para você. Além disso, com Kindle Unlimited você pode escolher entre mais de 1 milhão de títulos para ler.");
		List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);
		
		return "home";
	}

}
