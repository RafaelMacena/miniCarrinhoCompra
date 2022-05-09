package br.com.rafaelmacena.carrinho;

import java.util.List;
import java.util.Scanner;

public class MainCartaoCredito {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		CartaoCredito cartao = new CartaoCredito();

		Compra compra = new Compra();
		compra.setFormaPagamento(FormaPagamento.Credito);

		System.out.println("Informe o nome impresso no cartâo ? ");
		cartao.setNomeImpressoNoCartao(in.nextLine());

		System.out.println("Informe o numero do catão? ");
		cartao.setNumeroDoCartao(Integer.valueOf(in.nextLine()));

		System.out.println("Informe o código do cartão? ");
		cartao.setCodigoDoCartao(Integer.valueOf(in.nextLine()));

		System.out.println("Informe o limite do cartão? ");
		cartao.setLimite(Double.valueOf(in.nextLine()));

		System.out.println("Informe a bandeira do Cartão? ");
		cartao.setBandeiraDoCartao(in.nextLine());

		for (int i = 0; i < 3; i++) {
			Produto produto = new Produto();

			System.out.println("Informe o nome do produto? ");
			produto.setNomeProduto(in.nextLine());

			System.out.println("Informe a quantidade de produto? ");
			produto.setQtdProduto(Integer.valueOf(in.nextLine()));

			System.out.println("Informe o valor do produto? ");
			produto.setValorProduto(Integer.valueOf(in.nextLine()));

			compra.adicionarProduto(produto);
			compra.calcularValorDaCompra();

		}
		System.out.println("Quantas parcelas? ");
		compra.setQtdParcelas(in.nextInt());

		boolean temLimite = cartao.temLimite(compra);
		if (temLimite) {
			List<Parcela> parcelas = cartao.efetuarPagamento(compra);
			exibirInformacoes(cartao, compra, parcelas);

		} else {
			System.out.println("Ocorreu um problema ao efetuar seu pagamento.");
		}

	}

	private static void exibirInformacoes(CartaoCredito cartao, Compra compra, List<Parcela> parcelas) {
		System.out.println("dados do cliuente ");

		System.out.println("Nome " + cartao.getNomeImpressoNoCartao());
		System.out.println("Número do cartão " + cartao.getNumeroDoCartao());
		System.out.println("Limite atual do cartao " + cartao.getLimite());
		System.out.println("==============================================");

		System.out.println("Dados da compra");
		System.out.println(compra);
		System.out.println("==============================================");

		System.out.println("Pacelas");
		System.out.println(parcelas);
	}

}
