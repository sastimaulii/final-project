package finalproject.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/api",          // lokasi feature file API
        glue = "finalproject.automation.steps.api",           // package step definitions API
        plugin = {
                "pretty",                                         // output di console
                "html:build/reports/cucumber/api-html",          // report HTML
                "json:build/reports/cucumber/api.json"           // report JSON
        },
        tags = "@api"                                         // hanya jalankan scenario dengan tag @api
)
public class ApiTestRunner extends AbstractTestNGCucumberTests {
}