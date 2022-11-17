package be.ucll.bmi.service.steps;

import be.ucll.bmi.PatientApplication;
import be.ucll.bmi.data.Persona;
import be.ucll.bmi.service.ServiceException;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.Assert.assertEquals;

@CucumberContextConfiguration
@SpringBootTest(classes = PatientApplication.class)
public class ConsultPatientDetailsIntegrationSteps extends IntegrationSteps {

    @Before
    public void setUp(){
        reset();
    }

    
}
