package br.com.alura.springmvc.mubi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.springmvc.mubi.domain.Pedido;
import br.com.alura.springmvc.mubi.domain.StatusPedido;


public class PedidoDto {

	@NotBlank
	private String nomeProduto;
	@NotBlank
	private String urlImagem;
	@NotBlank
	private String urlProduto;
	private String descricaoProduto;

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public String getUrlProduto() {
		return urlProduto;
	}

	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setDescricao(descricaoProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}

}
