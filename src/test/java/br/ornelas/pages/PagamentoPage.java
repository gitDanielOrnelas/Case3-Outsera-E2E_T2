package br.ornelas.pages;

import static br.ornelas.core.Web.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PagamentoPage {

	public void preencherDadosPagamento(String nome, String numeroCartao, String cvc, String mesValidade,
			String anoValidade) {
		// Localizar e preencher o campo "Nome no Cartão"
		WebElement nomeNoCartao = getDriver().findElement(By.name("name_on_card"));
		nomeNoCartao.sendKeys(nome);

		// Localizar e preencher o campo "Número do Cartão"
		WebElement numeroCartaoCampo = getDriver().findElement(By.name("card_number"));
		numeroCartaoCampo.sendKeys(numeroCartao);

		// Localizar e preencher o campo "CVC"
		WebElement cvcCampo = getDriver().findElement(By.name("cvc"));
		cvcCampo.sendKeys(cvc);

		// Localizar e preencher o campo "Mês de Validade"
		WebElement mesValidadeCampo = getDriver().findElement(By.name("expiry_month"));
		mesValidadeCampo.sendKeys(mesValidade);

		// Localizar e preencher o campo "Ano de Validade"
		WebElement anoValidadeCampo = getDriver().findElement(By.name("expiry_year"));
		anoValidadeCampo.sendKeys(anoValidade);

		// Localizar e clicar no botão "Pay and Confirm Order"
		WebElement botaoConfirmar = getDriver()
				.findElement(By.cssSelector(".form-control.btn.btn-primary.submit-button"));
		botaoConfirmar.click();
	}

	public void validarMensagemDeSucesso(String mensagemEsperada) {

		WebElement mensagem = getDriver()
				.findElement(By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]"));

		String textoMensagem = mensagem.getText();

		Assert.assertEquals("Mensagem de sucesso não encontrada!", "Congratulations! Your order has been confirmed!",
				mensagemEsperada);
	}

}
