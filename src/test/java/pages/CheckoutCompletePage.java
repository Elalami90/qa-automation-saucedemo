package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    // Message principal affiché lorsque
    // la commande est terminée avec succès
    private By confirmationMessage =
            By.cssSelector("[data-test='complete-header']");

    public CheckoutCompletePage(WebDriver driver) {

        // Transmission du driver à BasePage
        super(driver);
    }

    // Retourne le message de confirmation
    // affiché après la validation de la commande
    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
}