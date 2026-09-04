package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import utils.ConfigReader;
import utils.DriverFactory;
import utils.ScreenshotExtension;

// Cette extension surveille les tests.
// Si un test échoue, elle déclenchera automatiquement un screenshot.
@ExtendWith(ScreenshotExtension.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {

        // Lecture du navigateur depuis config.properties
        String browser = ConfigReader.get("browser");

        // Création du navigateur via notre Factory
        driver = DriverFactory.createDriver(browser);

        // Agrandissement de la fenêtre
        driver.manage().window().maximize();

        // Ouverture de l'application
        driver.get(ConfigReader.get("baseUrl"));
    }

    /**
     * Permet notamment à ScreenshotExtension
     * de récupérer le WebDriver utilisé par le test.
     */
    public WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void tearDown() {

        // Fermeture du navigateur après chaque test
        if (driver != null) {
            driver.quit();
        }
    }
}