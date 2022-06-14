package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;

public class BaseClass {


    AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void setup(){

        try {

            DesiredCapabilities caps = new DesiredCapabilities();

            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
            caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
            caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
            //caps.setCapability(MobileCapabilityType.APP, "");
            caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

            URL url = new URL("http://127.0.0.1:4723/wd/hub");

            //driver = new AppiumDriver(url, caps);
            driver = new AndroidDriver<>(url, caps);

        }catch (Exception exp){
            System.out.println("Cause is : "+exp.getCause());
            System.out.println("Message is :"+exp.getMessage());
            exp.printStackTrace();
        }

    }

    @Test
    public void sampleTest(){
        System.out.println("GOGO");
    }

    @AfterClass
    public void teardown(){
        driver.close();
        driver.quit();
    }
}
