package org.nahulemes.pom.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.nahulemes.pom.base.BasePage;
import org.openqa.selenium.support.FindBy;

public class TicketFormPage extends BasePage {

    @FindBy(xpath = "//*[@id='ticket-title']")
    private WebElementFacade titleInput;

    @FindBy(xpath = "//*[@id='ticket-description']")
    private WebElementFacade descriptionTextArea;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade saveButton;

    public void waitUntilReady() {
        titleInput.waitUntilVisible();
        descriptionTextArea.waitUntilVisible();
    }

    public void completeRequiredFields(String title, String description) {
        titleInput.waitUntilVisible().clear();
        titleInput.type(title);
        descriptionTextArea.waitUntilVisible().clear();
        descriptionTextArea.type(description);
    }

    public void submit() {
        clickWhenReady(saveButton);
    }
}
