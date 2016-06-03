package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.interfaces.*;

public class LogInTests extends BaseTest {
    WelcomeHomeInterface welcomePage;
    LogInInterface logInPage;
    HomeInterface homePage;

    final String EMAIL = "android@test.com";
    final String PASSWORD = "a";

    @BeforeClass
    public void openPage(){
        logger.info("Start LogIn tests");
        welcomePage = getWelcomeHomePage();

        logInPage = welcomePage.pressLogInButton();
        Assert.assertTrue(logInPage.isPageOpened());
    }

    @BeforeMethod
    public void clear(){
        logger.info("Clear fields before test");
        logInPage.clearFields();
    }

    @Test(priority = 0)
    public void logInWithEmptyFieldsTest() throws InterruptedException {
        logger.info("Start logInWithEmptyFieldsTest");
        logInPage.pressLogInButton();
        Assert.assertTrue(checkErrorMessageWithEmptyFields());
        logInPage.pressAlertOkButton();
        Reporter.log("logInWithEmptyFieldsTest performed successfully");
        Thread.sleep(3000);
    }

    @Test(priority = 1)
    public void logInWithEmptyEmailFieldTest() throws InterruptedException {
        logger.info("Running logInWithEmptyEmailFieldTest test");
        logInPage.fillPasswordField(PASSWORD);
        logInPage.pressLogInButton();
        Assert.assertTrue(checkErrorMessageWithEmptyFields());
        logInPage.pressAlertOkButton();
        Reporter.log("logInWithEmptyFieldsTest performed successfully");
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void logInWithEmptyPasswordFieldTest() throws InterruptedException {
        logger.info("Running logInWithEmptyPasswordFieldTest test");
        logInPage.fillEmailField(EMAIL);
        logInPage.fillPasswordField("");
        logInPage.pressLogInButton();
        Assert.assertTrue(checkErrorMessageWithEmptyFields());
        logInPage.pressAlertOkButton();

        Thread.sleep(3000);
    }

    @Test(priority = 3)
    public void logInWithWrongEmailTest() throws InterruptedException {
        logger.info("Running logInWithWrongEmailTest test");
        logInPage.fillEmailField(EMAIL+"1");
        logInPage.fillPasswordField(PASSWORD);
        logInPage.pressLogInButton();
        Assert.assertTrue(checkErrorMessageWithWrongCredentionals());
        logInPage.pressAlertOkButton();

        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void logInWithWrongPasswordTest()throws InterruptedException{
        logger.info("Running logInWithWrongPasswordTest test");
        logInPage.fillEmailField(EMAIL);
        logInPage.fillPasswordField(PASSWORD+"1");
        logInPage.pressLogInButton();
        Assert.assertTrue(checkErrorMessageWithWrongCredentionals());
        logInPage.pressAlertOkButton();

        Thread.sleep(3000);
    }

    @Test (priority = 5)
    public void logInWithCorrectDataTest() throws InterruptedException {
        logger.info("Running logInWithCorrectDataTest test");
        logInPage.fillEmailField(EMAIL);
        logInPage.fillPasswordField(PASSWORD);
        logInPage.pressLogInButton();

        Thread.sleep(3000);
    }

    private boolean checkErrorMessageWithEmptyFields(){
        logger.info("Running checkErrorMessageWithEmptyFields method");
        if ((logInPage.getAlertTitle().equals("Error"))&&(logInPage.getAlertMessage().equals("Please fill in all fields"))){
            return  true;
        } else return false;
    }

    private boolean checkErrorMessageWithWrongCredentionals(){
        logger.info("Running checkErrorMessageWithWrongCredentionals method");
        if ((logInPage.getAlertTitle().equals("Login Incorrect"))&&(logInPage.getAlertMessage().equals("Please check username and password"))){
            return  true;
        } else return false;
    }
}
