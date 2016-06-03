package tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.interfaces.CreateAccountInterface;
import pages.interfaces.LogInInterface;
import pages.interfaces.TermsOfUseInterface;
import pages.interfaces.WelcomeHomeInterface;

/**
 * Created by mac-250 on 2/29/16.
 */
public class CreateAccountTests extends BaseTest {
    WelcomeHomeInterface welcomePage;
    TermsOfUseInterface termsOfUsePage;
    CreateAccountInterface createAccountPage;

    final String EMAIL = "android@test.com";
    final String PASSWORD = "a";
    final String PHONE = "5857667935";

    @BeforeClass
    public void openPage(){
        logger.info("Running BeforeClass method");
        welcomePage = getWelcomeHomePage();
        termsOfUsePage = welcomePage.pressCreateAccountButton();
        createAccountPage = termsOfUsePage.pressAgreeButton();
    }

    @Test(priority = 0)
    public void createAccountWithEmptyFieldsTest() throws InterruptedException {
        logger.info("Running logInWithEmptyFieldsTest test");
        createAccountPage.pressCreateAccountButton();

        Thread.sleep(3000);
    }
}
