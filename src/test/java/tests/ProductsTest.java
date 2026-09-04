package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import data.TestData;
import static org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsTest extends BaseTest {


    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    @BeforeEach
    public void login() {

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);

        loginPage.login(
                TestData.VALID_USERNAME,
                TestData.VALID_PASSWORD
        );    }

    @Test
    public void addBackpackToCart() {

        // Vérifier qu'on est bien sur la page Products
        assertEquals(
                "Products",
                productsPage.getPageTitle()
        );

        // Ajouter le produit au panier
        productsPage.addBackpackToCart();

        // Vérifier que le panier contient 1 produit
        assertEquals(
                "1",
                productsPage.getCartCount()
        );

        // Ouvrir le panier
        productsPage.openCart();

        // Vérifier que le bon produit est présent
        assertEquals(
                TestData.BACKPACK_NAME,
                cartPage.getProductName()
        );
    }

    @Test
    public void removeBackpackFromCart() {

        // Ajouter le Backpack depuis la page Products
        productsPage.addBackpackToCart();

        // Vérifier que le compteur du panier passe bien à 1
        assertEquals(
                "1",
                productsPage.getCartCount()
        );

        // Ouvrir le panier
        productsPage.openCart();

        // Vérifier d'abord que le bon produit est présent
        assertEquals(
                TestData.BACKPACK_NAME,
                cartPage.getProductName()
        );

        // Supprimer le produit du panier
        cartPage.removeBackpack();

        // Vérifier que le produit n'est plus présent
        assertFalse(
                cartPage.isProductPresent()
        );
    }
}