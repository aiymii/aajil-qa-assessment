AAJIL QA Assessment – Automation Project

This repository contains the automation solution for the AAJIL QA Assessment.
The project automates the flight purchase flow on the BlazeDemo sample application.

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
   git clone https://github.com/aiymii/aajil-qa-assessment.git
   cd <aajil-qa-assessment>

5. Running Tests:
  * Right-click testng.xml on Intellij IDE or any preferred IDE → Run
  * Open PurchaseTest.java on IntelliJ IDE > Right-click > Run

6. Test Scenarios Automated
   * TC01 – Boston to Berlin
     Verifies a complete purchase flow from Boston → Berlin

     * TC02 – Paris to Buenos Aires
       Verifies a complete purchase flow from Paris → Buenos Aires

Each test asserts that the confirmation page returns a non-empty status.

7. Tools Used: 

| Tool                   | Purpose                       |
| ---------------------- | ----------------------------- |
| **Selenium WebDriver** | Browser automation            |
| **TestNG**             | Test execution & assertions   |
| **WebDriverManager**   | Auto-manages browser drivers  |
| **Maven**              | Build & dependency management |
| **Java 17**            | Programming language          |

8. Notes
  * The project uses explicit waits for synchronization.
  * The solution follows Page Object Model for clean maintainability.
  * Test data is parameterized inside the test class and can be externally expanded later.

9. Author
   Aiyman Mohammed
   QA Test/Performance Engineer
            
