package co.com.tns.atdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
					features = {"src/test/cucumber/"},
					glue={"co.com.tns.feature"})
public class CucumberConfig {
	
}