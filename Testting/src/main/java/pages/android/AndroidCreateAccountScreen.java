package pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.CreateAccountInterface;
import pages.interfaces.HomeInterface;

/**
 * Created by mac-250 on 2/29/16.
 */
public class AndroidCreateAccountScreen extends AndroidBaseScreen implements CreateAccountInterface {
    @FindBy (id = "com.beonhome:id/email_edit_text")
    private WebElement emailFiled;

    @FindBy (id = "com.beonhome:id/password_edit_text")
    private WebElement passwordField ;

    @FindBy (id = "com.beonhome:id/re_entered_password_edit_text")
    private WebElement reEnterPasswordField ;

    @FindBy (id = "com.beonhome:id/phone_number_edit_text")
    private WebElement phoneNumberField;

    @FindBy (id = "com.beonhome:id/create_account_button")
    private WebElement  createAccountButton;

    public AndroidCreateAccountScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return createAccountButton.getText().toString().contains("Create Account");
    }

    public CreateAccountInterface fillEmailField(String email) {
        emailFiled.clear();
        emailFiled.sendKeys(email);
        return this;
    }

    public CreateAccountInterface fillPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public CreateAccountInterface fillReenterPasswordField(String reEnterPassword) {
        reEnterPasswordField.clear();
        reEnterPasswordField.sendKeys(reEnterPassword);
        return this;
    }

    public CreateAccountInterface fillPhoneNumberField(String phoneNumber) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
        return this;
    }

    public HomeInterface pressCreateAccountButton() {
        createAccountButton.click();
        return PageFactory.initElements(driver, AndroidHomeScreen.class);
    }
}
