package pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.HomeInterface;

/**
 * Created by mac-250 on 2/25/16.
 */
public class AndroidHomeScreen extends AndroidBaseScreen implements HomeInterface{
    @FindBy (id = "com.beonhome:id/security_lighting_button")
    private WebElement securityLightingButton;

    @FindBy (id = "com.beonhome:id/welcome_home_button")
    private WebElement welcomeHomeButton;

    @FindBy (id = "com.beonhome:id/safety_lighting_button")
    private WebElement safetyLightingButton;

    public AndroidHomeScreen(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


}
