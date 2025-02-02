package br.ornelas.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun  = false, //true = roda em segundo plano
		monochrome = true,
		features = "src/test/resources/feature/RealizarCompra.feature",
		glue = {"br.ornelas.features", "br.ornelas.utilities"}, // .feature com .java
		plugin = {
				"pretty", //aparencia
				"html:target/cucumber-reports.html", "json:target/cucumber.json" 				
		}
)

public class Runner {

}
