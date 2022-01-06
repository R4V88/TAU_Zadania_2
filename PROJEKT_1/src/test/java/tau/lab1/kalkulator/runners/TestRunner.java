package tau.lab1.kalkulator.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/functionalTests",
        glue = {"stepDefinitions"},
        publish = true,
        plugin = {
                "pretty",
                "html:target/cucumber-reports/report.html"
        },
        monochrome = true
)
public class TestRunner {
}
