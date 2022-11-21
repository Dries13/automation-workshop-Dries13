package be.ucll.bmi.model.steps;

import be.ucll.bmi.data.Persona;
import be.ucll.bmi.model.Examination;
import be.ucll.bmi.model.Patient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddExaminationUnitSteps extends UnitSteps {


    @Given("Martha has chosen to add a new examination for Tom")
    public void martha_has_chosen_to_add_a_new_examination_for_tom() {
        //TODO - obtain Tom’s patient information from the Persona’s
        //TODO - store Tom’s patient object in the context
        Patient patient = Persona.getPatient("Tom");
        context.setPatient(patient);

        //creates a new examination with valid details
        Examination examination = new Examination(180, 78000, LocalDate.now());
        context.setExamination(examination);
    }
    @When("Martha registers {int} cm as length")
    public void martha_registers_cm_as_length(Integer length) {
        //TODO - retrieve the examination from the context
        Examination examination = context.getExamination();
        //TODO - set the length of the examination to the length parameter
        examination.setLength(length);
        //TODO - retrieve the patient from the context
        Patient patient = context.getPatient();
        //TODO - add the examination to the patient
        patient.addExamination(examination);

        //Later toegevoegd
        List<String> errors = validatePatient(patient);
        context.setErrors(errors);
    }
    @Then("the examination should be added to {word}'s examinations")
    public void the_examination_should_be_added_to_tom_s_examinations(String name) {
        //TODO - retrieve the expected examination from the context
        Examination examination = context.getExamination();
        //TODO - retrieve the patient from the context
        Patient patient = context.getPatient();
        //TODO - retrieve the most recent examination from the patient
        Examination recent = patient.getMostRecentExamination();
        //TODO - compare the expected examination to the most recent examination
        assertEquals(recent, examination);
    }

    @Then("Martha should be given an error message about the invalid length")
    public void martha_should_be_given_an_error_message_about_the_invalid_length() {
        List<String> errors = context.getErrors();
        assertEquals(1, errors.size());
        assertEquals("length.should.be.between.30.and.300.cm", errors.get(0));
    }

    //Weight
    @When("Martha registers {int} gr as weight")
    public void martha_registers_gr_as_weight(Integer weight) {
        //TODO - retrieve the examination from the context
        Examination examination = context.getExamination();

        examination.setWeight(weight);
        //TODO - retrieve the patient from the context
        Patient patient = context.getPatient();
        //TODO - add the examination to the patient
        patient.addExamination(examination);

        //Later toegevoegd
        List<String> errors = validatePatient(patient);
        context.setErrors(errors);
    }

    @Then("Martha should be given an error message about the invalid weight")
    public void martha_should_be_given_an_error_message_about_the_invalid_weight() {
        List<String> errors = context.getErrors();
        assertEquals(1, errors.size());
        assertEquals("weight.should.be.between.1000.and.300000.gr", errors.get(0));
    }
}
