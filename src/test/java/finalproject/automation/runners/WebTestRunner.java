package finalproject.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "finalproject.automation.steps.web",
        plugin = {
                "pretty",
                "html:build/reports/web-cucumber.html",
                "json:build/reports/web-cucumber.json"
        },
        tags = "@web"
)
public class WebTestRunner extends AbstractTestNGCucumberTests {}