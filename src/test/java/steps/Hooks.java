package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverFactory;

public class Hooks {

    // Driver partagé pendant l'exécution du scénario Cucumber
    public static WebDriver driver;

    @Before
    public void setUp() {

        // Récupération du navigateur depuis config.properties
        String browser = ConfigReader.get("browser");

        // Création du WebDriver grâce à notre DriverFactory existante
        driver = DriverFactory.createDriver(browser);

        // Agrandissement de la fenêtre
        driver.manage().window().maximize();

        // Ouverture de l'application définie dans config.properties
        driver.get(ConfigReader.get("baseUrl"));
    }

    @After
    public void tearDown() {

        // Vérification que le driver existe avant de fermer le navigateur
        if (driver != null) {
            driver.quit();
        }
    }
}