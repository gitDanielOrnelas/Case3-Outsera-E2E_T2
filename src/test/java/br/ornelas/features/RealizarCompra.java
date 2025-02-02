package br.ornelas.features;

import br.ornelas.pages.CarrinhoPage;
import br.ornelas.pages.CheckoutPage;
import br.ornelas.pages.LoginPage;
import br.ornelas.pages.PagamentoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RealizarCompra {

	private LoginPage loginPage = new LoginPage();
	private CarrinhoPage carrinhoPage = new CarrinhoPage();
	private CheckoutPage checkoutPage = new CheckoutPage();
	private PagamentoPage pagamentoPage = new PagamentoPage();

	@Given("que acesse o site de compras")
	public void que_acesse_o_site_de_compras() {
		loginPage.acessarTelaInicial();
		loginPage.clicarBotaoLogin();
	}

	@And("efetuar o login no sistema")
	public void efetuarLogin() {
		loginPage.setEmail("email", "testecompra@teste.com");
		loginPage.setSenha("password", "123456");
		loginPage.entrar();
	}

	@And("verificar se o login foi realizado")
	public void verificarLogin() {
		loginPage.confirmaLogin();
	}

	@And("validar que o carrinho está vazio")
	public void validarCarrinhoVazio() {
		carrinhoPage.verificarCarrinhoVazio();
	}

	@When("adicionar itens no carrinho")
	public void adicionarItensNoCarrinho() {
		carrinhoPage.adicionarItensNoCarrinho(5); // enviar a quantidade necessária
	}

	@And("ir para o checkout")
	public void irParaCheckout() {
		System.out.println("Indo para o checkout...");
		carrinhoPage.clicarBotaoCart();
		checkoutPage.clicarBotaoCheckout();
		checkoutPage.clicarBotaoPlacerOrder();
	}

	@And("realizar o pagamento")
	public void realizarPagamento() {
		pagamentoPage.preencherDadosPagamento("Daniel Ornelas", "1234567812345678", "311", "12", "2025");
	}

	@Then("devemos validar mensagem com sucesso: {string}")
	public void validarMensagem(String mensagemEsperada) {
		pagamentoPage.validarMensagemDeSucesso(mensagemEsperada);
	}
}