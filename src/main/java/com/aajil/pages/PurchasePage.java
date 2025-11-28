package com.aajil.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PurchasePage extends BasePage {

    @FindBy(id = "inputName")
    private WebElement nameField;

    @FindBy(css = "input.btn-primary")
    private WebElement purchaseBtn;

    public PurchasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String name) {
        type(nameField, name);
    }

    public void clickPurchase() {
        click(purchaseBtn);
    }
}
