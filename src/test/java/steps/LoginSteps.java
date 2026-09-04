package steps;

import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    // Page Object permettant d'interagir avec la page Login
    private LoginPage loginPage;


    @Given("l'utilisateur est sur la page de connexion")
    public void utilisateurEstSurLaPageDeConnexion() {

        // Le navigateur a déjà été créé et ouvert par Hooks @Before.
        // On transmet le même driver à notre LoginPage.
        loginPage = new LoginPage(Hooks.driver);
    }


    @When("l'utilisateur se connecte avec des identifiants valides")
    public void utilisateurSeConnecteAvecDesIdentifiantsValides() {

        // On réutilise exactement le Page Object
        // que nous avions créé avant Cucumber.
        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );
    }


    @Then("l'utilisateur doit accéder à la page des produits")
    public void utilisateurDoitAccederALaPageDesProduits() {

        // Vérification du résultat attendu.
        // JUnit est toujours utilisé pour l'assertion.
        assertTrue(
                Hooks.driver.getCurrentUrl()
                        .contains("inventory.html")
        );
    }
}