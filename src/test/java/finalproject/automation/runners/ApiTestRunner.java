package finalproject.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/api",
        glue = "finalproject.automation.steps.api",
        plugin = {
                "pretty",
                "html:build/reports/api-cucumber.html",
                "json:build/reports/api-cucumber.json"
        },
        tags = "@api"
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {}