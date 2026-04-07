package finalproject.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    public InventoryPage(WebDriver driver) { this.driver = driver; }

    public void addProductToCart() { driver.findElement(addToCartBtn).click(); }

    public void openCart() { driver.findElement(cartIcon).click(); }

    public String getCartCount() {
        return driver.findElements(cartBadge).size() > 0 ? driver.findElement(cartBadge).getText() : "0";
    }
}