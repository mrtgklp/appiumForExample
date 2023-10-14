package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium04 {

    @Test
    public void appiumTest() throws MalformedURLException {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ASUS/IdeaProjects/AppiumTechpro/src/Apps/gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");
        capabilities.setCapability("noReset", true);
        //capabilities.setCapability("fullReset", true);


        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);


        System.out.println("app yüklendi");
        WebElement homeScreenTitle = driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana Sayfa Acıldı");



        //Session Kapat
        driver.quit();

    }

}
