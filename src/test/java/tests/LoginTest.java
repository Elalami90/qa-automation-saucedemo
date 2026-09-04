package tests;

import base.BaseTest;
import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        assertTrue(
                driver.getCurrentUrl().contains("inventory.html")
        );
    }

    @Test
    public void loginWithInvalidPassword() {

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.INVALID_PASSWORD
        );

        assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match")
        );
    }


    @ParameterizedTest
    @CsvSource({
            "standard_user, wrong_password",
            "wrong_user, secret_sauce",
            "wrong_user, wrong_password"
    })
    public void loginWithInvalidCredentials(
            String username,
            String password) {

        loginPage.login(username, password);

        assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match")
        );
    }


    // Test paramétré : JUnit exécutera cette méthode
    // une fois pour chaque ligne définie dans @CsvSource
    @ParameterizedTest
    @CsvSource({
            "'', secret_sauce, Username is required",
            "standard_user, '', Password is required",
            "'', '', Username is required"
    })
    public void loginWithEmptyFields(
            String username,
            String password,
            String expectedError) {

        // On tente de se connecter avec les données
        // fournies par @CsvSource
        loginPage.login(username, password);

        // On récupère le message affiché par l'application
        // et on vérifie qu'il contient le message attendu
        assertTrue(
                loginPage.getErrorMessage()
                        .contains(expectedError)
        );
    }

}

