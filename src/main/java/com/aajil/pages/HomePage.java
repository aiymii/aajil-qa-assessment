package com.aajil.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {

    @FindBy(name = "fromPort")
    private WebElement fromDropdown;

    @FindBy(name = "toPort")
    private WebElement toDropdown;

    @FindBy(css = "input.btn-primary")
    private WebElement findFlightsBtn;

    @FindBy(name = "fromPort")
    private WebElement fromPort;

    @FindBy(name = "toPort")
    private WebElement toPort;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://blazedemo.com");
    }

    public void selectFromCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(fromPort));
        Select select = new Select(fromPort);
        select.selectByVisibleText(city);
    }

    public void selectToCity(String city) {
        wait.until(ExpectedConditions.visibilityOf(toPort));
        Select select = new Select(toPort);
        select.selectByVisibleText(city);
    }

    public void clickFindFlights() {
        click(findFlightsBtn);
    }

    public String getRandomDeparture() {
        Select s = new Select(fromPort);
        int size = s.getOptions().size();
        return s.getOptions().get(new Random().nextInt(size)).getText();
    }

    public String getRandomDestination() {
        Select s = new Select(toPort);
        int size = s.getOptions().size();
        return s.getOptions().get(new Random().nextInt(size)).getText();
    }
}
