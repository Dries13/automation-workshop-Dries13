package be.ucll.bmi.model;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.SpringFactory;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/features"},
        glue={"be/ucll/bmi/model", "be/ucll/bmi/config"},
        tags="@Unit",
        plugin={"json:target/unit-test.json"},
        objectFactory=SpringFactory.class
)
public class CucumberUnitTests {
}
