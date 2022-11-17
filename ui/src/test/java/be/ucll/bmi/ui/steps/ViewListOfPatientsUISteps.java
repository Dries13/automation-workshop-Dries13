package be.ucll.bmi.ui.steps;

import be.ucll.bmi.PatientApplication;
import be.ucll.bmi.model.Patient;
import be.ucll.bmi.pages.PatientsOverviewPage;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.List;

import static org.junit.Assert.assertTrue;

@CucumberContextConfiguration
@SpringBootTest(classes=PatientApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ViewListOfPatientsUISteps extends UISteps {

    @LocalServerPort
    private int port;

    @Value("${chrome.driver.location}")
    private String chromeDriverLocation;

    @Value("${base.url}")
    private String baseUrl;

    @Before
    public void setUp() {
        initializeTest(baseUrl, port, chromeDriverLocation);
    }

    @After
    public void tearDown() {
        tearDownTest();
    }


}

