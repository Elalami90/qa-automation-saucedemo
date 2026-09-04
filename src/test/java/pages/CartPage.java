package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    // Locator permettant de récupérer le nom du produit présent dans le panier
    private By cartItemName =
            By.cssSelector("[data-test='inventory-item-name']");

    // Locator du bouton permettant de supprimer le Backpack du panier
    private By removeBackpackButton =
            By.id("remove-sauce-labs-backpack");

    // Bouton Checkout permettant de commencer le processus de commande
    private By checkoutButton =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        // On transmet le driver à BasePage
        super(driver);
    }

    // Retourne le nom du produit présent dans le panier
    public String getProductName() {
        return getText(cartItemName);
    }

    // Supprime le Backpack du panier
    public void removeBackpack() {
        click(removeBackpackButton);
    }

    // Clique sur Checkout pour passer à l'étape suivante
    public void clickCheckout() {
        click(checkoutButton);
    }

    // Vérifie si le produit est encore présent dans le panier
    public boolean isProductPresent() {
        return !driver.findElements(cartItemName).isEmpty();
    }
}