package br.com.rafaelmacena.carrinho;

public class Produto {
	
	private double valorProduto;
	private String nomeProduto;
	private  int qtdProduto;
	
	
	public Produto() {
	
	}


	public Produto(double valorProduto, String nomeProduto, int qtdProduto) {
		
		this.valorProduto = valorProduto;
		this.nomeProduto = nomeProduto;
		this.qtdProduto = qtdProduto;
	}


	public double getValorProduto() {
		return valorProduto;
	}


	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	public int getQtdProduto() {
		return qtdProduto;
	}


	public void setQtdProduto(int qtdProduto) {
		this.qtdProduto = qtdProduto;
	}


	@Override
	public String toString() {
		return "Produto [valorProduto=" + valorProduto + ", nomeProduto=" + nomeProduto + ", qtdProduto=" + qtdProduto
				+ "]";
	}
	
	
	
	
	
	
	
	

}
