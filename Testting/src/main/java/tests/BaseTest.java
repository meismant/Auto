package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.android.AndroidWelcomeScreen;
import pages.interfaces.WelcomeHomeInterface;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by mac-250 on 2/24/16.
 */
public class BaseTest {

    protected static WebDriver driver;
    private String iOSPathToApp = "/Users/mac/Desktop/beonhome.ipa";
    private String androidPathToApp = "/Users/mac/Desktop/beonhome-preview-release-1.0.44.apk";

    private  static Properties prop;
    protected enum OsType {
        ANDROID,
        IOS
    }
    protected OsType osType;

    static Logger logger = LogManager.getLogger(BaseTest.class.getName());

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DOMConfigurator.configure("log4j.xml");

        prop = new Properties();
        DesiredCapabilities caps = new DesiredCapabilities();
        File app;

        try {
            prop.load(new FileReader(new File("config.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if ("Android".equals(prop.getProperty("PLATFORM_NAME"))){
            osType = OsType.ANDROID;
            logger.info("Launching the app on Android");

            app = new File(androidPathToApp);

            caps.setCapability(MobileCapabilityType.APP, app);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PLATFORM_VERSION"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));

            try{
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            } catch (MalformedURLException e){
                e.printStackTrace();
            }

            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } else if ("iOS".equals("iOS".equals(prop.getProperty("PLATFORM_NAME")))){
            logger.info("Launching the app on iOS");
            osType = OsType.IOS;

            app = new File(iOSPathToApp);

            caps.setCapability(MobileCapabilityType.APP, app);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PLATFORM_NAME"));
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PLATFORM_VERSION"));
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DEVICE_NAME"));
            caps.setCapability(MobileCapabilityType.UDID, prop.getProperty("UDID"));

            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps) ;
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            System.out.println(prop.getProperty("PLATFORM_NAME") + " doesn't supported");
        }
    }

    @AfterSuite
    public void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    protected OsType getOsType() {
        return osType;
    }

    protected WelcomeHomeInterface getWelcomeHomePage() {
        if (osType == OsType.ANDROID) {
            return PageFactory.initElements(driver, AndroidWelcomeScreen.class);
        }
        else
            if(osType==osType.IOS){
               // PageFactory.initElements(driver, IOSWelcomePage.class);
            }
        return null;
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static Logger getLogger(){
        return logger;
    }
}
