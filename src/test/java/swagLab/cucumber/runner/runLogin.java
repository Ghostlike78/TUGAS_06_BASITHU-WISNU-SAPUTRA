package swagLab.cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/swagLab/cucumber/features",
        glue = "swagLab.cucumber.stepDef",
        plugin = {"html:target/HTML_report.html"},
        tags = "@Login"
)

public class runLogin {
}
