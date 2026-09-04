package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    // Champ prénom
    private By firstNameField =
            By.id("first-name");

    // Champ nom
    private By lastNameField =
            By.id("last-name");

    // Champ code postal
    private By postalCodeField =
            By.id("postal-code");

    // Bouton permettant de passer à l'étape suivante
    private By continueButton =
            By.id("continue");


    public CheckoutPage(WebDriver driver) {
        // On transmet le driver à BasePage
        super(driver);
    }


    // Saisie du prénom dans le champ first-name
    public void enterFirstName(String firstName) {
        type(firstNameField, firstName);
    }


    // Saisie du nom dans le champ last-name
    public void enterLastName(String lastName) {
        type(lastNameField, lastName);
    }


    // Saisie du code postal dans le champ postal-code
    public void enterPostalCode(String postalCode) {
        type(postalCodeField, postalCode);
    }


    // Clic sur le bouton Continue
    public void clickContinue() {
        click(continueButton);
    }

    // Retourne la valeur réellement présente dans le champ prénom
    public String getFirstNameValue() {
        return driver.findElement(firstNameField)
                .getAttribute("value");
    }

    // Retourne la valeur réellement présente dans le champ nom
    public String getLastNameValue() {
        return driver.findElement(lastNameField)
                .getAttribute("value");
    }

    // Retourne la valeur réellement présente dans le champ code postal
    public String getPostalCodeValue() {
        return driver.findElement(postalCodeField)
                .getAttribute("value");
    }
}