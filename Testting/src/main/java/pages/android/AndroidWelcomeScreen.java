package pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.LogInInterface;
import pages.interfaces.TermsOfUseInterface;
import pages.interfaces.WelcomeHomeInterface;

/**
 * Created by mac-250 on 2/23/16.
 */
public class AndroidWelcomeScreen extends AndroidBaseScreen implements WelcomeHomeInterface{

    @FindBy (id = "com.beonhome:id/create_account_button")
    private WebElement createAccountButton;

    @FindBy (id = "com.beonhome:id/login_button")
    private WebElement logInButton;

    @FindBy (id = "com.beonhome:id/beon_marketplace_textview")
    private WebElement marketPlaceLnk;

    public AndroidWelcomeScreen(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver, this);
    }

    public boolean isPageOpened(){
        return createAccountButton.getText().toString().contains("Create Account");
    }

    public TermsOfUseInterface pressCreateAccountButton() {
        createAccountButton.click();
        return  PageFactory.initElements(driver, AndroidTermsOfUseScreen.class);
    }

    public LogInInterface pressLogInButton(){
        logInButton.click();
        return PageFactory.initElements(driver, AndroidLogInScreen.class);
    }

    public void pressMarketPlaceLink() {
        marketPlaceLnk.click();
    }
}
