package finalproject.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/web",
        glue = "finalproject.automation.steps.web",
        plugin = {
                "pretty",
                "html:build/reports/cucumber/web-html",
                "json:build/reports/cucumber/web.json"
        },
        tags = "@web"
)
public class WebTestRunner extends AbstractTestNGCucumberTests {
}