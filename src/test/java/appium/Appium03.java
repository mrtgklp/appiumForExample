package appium;

import io.appium.java_client.AppiumClientConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium03 {

    @Test
    public void appiumTest() throws MalformedURLException, InterruptedException {


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


        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        // Android için kilidi açma

        if (driver instanceof AndroidDriver) {
            AndroidDriver androidDriver = (AndroidDriver) driver;
            androidDriver.unlockDevice();
        }


        System.out.println("app yüklendi");
        Thread.sleep(5000);
        WebElement homeScreenTitle = driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana Sayfa Acıldı");

        WebElement testButterDriver = driver.findElement(By.id("com.davemac327.gesture.tool:id/testButton"));
        testButterDriver.click();
        System.out.println("test button");


        WebElement testGestureTitle = driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(testGestureTitle.isDisplayed());
        System.out.println("test screen acıldı");

        //Session Kapat
        driver.quit();

    }

}
