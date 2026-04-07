package finalproject.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    By checkoutBtn = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By postalCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");

    public CheckoutPage(WebDriver driver) { this.driver = driver; }

    public void startCheckout() { driver.findElement(checkoutBtn).click(); }

    public void fillForm() {
        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(postalCode).sendKeys("12345");
    }

    public void complete() {
        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();
    }

    public boolean isSuccess() {
        return driver.getPageSource().contains("Thank you for your order");
    }
}