package be.ucll.bmi.model.steps;

import be.ucll.bmi.PatientApplication;
import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Examination;
import be.ucll.bmi.model.Patient;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(classes = PatientApplication.class)
public class ConsultPatientDetailsUnitSteps extends UnitSteps {

    @Before
    public void setUp(){
        reset();
    }


}
