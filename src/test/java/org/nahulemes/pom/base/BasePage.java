package org.nahulemes.pom.base;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class BasePage extends PageObject {

    protected void waitUntilUrlContains(String fragment) {
        waitForCondition().until(ExpectedConditions.urlContains(fragment));
    }

    protected WebElementFacade waitUntilVisible(By locator) {
        waitForCondition().until(ExpectedConditions.visibilityOfElementLocated(locator));
        return find(locator);
    }

    protected void clickWhenReady(WebElementFacade element) {
        element.waitUntilClickable().click();
    }
}
