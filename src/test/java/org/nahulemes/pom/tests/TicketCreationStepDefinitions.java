package org.nahulemes.pom.tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TicketCreationStepDefinitions {

    @Steps
    private TicketCreationSteps ticketCreationSteps;

    @Given("the admin opens the application")
    public void theAdminOpensTheApplication() {
        ticketCreationSteps.openApplication();
    }

    @When("the admin logs in with valid credentials")
    public void theAdminLogsInWithValidCredentials() {
        ticketCreationSteps.loginAsAdmin();
    }

    @When("the admin opens the ticket creation form")
    public void theAdminOpensTheTicketCreationForm() {
        ticketCreationSteps.openTicketCreationForm();
    }

    @When("the admin completes the required ticket fields")
    public void theAdminCompletesTheRequiredTicketFields() {
        ticketCreationSteps.completeRequiredFields();
    }

    @When("the admin saves the ticket")
    public void theAdminSavesTheTicket() {
        ticketCreationSteps.saveTicket();
    }

    @Then("the ticket should be visible in the tickets listing")
    public void theTicketShouldBeVisibleInTheTicketsListing() {
        ticketCreationSteps.validateTicketCreationInUi();
    }
}
