package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            // Options spécifiques à Chrome
            ChromeOptions options = new ChromeOptions();

            // Préférences Chrome
            Map<String, Object> prefs = new HashMap<>();

            // Désactive le service de gestion des identifiants
            prefs.put(
                    "credentials_enable_service",
                    false
            );

            // Désactive le gestionnaire de mots de passe
            prefs.put(
                    "profile.password_manager_enabled",
                    false
            );

            // IMPORTANT :
            // Désactive la détection des mots de passe compromis.
            // C'est cette fonctionnalité qui affiche
            // la popup "Modifiez votre mot de passe".
            prefs.put(
                    "profile.password_manager_leak_detection",
                    false
            );

            // On applique les préférences à Chrome
            options.setExperimentalOption(
                    "prefs",
                    prefs
            );

            // Options supplémentaires pour éviter
            // les mécanismes liés au Password Manager
            options.addArguments(
                    "--disable-save-password-bubble"
            );

            options.addArguments(
                    "--disable-features=PasswordLeakDetection,PasswordManagerLeakDetection"
            );

            // Création du navigateur avec les options
            return new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            return new FirefoxDriver();

        } else {

            throw new IllegalArgumentException(
                    "Navigateur non supporté : " + browser
            );
        }
    }
}