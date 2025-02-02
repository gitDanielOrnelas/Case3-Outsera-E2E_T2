package br.ornelas.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

import br.ornelas.core.Web;
import io.cucumber.java.After;

public class Hooks extends Web {

	@After
	public void screenshot(io.cucumber.java.Scenario sc) {
	    try {
	        TakesScreenshot ts = (TakesScreenshot) getDriver();
	        File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

	        // Criando diretório de screenshots se não existir
	        File destino = new File("target/cucumber-reports/screenshots/" + sc.getName() + ".png");
	        destino.getParentFile().mkdirs();

	        Files.copy(screenshotFile, destino);

	        // Anexando no relatório (via caminho do arquivo)
	        sc.attach(Files.toByteArray(destino), "image/png", "Screenshot: " + sc.getName());

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
