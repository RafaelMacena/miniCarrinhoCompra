package br.com.rafaelmacena.carrinho;

import java.util.ArrayList;
import java.util.List;

public class Compra {

	private double valorCompra;
	private FormaPagamento formaPagamento;
	private List<Produto> produtos;
	private int qtdParcelas;

	public int getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorCompra() {
		return valorCompra;
	}
	
	public void adicionarProduto(Produto produto) {
		if (produtos ==  null) {
			produtos = new ArrayList<>();
		}
		produtos.add(produto);
	}
	
	public void calcularValorDaCompra() {
		
		if(!produtos.isEmpty()) {
			produtos.forEach(p -> {
				valorCompra += (p.getValorProduto() * p.getQtdProduto());
			});
		}
	}

	@Override
	public String toString() {
		return "Compra [valorCompra=" + valorCompra + ", formaPagamento=" + formaPagamento + ", produtos=" + produtos
				+ ", qtdParcelas=" + qtdParcelas + "]";
	}
	
	

}
