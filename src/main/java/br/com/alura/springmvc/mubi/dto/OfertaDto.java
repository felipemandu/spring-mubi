package br.com.alura.springmvc.mubi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.springmvc.mubi.domain.Oferta;

public class OfertaDto {

	@NotNull
	private String pedidoId;

	@Pattern(regexp = "\\d+(\\.(\\d){2})?")
	@NotNull
	private String valor;

	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
	@NotNull
	private String dataDaEntrega;

	private String comentarios;

	public String getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(String pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntregua) {
		this.dataDaEntrega = dataDaEntregua;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setValor(new BigDecimal(valor));
		oferta.setComentarios(comentarios);
		oferta.setDataDaEntrega(LocalDate.parse(dataDaEntrega, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return oferta;
	}

}
