package org.nahulemes.pom.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.nahulemes.pom.base.BasePage;
import org.openqa.selenium.support.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("http://localhost:3000/")
public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id='email']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//*[@id='password']")
    private WebElementFacade passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElementFacade signInButton;

    public void loginAs(String email, String password) {
        emailInput.waitUntilVisible().type(email);
        passwordInput.waitUntilVisible().type(password);
        clickWhenReady(signInButton);
    }
}
