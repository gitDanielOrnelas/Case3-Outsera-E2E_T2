package br.ornelas.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) { // Apenas cria um novo driver se não existir - usei o Driver v132
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\User\\OneDrive\\Documentos\\Automação\\chromedriver-win64 - v132\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options); // Armazena a instância única

			// driver.manage().window().maximize();
		}
		return driver; // Retorna a mesma instância sempre
	}

	public static void killDriver() {
	    if (driver != null) {
	        try {
	            driver.quit();
	        } catch (Exception e) {
	            System.out.println("Erro ao tentar fechar o WebDriver: " + e.getMessage());
	        } finally {
	            driver = null;
	        }
	    }
	}
}
