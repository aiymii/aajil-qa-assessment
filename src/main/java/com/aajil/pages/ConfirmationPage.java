package com.aajil.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;

public class ConfirmationPage {

    private WebDriverWait wait;

    @FindBy(css = "td:nth-child(2)")
    private List<WebElement> rows;

    public ConfirmationPage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getStatus() {
        wait.until(ExpectedConditions.visibilityOfAllElements(rows));
        return rows.get(1).getText().trim();
    }

    public double getPrice() {
        wait.until(ExpectedConditions.visibilityOfAllElements(rows));
        String raw = rows.get(2).getText().trim(); // Example: "USD 555.00"

        // Extract last numeric value
        String price = raw.replaceAll("[^0-9.]", "");
        return Double.parseDouble(price);
    }
}
