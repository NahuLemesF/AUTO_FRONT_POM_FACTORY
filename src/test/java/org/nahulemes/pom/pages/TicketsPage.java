package org.nahulemes.pom.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.nahulemes.pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TicketsPage extends BasePage {

    @FindBy(xpath = "//a[@href='/tickets/new']")
    private WebElementFacade createTicketButton;

    public void waitUntilLoaded() {
        waitUntilUrlContains("/tickets");
        createTicketButton.waitUntilClickable();
    }

    public void openCreateTicketForm() {
        clickWhenReady(createTicketButton);
    }

    public void shouldContainTicketTitle(String ticketTitle) {
        By ticketTitleLocator = By.xpath("//*[contains(normalize-space(.),'" + ticketTitle + "')]");
        waitForCondition().until(ExpectedConditions.visibilityOfElementLocated(ticketTitleLocator));
        waitUntilVisible(ticketTitleLocator).shouldBeVisible();
    }
}
