package be.ucll.bmi.ui;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.SpringFactory;
import org.junit.runner.RunWith;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"../patient/src/test/resources/features"},///patient //patient/consult_patient_details.feature
        glue={"be/ucll/bmi/ui", "be/ucll/bmi/config"},
        tags="@UI",
        plugin={"json:target/ui-test.json"},
        objectFactory=SpringFactory.class
)
public class CucumberUITests { }

