package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotUtils {

    /**
     * Prend une capture d'écran du navigateur.
     *
     * @param driver   le WebDriver actuellement utilisé
     * @param testName nom du test, utilisé pour nommer le fichier
     */
    public static void takeScreenshot(
            WebDriver driver,
            String testName) {

        // WebDriver est converti en TakesScreenshot
        // afin d'accéder à la fonction getScreenshotAs().
        TakesScreenshot screenshot =
                (TakesScreenshot) driver;

        // Selenium crée temporairement la capture
        // sous forme de fichier.
        File source =
                screenshot.getScreenshotAs(OutputType.FILE);

        try {

            // Dossier dans lequel seront stockées
            // toutes nos captures d'écran.
            Path screenshotDirectory =
                    Paths.get("screenshots");

            // Création du dossier s'il n'existe pas encore.
            Files.createDirectories(screenshotDirectory);

            // Construction du chemin final :
            // screenshots/nomDuTest.png
            Path destination =
                    screenshotDirectory.resolve(
                            testName + ".png"
                    );

            // Copie de la capture Selenium
            // vers notre dossier screenshots.
            Files.copy(
                    source.toPath(),
                    destination,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING
            );

            System.out.println(
                    "Screenshot enregistré : "
                            + destination
            );

        } catch (IOException e) {

            throw new RuntimeException(
                    "Impossible d'enregistrer le screenshot",
                    e
            );
        }
    }
}