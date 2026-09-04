package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    // Locator de la liste déroulante.
    // Sur la page Herokuapp, l'élément possède l'id "dropdown".
    private By dropdown =
            By.id("dropdown");

    public DropdownPage(WebDriver driver) {

        // Transmission du driver à BasePage.
        super(driver);
    }

    /**
     * Sélectionne une option grâce au texte visible.
     *
     * Exemple :
     * selectOption("Option 2")
     */
    public void selectOption(String optionText) {

        // Récupération de l'élément HTML <select>.
        WebElement dropdownElement =
                driver.findElement(dropdown);

        // Selenium fournit la classe Select
        // spécialement pour les balises HTML <select>.
        Select select =
                new Select(dropdownElement);

        // Sélection de l'option grâce à son texte visible.
        select.selectByVisibleText(optionText);
    }

    /**
     * Retourne le texte de l'option actuellement sélectionnée.
     */
    public String getSelectedOption() {

        // Récupération du <select>.
        WebElement dropdownElement =
                driver.findElement(dropdown);

        // Création de l'objet Select.
        Select select =
                new Select(dropdownElement);

        // getFirstSelectedOption() retourne l'option sélectionnée.
        // getText() récupère son texte visible.
        return select
                .getFirstSelectedOption()
                .getText();
    }
}