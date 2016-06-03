package pages.android;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.interfaces.BaseScreenInterface;

import java.util.logging.Logger;

/**
 * Created by mac-250 on 2/23/16.
 */
public class AndroidBaseScreen implements BaseScreenInterface {
    protected WebDriver driver;
    protected Logger logger;

    public AndroidBaseScreen(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        logger = Logger.getLogger("new logger");
    }
}
