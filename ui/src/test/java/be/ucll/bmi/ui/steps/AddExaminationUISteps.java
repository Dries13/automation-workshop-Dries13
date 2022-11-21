package be.ucll.bmi.ui.steps;

import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Examination;
import be.ucll.bmi.model.Patient;
import be.ucll.bmi.pages.AddExaminationPage;
import be.ucll.bmi.pages.PatientDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddExaminationUISteps extends UISteps {

    @Given("Martha is viewing the patient file of Tom")
    public void martha_is_viewing_the_patient_file_of_tom() {
        //TODO - initialize a patient details page object
        //TODO - obtain the social security number of patient Tom
        //TODO - open Tom’s patient page
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        String ssn = Persona.getSsn("Tom");
        patientDetailsPage.open(ssn);
    }
    @When("Martha adds a new examination for Tom")
    public void martha_adds_a_new_examination_for_tom() {
        //initializes an examination with any valid details
        //LocalDate date = LocalDate.parse("2022-02-11", DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        Examination examination = new Examination(181, 76000, LocalDate.now() );//Hier date dan
        //TODO - store the examination in the context
        context.setExamination(examination);

        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        //clicks the ‘Go to add examination’ button that is visible on the patient details page
        //returns an object of the AddExaminationPage class
        AddExaminationPage addExaminationPage = patientDetailsPage.goToAddExamination();
        //TODO - fill in the length of the examination on the add examination page
        addExaminationPage.fillInLength(examination.getLength());
        //TODO - fill in the weight of the examination on the add examination page
        addExaminationPage.fillInWeight(examination.getWeight());
        //TODO - fill in the date of the examination on the add examination page
        addExaminationPage.fillInExaminationDate(examination.getExaminationDate());
        //TODO - add the examination, by using the add examination page object
        addExaminationPage.addExamination();
    }
    @Then("the examination should be added to {word}'s examinations")
    public void the_examination_should_be_added_to_tom_s_examinations(String name) {
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        assertTrue(patientDetailsPage.isOpen());
        //TODO - retrieve the examination object from the context
        Examination examination = context.getExamination();
        //TODO - compare the examination’s length to the length that is displayed on the page
        assertEquals(examination.getLength(), patientDetailsPage.getLength());
        //TODO - compare the examination’s weight to the weight that is displayed on the page
        assertEquals(examination.getWeight(), patientDetailsPage.getWeight());
        //TODO - compare the date of the examination to the exam. date that is displayed on the page
        assertEquals(examination.getExaminationDate(), patientDetailsPage.getExaminationDate());
    }
    @Then("the BMI should be recalculated")
    public void the_bmi_should_be_recalculated() {
        //TODO - retrieve the examination from the context
        Examination examination = context.getExamination();
        //TODO - initialize a patient details page object
        PatientDetailsPage patientDetailsPage = new PatientDetailsPage();
        assertTrue(patientDetailsPage.isOpen());
        //TODO - compare the BMI of the examination to the BMI that is displayed on the page
        assertEquals(examination.getBmi(), patientDetailsPage.getBmi());
    }

}
