package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.DropdownPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends BaseTest {

    private DropdownPage dropdownPage;

    @BeforeEach
    public void initPage() {

        // Initialisation du Page Object
        // avec le driver créé par BaseTest.
        dropdownPage = new DropdownPage(driver);

        /*
         * BaseTest ouvre actuellement SauceDemo
         * grâce au baseUrl de config.properties.
         *
         * Pour cet exercice spécifique,
         * on navigue ensuite vers la page Dropdown.
         */
        driver.get(
                "https://the-internet.herokuapp.com/dropdown"
        );
    }

    @Test
    public void selectOptionTwo() {

        // Sélection de "Option 2".
        dropdownPage.selectOption("Option 2");

        // Vérification que Selenium voit bien
        // "Option 2" comme option sélectionnée.
        assertEquals(
                "Option 2",
                dropdownPage.getSelectedOption()
        );
    }
}