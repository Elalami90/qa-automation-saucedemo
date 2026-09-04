package runner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite

// Indique à JUnit qu'on veut utiliser le moteur Cucumber
@IncludeEngines("cucumber")

// Indique où se trouvent les fichiers .feature
// Ici : src/test/resources/features
@SelectClasspathResource("features")

// Indique à Cucumber où chercher les Step Definitions et les Hooks
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "steps"
)

// Améliore l'affichage des résultats Cucumber dans la console
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty"
)
public class CucumberTest {

    // Cette classe reste vide.
    //
    // Son rôle est uniquement de configurer
    // l'exécution de Cucumber avec JUnit.
}