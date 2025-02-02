package br.ornelas.pages;

import static br.ornelas.core.Web.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ornelas.core.BasePage;

public class LoginPage extends BasePage {

	public void acessarTelaInicial() {
		getDriver().get("https://automationexercise.com");
	}

	public void clicarBotaoLogin() {
		clicarBotao(By.xpath("//a[contains(text(), 'Signup')]"));
	}

	public void setEmail(String name, String email) {
		escrever(By.name(name), email);
	}

	public void setSenha(String name, String senha) {
		escrever(By.name(name), senha);
	}

	public void entrar() {
		clicarBotaoPorTexto("Login");
	}

	public void confirmaLogin() {

		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		try {
			WebElement elemento = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(), 'Logout')]")));
			System.out.println("Login confirmado!");
		} catch (Exception e) {
			System.out.println("Login pode ter falhado.");
		}
	}
}
