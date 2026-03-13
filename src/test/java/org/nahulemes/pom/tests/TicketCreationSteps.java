package org.nahulemes.pom.tests;

import net.serenitybdd.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.nahulemes.pom.pages.LoginPage;
import org.nahulemes.pom.pages.TicketFormPage;
import org.nahulemes.pom.pages.TicketsPage;
import org.nahulemes.pom.utils.TicketDataFactory;

public class TicketCreationSteps extends ScenarioSteps {

    private static final String ADMIN_EMAIL = "admin@sofkau.com";
    private static final String ADMIN_PASSWORD = "Admin@SofkaU_2026!";

    private LoginPage loginPage;
    private TicketsPage ticketsPage;
    private TicketFormPage ticketFormPage;

    private String createdTicketTitle;

    @Step("Open application in login page")
    public void openApplication() {
        loginPage.open();
    }

    @Step("Login as admin user")
    public void loginAsAdmin() {
        loginPage.loginAs(ADMIN_EMAIL, ADMIN_PASSWORD);
        ticketsPage.waitUntilLoaded();
    }

    @Step("Open ticket creation form")
    public void openTicketCreationForm() {
        ticketsPage.openCreateTicketForm();
        ticketFormPage.waitUntilReady();
    }

    @Step("Complete required ticket fields")
    public void completeRequiredFields() {
        createdTicketTitle = TicketDataFactory.uniqueTitle();
        String ticketDescription = TicketDataFactory.descriptionFor(createdTicketTitle);
        ticketFormPage.completeRequiredFields(createdTicketTitle, ticketDescription);
    }

    @Step("Save ticket")
    public void saveTicket() {
        ticketFormPage.submit();
    }

    @Step("Validate ticket is visible in listing")
    public void validateTicketCreationInUi() {
        ticketsPage.waitUntilLoaded();
        ticketsPage.shouldContainTicketTitle(createdTicketTitle);
    }
}
