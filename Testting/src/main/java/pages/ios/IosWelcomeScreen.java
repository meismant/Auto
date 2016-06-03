package pages.ios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.interfaces.LogInInterface;
import pages.interfaces.TermsOfUseInterface;
import pages.interfaces.WelcomeHomeInterface;

/**
 * Created by mac-250 on 3/17/16.
 */
public class IosWelcomeScreen implements WelcomeHomeInterface {
    @FindBy (id = "com.beonhome:id/create_account_button")
    private WebElement createAccountButton;

    @FindBy (id = "com.beonhome:id/login_button")
    private WebElement logInButton;

    @FindBy (id = "com.beonhome:id/beon_marketplace_textview")
    private WebElement marketPlaceLnk;


    public TermsOfUseInterface pressCreateAccountButton() {
        return null;
    }

    public LogInInterface pressLogInButton() {
        return null;
    }

    public void pressMarketPlaceLink() {

    }
}
