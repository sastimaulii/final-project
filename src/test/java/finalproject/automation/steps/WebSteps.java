package finalproject.automation.steps.web;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import finalproject.automation.pages.LoginPage;
import finalproject.automation.pages.InventoryPage;
import finalproject.automation.pages.CheckoutPage;
import finalproject.automation.utils.DriverManager;
import org.testng.Assert;

public class WebSteps {

    WebDriver driver = DriverManager.getDriver();
    LoginPage login = new LoginPage(driver);
    InventoryPage inventory = new InventoryPage(driver);
    CheckoutPage checkout = new CheckoutPage(driver);

    @Given("user open login page")
    public void open() { login.open(); }

    @When("user login valid")
    public void loginValid() { login.login("standard_user", "secret_sauce"); }

    @When("user login invalid")
    public void loginInvalid() { login.login("wrong", "wrong"); }

    @Then("login success")
    public void success() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
        DriverManager.quitDriver();
    }

    @Then("error appears")
    public void error() {
        Assert.assertTrue(login.isError());
        DriverManager.quitDriver();
    }

    @Given("user login successfully")
    public void loginSuccess() {
        login.open();
        login.login("standard_user", "secret_sauce");
    }

    @When("user add product to cart")
    public void addCart() { inventory.addProductToCart(); }

    @Then("cart badge should show {int}")
    public void cartCount(int count) { Assert.assertEquals(inventory.getCartCount(), String.valueOf(count)); }

    @When("user proceed checkout")
    public void checkout() {
        inventory.openCart();
        checkout.startCheckout();
    }

    @When("user fill checkout data")
    public void fill() {
        checkout.fillForm();
        checkout.complete();
    }

    @Then("order success")
    public void orderSuccess() {
        Assert.assertTrue(checkout.isSuccess());
        DriverManager.quitDriver();
    }
}