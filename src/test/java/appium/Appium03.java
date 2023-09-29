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
import java.util.List;

public class Appium03 {

    @Test
    public void appiumTest() throws InterruptedException {

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
        //Eger apilkasyonu izinler atlayarak ana sayfada acilmasini istiyorsanız asagıdaki komutu kullanın
        capabilities.setCapability("noReset",true);
        //capabilities.setCapability("fullReset", true);



        try {
            //AndroidDriver<> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
            driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        System.out.println("app yüklendi");
        driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
        Thread.sleep(3000);
        WebElement homeScreenTitle = (WebElement) driver.findElements(By.id("android:id/title"));
        Thread.sleep(3000);
        Assert.assertTrue(homeScreenTitle.isDisplayed());
        System.out.println("Ana Sayfa Acıldı");

         WebElement testButterDriver =  driver.findElement(By.id("com.davemac327.gesture.tool:id/testButton"));


        //Session Kapat
        driver.quit();

    }

}
