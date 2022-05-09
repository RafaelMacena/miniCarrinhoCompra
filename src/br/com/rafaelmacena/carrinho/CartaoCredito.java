package br.com.rafaelmacena.carrinho;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CartaoCredito {

	private static final int PERCENTUALTOTAL_100 = 100;
	private static final double JUROS_4_5 = 4.5;
	private static final double JUROS_2_75 = 2.75;
	private static final int PRAZO_18 = 18;
	private final int QTDDEPARCELASSEMJUROS = 10;
	private String nomeImpressoNoCartao;
	private int numeroDoCartao;
	private String bandeiraDoCartao;
	private int codigoDoCartao;
	private double limite;

	public CartaoCredito() {

	}

	public CartaoCredito(String nomeImpressoNoCartao, int numeroDoCartao, String bandeiraDoCartao, int codigoDoCartao,
			double limite) {

		this.nomeImpressoNoCartao = nomeImpressoNoCartao;
		this.numeroDoCartao = numeroDoCartao;
		this.bandeiraDoCartao = bandeiraDoCartao;
		this.codigoDoCartao = codigoDoCartao;
		this.limite = limite;
	}

	public String getNomeImpressoNoCartao() {
		return nomeImpressoNoCartao;
	}

	public void setNomeImpressoNoCartao(String nomeImpressoNoCartao) {
		this.nomeImpressoNoCartao = nomeImpressoNoCartao;
	}

	public int getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(int numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public String getBandeiraDoCartao() {
		return bandeiraDoCartao;
	}

	public void setBandeiraDoCartao(String bandeiraDoCartao) {
		this.bandeiraDoCartao = bandeiraDoCartao;
	}

	public int getCodigoDoCartao() {
		return codigoDoCartao;
	}

	public void setCodigoDoCartao(int codigoDoCartao) {
		this.codigoDoCartao = codigoDoCartao;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public Boolean temLimite(Compra compra) {

		if (compra.getValorCompra() > limite) {
			return false;

		}
		else {
			return true;			
		}

	}
	
	public List<Parcela> efetuarPagamento(Compra compra){
		
		if(compra.getQtdParcelas() <= QTDDEPARCELASSEMJUROS) {
		    limite = limite - compra.getValorCompra();
			return calcularParcelas(compra.getValorCompra(), compra.getQtdParcelas());
		}
		else if(compra.getQtdParcelas() > QTDDEPARCELASSEMJUROS && compra.getQtdParcelas() <= PRAZO_18) {
			double valorCompraComjuros = ((compra.getValorCompra() / PERCENTUALTOTAL_100) * JUROS_2_75) + compra.getValorCompra();
			limite = limite - valorCompraComjuros;
			return calcularParcelas(valorCompraComjuros, compra.getQtdParcelas());
		}
		else {
			double valorCompraComJuros = ((compra.getValorCompra() / PERCENTUALTOTAL_100) * JUROS_4_5) + compra.getValorCompra();
			limite = limite - valorCompraComJuros;
			return calcularParcelas(valorCompraComJuros, compra.getQtdParcelas());
		}
	}
	
	private List<Parcela> calcularParcelas(Double valorCompra, Integer qtdParcelas){
		List<Parcela> parcelas = new ArrayList<>();
		Double valorTotalParcela = valorCompra / qtdParcelas;
		Date hoje = new Date();
		for (int i = 0; i < qtdParcelas; i++) {
			Parcela parcela = new Parcela();
			parcela.setValor(valorTotalParcela);
			parcela.setNumero(i + 1);
			parcela.setDataVencimento(hoje); //TODO calcular data de vencimento
			parcelas.add(parcela);
		}
		return parcelas;
	}

}
