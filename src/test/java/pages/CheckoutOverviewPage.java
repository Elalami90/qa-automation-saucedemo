package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    // Nom du produit affiché dans le récapitulatif
    private By productName =
            By.cssSelector("[data-test='inventory-item-name']");

    // Prix du produit affiché dans le récapitulatif
    private By productPrice =
            By.cssSelector("[data-test='inventory-item-price']");

    // Bouton permettant de finaliser la commande
    private By finishButton =
            By.id("finish");


    public CheckoutOverviewPage(WebDriver driver) {

        // Transmission du driver à BasePage
        super(driver);
    }


    // Retourne le nom du produit affiché
    // dans le récapitulatif de commande
    public String getProductName() {
        return getText(productName);
    }


    // Retourne le prix affiché pour le produit
    public String getProductPrice() {
        return getText(productPrice);
    }


    // Finalise la commande
    public void clickFinish() {
        click(finishButton);
    }
}