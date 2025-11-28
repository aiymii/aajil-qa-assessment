package com.aajil.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ReservePage extends BasePage {

    @FindBy(css = "input.btn-small")
    private List<WebElement> flightButtons;

    public ReservePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void chooseFlight(int flightSeq) {

        wait.until(ExpectedConditions.visibilityOfAllElements(flightButtons));

        if (flightSeq < 0 || flightSeq >= flightButtons.size()) {
            throw new IllegalArgumentException(
                    "Invalid flight index " + flightSeq +
                            ". Available flights: " + flightButtons.size()
            );
        }

        WebElement button = flightButtons.get(flightSeq);

        js.executeScript("arguments[0].scrollIntoView(true);", button);
        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();
    }
}
