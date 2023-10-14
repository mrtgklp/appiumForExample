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

public class Appium02 {

    @Test
    public void appiumTest() throws MalformedURLException, InterruptedException {

        AppiumDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        //capabilities.setCapability(MobileCapabilityType.APP,"C:Users/ASUS/IdeaProjects/AppiumTechpro/src/Apps/ApiDemos-debug.apk");

        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ASUS/IdeaProjects/AppiumTechpro/src/Apps/gestureTool.apk");
        capabilities.setCapability("appPackage", "com.davemac327.gesture.tool");
        capabilities.setCapability("appActivity", "com.davemac327.gesture.tool.GestureBuilderActivity");


        //AndroidDriver<> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        System.out.println("app yüklendi");

        Thread.sleep(5000);

        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();

        WebElement okButton = driver.findElement(By.xpath("//android.widget.Button[@text='OK']"));
        okButton.click();
        System.out.println("izinler onaylandı");

        WebElement homeScreenTitle = driver.findElement(By.id("android:id/title"));
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana Sayfa Acıldı");

    }

}
