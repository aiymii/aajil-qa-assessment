package com.aajil.tests;

import com.aajil.pages.*;
import org.testng.annotations.Test;

import java.util.Random;

public class PurchaseTest extends BaseTest {

    public String purchaseEndToEnd(String deptCity, String destCity, Integer flightSeq) {

        if (deptCity != null && destCity != null && deptCity.equals(destCity)) {
            System.out.println(" Invalid input: Departure and destination cannot be the same. ");
            throw new IllegalArgumentException("Invalid input: Departure and destination cannot be the same.");
        }

        HomePage home = new HomePage(driver);
        home.open();

        if (deptCity == null) deptCity = home.getRandomDeparture();
        if (destCity == null) destCity = home.getRandomDestination();

        home.selectFromCity(deptCity);
        home.selectToCity(destCity);
        home.clickFindFlights();

        if (flightSeq == null) flightSeq = new Random().nextInt(5);

        ReservePage reserve = new ReservePage(driver);
        reserve.chooseFlight(flightSeq);

        PurchasePage purchase = new PurchasePage(driver);
        purchase.fillForm("TestUser");
        purchase.clickPurchase();

        ConfirmationPage confirm = new ConfirmationPage(driver, wait);

        String status = confirm.getStatus();
        double price = confirm.getPrice();

        if (!status.equalsIgnoreCase("PendingCapture")) {
            throw new RuntimeException("Status Failed: " + status);
        }

        if (price <= 100.00) {
            throw new RuntimeException("Price Failed: " + price);
        }

        return status;
    }


    @Test
    public void TC01_Boston_Berlin_Flight2() {
        purchaseEndToEnd("Boston", "Berlin", 2);
    }

    @Test
    public void TC02_AllRandom() {
        purchaseEndToEnd(null, null, null);
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = ".*cannot be the same.*")
    public void TC03_Boston_Boston_Flight1() {
        purchaseEndToEnd("Boston", "Boston", 1);
    }


    @Test
    public void TC04_Paris_Berlin_Flight0() {
        purchaseEndToEnd("Paris", "Berlin", 0);
    }

    @Test
    public void TC05_CustomInputs_SanDiego_NewYork_Flight3() {
        purchaseEndToEnd("San Diego", "New York", 3);
    }
}
