package be.ucll.bmi.ui.steps;
import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Examination;
import be.ucll.bmi.model.Patient;
import be.ucll.bmi.pages.PatientDetailsPage;
import be.ucll.bmi.pages.PatientsOverviewPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsultPatientDetailsUISteps extends UISteps{
    @Given("patient Tom is registered")
    public void patient_tom_is_registered() {
        // Write code here that turns the phrase above into concrete actions
        Patient patient = Persona.getPatient("Tom");
        context.setPatient(patient);
    }
    @When("Martha requests the patient details of {word}")
    public void martha_requests_the_patient_details_of_tom(String name) {
        // Write code here that turns the phrase above into concrete actions
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        String ssn = Persona.getSsn(name);
        patientDetailsPage.open(ssn);
    }
    @Then("Tom's details should be given")
    public void tom_s_details_should_be_given() {
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        //verifies that the patient details page is open
        assertTrue(patientDetailsPage.isOpen());
        Patient patient = context.getPatient();
        //compares the patient’s social security number to the displayed social security number
        assertEquals(patient.getSocialSecurityNumber(), patientDetailsPage.getSocialSecurityNumber());
        //TODO - compare the patient’s birth date to the birth date that is displayed on the page
        assertEquals(patient.getBirthDate(), patientDetailsPage.getBirthDate());
        //TODO - compare the patient’s gender to the gender that is displayed on the page
        assertEquals(patient.getGender(), patientDetailsPage.getGender());

        Examination examination = patient.getMostRecentExamination();
        //compares the date of the most recent examination to the exam. date that is displayed on the page
        assertEquals(examination.getExaminationDate(), patientDetailsPage.getExaminationDate());
        //TODO - compare the examination’s length to the length that is displayed on the page
        assertEquals(examination.getLength(), patientDetailsPage.getLength());
        //TODO - compare the examination’s weight to the weight that is displayed on the page
        assertEquals(examination.getWeight(), patientDetailsPage.getWeight());
    }
    @Then("Tom's BMI from the last examination should be given")
    public void tom_s_bmi_from_the_last_examination_should_be_given() {
        //TODO - obtain the most recent examination from the patient object that is stored in the context
        Patient patient = context.getPatient();
        Examination mostRecentExamination = patient.getMostRecentExamination();

        //TODO - compare the BMI of this examination to the BMI that is displayed on the details page
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        //verifies that the patient details page is open
        assertTrue(patientDetailsPage.isOpen());
        assertEquals(patientDetailsPage.getBmi(), mostRecentExamination.getBmi());
    }
    @Given("patient Sara is not registered")
    public void patient_sara_is_not_registered() {

    }

    @Then("Martha should be given an error message explaining that the requested patient does not exist")
    public void martha_should_be_given_an_error_message_explaining_that_the_requested_patient_does_not_exist() {
        //TODO - initialize a PatientDetailsPage object
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();

        //TODO - verify that the page is open
        //verifies that the patient details page is open
        assertTrue(patientDetailsPage.isOpen());
        //TODO - obtain the expected message using getMessage(...) and the key patient.does.not.exist
        //TODO - verify that the page displays the message, using assertTrue and page.displaysError(...)
        String expectedMessage = getMessage("patient.does.not.exist");
        assertTrue(patientDetailsPage.displaysError(expectedMessage));
    }

}
