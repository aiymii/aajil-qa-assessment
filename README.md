AAJIL QA Assessment – Automation Project

* This repository contains the automation solution for the AAJIL QA Assessment.
* The project automates the flight purchase flow on the BlazeDemo sample application.

1. Project Overview

This automation suite validates the end-to-end purchase flow:

1. Select origin city
2. Select destination city
3. Search for flights
4. Choose the first available flight
5. Fill the purchase form
6. Submit the purchase
7. Verify confirmation message/status

The automated tests are written using:
* Java
* Selenium WebDriver
* TestNG
* Page Object Model (POM)
* Maven

Application Under Test (AUT):
http://www.blazedemo.com/

2. Project Structure

src
 └── main
     └── java
         └── com.aajil.pages
             ├── BasePage.java
             ├── ConfirmationPage.java
             ├── HomePage.java
             ├── PurchasePage.java
             └── ReservePage.java

 └── test
     └── java
         └── com.aajil.tests
             ├── BaseTest.java
             └── PurchaseTest.java

3. Prerequisites
Install the following:
1. Java 17
2. Maven
3. Git
4. IntelliJ IDE / Other IDE
5. Chrome Browser (Latest version)

4. Cloning This Project:
   git clone https://github.com/aiymanmohammed/aajil-qa-assessment.git
   cd <aajil-qa-assessment>

5. Running Tests:
  * Right-click testng.xml on Intellij IDE or any preferred IDE → Run
  * Open PurchaseTest.java on IntelliJ IDE > Right-click > Run

6. Test Scenarios Automated
 Each test calls purchaseEndToEnd with different inputs to match the assessment:

* TC01_Boston_Berlin_Flight2
Input: dept="Boston", dest="Berlin", seq=2
Expect valid booking, status="PendingCapture", price > 100

* TC02_AllRandom
Input: dept=null, dest=null, seq=null
All parameters random
Expect valid booking, status="PendingCapture", price > 100

* TC03_Boston_Boston_Flight1
Input: dept="Boston", dest="Boston", seq=1
Expect invalid input
Test is annotated with expectedExceptions = IllegalArgumentException.class
This covers the “inputs sanitised and wrong input throws exception” requirement

* TC04_Paris_Berlin_Flight0_RandomFlight
Input: dept="Paris", dest="Berlin", seq=0
Zero means “ignore and choose random flight”
Expect valid booking, status="PendingCapture", price > 100

* TC05_CustomInputs_SanDiego_NewYork_Flight3
Input: custom departure, destination, and flight sequence
Demonstrates easy reuse of purchaseEndToEnd for arbitrary test data

Each test asserts that the confirmation page returns a non-empty status.

7. Waiting and synchronisation
   * No implicit waits
   * Single shared WebDriverWait in BasePage
     Used for:\
     * dropdown visibility before selecting
     * flight results table visibility
     * “Choose This Flight” button clickability
     * confirmation table visibility
    * For Chrome 142 stability:
      JavascriptExecutor scrolls the “Choose This Flight” button into view before clicking

8. Locator strategy
   Prefer stable attributes:
* Dropdowns – By.name("fromPort"), By.name("toPort")
* Flight rows – css: table.table tbody tr
* Flight button – row.findElement(By.cssSelector("input.btn"))
* Confirmation – css: td:nth-child(2) table cells

No fragile XPaths that depend on absolute indexes.


9. Tools Used: 

| Tool                   | Purpose                       |
| ---------------------- | ----------------------------- |
| **Selenium WebDriver** | Browser automation            |
| **TestNG**             | Test execution & assertions   |
| **WebDriverManager**   | Auto-manages browser drivers  |
| **Maven**              | Build & dependency management |
| **Java 17**            | Programming language          |

10. Notes
  * The project uses explicit waits for synchronization.
  * The solution follows Page Object Model for clean maintainability.
  * Test data is parameterized inside the test class and can be externally expanded later.

11. Author

Aiyman Mohammed

QA Test/Performance Engineer
            
