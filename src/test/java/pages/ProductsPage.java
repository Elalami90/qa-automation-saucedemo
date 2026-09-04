package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By pageTitle =
            By.cssSelector("[data-test='title']");

    private By backpackAddButton =
            By.id("add-to-cart-sauce-labs-backpack");

    private By cartBadge =
            By.cssSelector("[data-test='shopping-cart-badge']");

    private By cartLink =
            By.cssSelector("[data-test='shopping-cart-link']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void addBackpackToCart() {
        click(backpackAddButton);
    }

    public String getCartCount() {
        return getText(cartBadge);
    }

    public void openCart() {
        click(cartLink);
    }
}