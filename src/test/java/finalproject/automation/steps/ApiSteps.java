package finalproject.automation.steps.api;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

public class ApiSteps {

    private static final String APP_ID = "63a804408eb0cb069b57e43a";
    private Response response;

    @Given("user call get user by id {string}")
    public void getUserById(String id) {
        response = RestAssured
                .given()
                .header("app-id", APP_ID)
                .get("https://dummyapi.io/data/v1/user/" + id);
    }

    @Then("response status code should be {int}")
    public void statusCode(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    @Then("response body should contain {string}")
    public void responseBody(String key) {
        Assert.assertTrue(response.getBody().asString().contains(key));
    }

    @Given("user create user")
    public void createUser() {
        response = RestAssured
                .given()
                .header("app-id", APP_ID)
                .header("Content-Type", "application/json")
                .body("{\"firstName\":\"Test\",\"lastName\":\"User\",\"email\":\"testuser@example.com\"}")
                .post("https://dummyapi.io/data/v1/user/create");
    }

    @Given("user call get tags")
    public void getTags() {
        response = RestAssured
                .given()
                .header("app-id", APP_ID)
                .get("https://dummyapi.io/data/v1/tag");
    }

    @Given("user call get user with invalid id {string}")
    public void getInvalidUser(String id) {
        response = RestAssured
                .given()
                .header("app-id", APP_ID)
                .get("https://dummyapi.io/data/v1/user/" + id);
    }
}