package br.ornelas.pages;

import static br.ornelas.core.Web.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ornelas.core.BasePage;

public class CarrinhoPage extends BasePage {

	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	public void clicarBotaoCart() {
		clicarBotao(By.xpath("//a[contains(text(), 'Cart')]"));
	}

	public void verificarCarrinhoVazio() {
		clicarBotaoCart();
		removerTodosItensCarrinho();
	}

	public void removerTodosItensCarrinho() {

		try {
			// Espera a presença de pelo menos um botão "cart_quantity_delete"
			List<WebElement> botoesRemover = wait
					.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("cart_quantity_delete")));

			if (!botoesRemover.isEmpty()) {
				System.out.println("Existem " + botoesRemover.size() + " itens no carrinho. Removendo...");

				for (WebElement botao : botoesRemover) {
					try {
						botao.click();
						Thread.sleep(1000); // Pequena espera, para evitar problemas na remoção
					} catch (Exception e) {
						System.out.println("Falha no botão " + e.getMessage());
					}
				}
				System.out.println("Produtos removidos do carrinho");
			} else {
				System.out.println("o carrinho já está vazio");
			}
		} catch (Exception e) {
			System.out.println("Nada a fazer...");
		}

		clicarBotao(By.linkText("here")); // para continuar após esvaziar o carrinho
	}

	public void adicionarItensNoCarrinho(int quantidadeAleatoria) {
		// Loop para adicionar a quantidade de itens desejada
		for (int i = 1; i <= quantidadeAleatoria; i++) {
			try {
				// Localizando o botão de adicionar ao carrinho pelo data-product-id
				WebElement botao = getDriver()
						.findElement(By.cssSelector("a[data-product-id='" + i + "'].btn.btn-default.add-to-cart"));

				// Espera o botão estar clicável
				wait.until(ExpectedConditions.elementToBeClickable(botao));

				// Rolar até o botão
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", botao);

				// Clicar no botão de adicionar ao carrinho
				botao.click();
				Thread.sleep(1000); // Pausa entre os cliques

				System.out.println("Clicado no produto " + i + " de " + quantidadeAleatoria);

				// Clicar no botão "continue shopping" para continuar o looping
				clicarNoBotaoContinueShopping();
			} catch (Exception e) {
				System.out.println("Erro ao clicar no botão " + i + ": " + e.getMessage());
			}
		}
	}

	public void clicarNoBotaoContinueShopping() {

		// Espera o modal aparecer (div com a classe modal-dialog modal-confirm)
		WebElement aguardandoDiv = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-dialog.modal-confirm")));

		// Espera o botão "Continue Shopping" ser clicável
		WebElement botao = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='btn btn-success close-modal btn-block' or text()='Continue Shopping']")));
		botao.click();
	}
}
