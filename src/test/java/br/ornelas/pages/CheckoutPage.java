package br.ornelas.pages;

import static br.ornelas.core.Web.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

	public void clicarBotaoCheckout() {

		WebElement botaoCheckout = getDriver().findElement(By.cssSelector(".btn.btn-default.check_out"));
		botaoCheckout.click();
	}

	public void clicarBotaoPlacerOrder() {
		WebElement botao = getDriver().findElement(By.cssSelector("a[href='/payment'].btn.btn-default.check_out"));
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", botao);
		wait.until(ExpectedConditions.elementToBeClickable(botao));
		botao.click();
	}
}
