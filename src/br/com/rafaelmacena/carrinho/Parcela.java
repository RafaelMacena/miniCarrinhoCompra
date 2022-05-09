package br.com.rafaelmacena.carrinho;

import java.util.Date;

public class Parcela {

	private Double valor;
	private Integer numero;
	private Date dataVencimento;

	public Parcela() {

	}

	public Parcela(Double valor, Integer numero, Date dataVencimento) {
		this.valor = valor;
		this.numero = numero;
		this.dataVencimento = dataVencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "Parcela [valor=" + valor + ", numero=" + numero + ", dataVencimento=" + dataVencimento + "]";
	}
	
	

}
