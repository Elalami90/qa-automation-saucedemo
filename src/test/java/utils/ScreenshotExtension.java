package utils;

import base.BaseTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class ScreenshotExtension
        implements TestExecutionExceptionHandler {

    /**
     * Cette méthode est appelée par JUnit
     * lorsqu'une exception se produit pendant l'exécution du test.
     *
     * Exemple :
     * assertEquals(...) échoue
     *      ↓
     * cette méthode est appelée
     *      ↓
     * screenshot
     *      ↓
     * l'exception est relancée
     *      ↓
     * le test reste bien en FAIL
     */
    @Override
    public void handleTestExecutionException(
            ExtensionContext context,
            Throwable throwable) throws Throwable {

        // Récupère l'instance du test en cours
        Object testInstance =
                context.getRequiredTestInstance();

        // Vérifie que le test hérite bien de BaseTest
        if (testInstance instanceof BaseTest) {

            BaseTest baseTest =
                    (BaseTest) testInstance;

            // Vérifie que le driver existe encore
            if (baseTest.getDriver() != null) {

                // Nom du test utilisé pour nommer le screenshot
                String testName =
                        context.getDisplayName()
                                .replaceAll("[^a-zA-Z0-9-_]", "_");

                // Screenshot AVANT que @AfterEach ferme Chrome
                ScreenshotUtils.takeScreenshot(
                        baseTest.getDriver(),
                        testName
                );
            }
        }

        /*
         * TRÈS IMPORTANT :
         *
         * On relance l'exception.
         *
         * Sinon JUnit pourrait considérer
         * que nous avons "absorbé" l'erreur.
         *
         * Le test doit rester rouge.
         */
        throw throwable;
    }
}