package br.com.alura.springmvc.mubi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.alura.springmvc.mubi.domain.Oferta;

public class OfertaDto {

	private String pedidoId;

	private String valor;

	private String dataDaEntregua;

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

	public String getDataDaEntregua() {
		return dataDaEntregua;
	}

	public void setDataDaEntregua(String dataDaEntregua) {
		this.dataDaEntregua = dataDaEntregua;
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
		oferta.setDataDaEntregua(LocalDate.parse(dataDaEntregua, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		return oferta;
	}

}
