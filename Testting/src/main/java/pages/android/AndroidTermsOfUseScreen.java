package pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.CreateAccountInterface;
import pages.interfaces.TermsOfUseInterface;

/**
 * Created by mac-250 on 2/25/16.
 */
public class AndroidTermsOfUseScreen extends AndroidBaseScreen implements TermsOfUseInterface{
    @FindBy (id = "com.beonhome:id/agree_button")
    private WebElement agreeButton;

    public AndroidTermsOfUseScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateAccountInterface pressAgreeButton() {
        agreeButton.click();
        return PageFactory.initElements(driver, AndroidCreateAccountScreen.class);
    }
}
