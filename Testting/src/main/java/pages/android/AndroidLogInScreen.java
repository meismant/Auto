package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.HomeInterface;
import pages.interfaces.LogInInterface;

/**
 * Created by mac-250 on 2/23/16.
 */
public class AndroidLogInScreen extends AndroidBaseScreen implements LogInInterface{
    @FindBy (id = "com.beonhome:id/email_edit_text")
    private WebElement emailField;

    @FindBy (id = "com.beonhome:id/password_edit_text")
    private WebElement passwordField;

    @FindBy (id = "com.beonhome:id/login_button")
    private WebElement logInButton;

    @FindBy (id = "android:id/alertTitle")
    private WebElement alertTitle;

    @FindBy (id = "android:id/message")
    private WebElement alertMessage;

    @FindBy (id = "android:id/button3")
    private WebElement alertOkButton;

    public AndroidLogInScreen(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        if ((logInButton != null) && (emailField != null)){
            return true;
        } else return false;
    }

    public LogInInterface fillEmailField(String email){
        emailField.clear();
        try {
            ((AndroidDriver)driver).hideKeyboard();
        } catch (Exception ex){
            logger.info("Can't hide a keyboard");
        }
        emailField.sendKeys(email);
        return this;
    }

    public LogInInterface fillPasswordField(String password){
        passwordField.clear();
        try {
            ((AndroidDriver)driver).hideKeyboard();
        } catch (Exception ex){
            logger.info("Can't hide a keyboard");
        }
        passwordField.sendKeys(password);
        return this;
    }

    public HomeInterface pressLogInButton() {
        logInButton.click();
        try {
            return PageFactory.initElements(driver, AndroidHomeScreen.class);
        } catch (Exception ex){
            return null;
        }
    }


    public LogInInterface clearFields() {
        emailField.clear();
        passwordField.clear();
        try {
            ((AndroidDriver)driver).hideKeyboard();
        } catch (Exception ex){
            logger.info("Can't hide a keyboard");
        }
        return this;
    }

    public String getAlertTitle() {
        return alertTitle.getText();
    }
    public String getAlertMessage() {
        return alertMessage.getText();
    }

    public void pressAlertOkButton(){
        alertOkButton.click();
    }
}
