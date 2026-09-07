package tests;

import base.BaseTest;
import data.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import pages.CheckoutCompletePage;

public class CheckoutTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeEach
    public void prepareCheckout() {

        // Initialisation des Page Objects utilisés dans le scénario
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        // Précondition 1 :
        // Connexion avec un utilisateur valide
        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );

        // Précondition 2 :
        // Ajout du Backpack au panier
        productsPage.addBackpackToCart();

        // Précondition 3 :
        // Ouverture du panier
        productsPage.openCart();

        // Précondition 4 :
        // Accès au Checkout
        cartPage.clickCheckout();
    }

    @Test
    public void checkoutWithValidCustomerInformation() {

        // Saisie des informations client
        checkoutPage.enterFirstName("Mouad");
        checkoutPage.enterLastName("Test");
        checkoutPage.enterPostalCode("92700");

        // Passage à la page de récapitulatif
        checkoutPage.clickContinue();

        // Vérification que nous sommes bien
        // sur la deuxième étape du Checkout
        assertTrue(
                driver.getCurrentUrl()
                        .contains("checkout-step-two.html")
        );

        // Vérification du nom du produit
        // affiché dans le récapitulatif
        assertEquals(
                TestData.BACKPACK_NAME,
                checkoutOverviewPage.getProductName()
        );

        // Vérification du prix du produit
        assertEquals(
                "$29.99",
                checkoutOverviewPage.getProductPrice()
        );

        // Finalisation de la commande depuis la page Overview
        checkoutOverviewPage.clickFinish();

// Vérification que la commande a bien été terminée
        assertEquals(
                "Thank you for your ",
                checkoutCompletePage.getConfirmationMessage()
        );
    }
}