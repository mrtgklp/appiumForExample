package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeAppChrome {


    @Test
    public void appiumTest() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");


        //AppiumDriver  driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);

        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



        Thread.sleep(3000);
        driver.get("https://www.amazon.com");

        System.out.println(driver.getContext() + "<====app acildigindaki tur");

        /*Set<String> butunturler = ((SupportsContextSwitching) driver).getContextHandles();
        for (String tur: butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                ((SupportsContextSwitching) driver).context(tur);
            }
        }

         */

        System.out.println(driver.getContext() + "<====degisimden sonraki tur");

        Thread.sleep(5000);
        WebElement homeScreenLoge = driver.findElement(By.xpath("//*[@text='Amazon']"));
        Assert.assertTrue(homeScreenLoge.isDisplayed());
        System.out.println("Ana sayfadayız");
        //System.out.println(driver.getCurrentUrl());


        Thread.sleep(3000);
        WebElement singButton = driver.findElement(By.xpath("//*[@text='Sign in ›']"));
        singButton.click();
        System.out.println("Sing Buton Click Yapıldı");

        Thread.sleep(6000);
        WebElement welcomeText = driver.findElement(By.xpath("//*[@text='Welcome']"));

        Assert.assertEquals(welcomeText.getText(),"Welcome");
        System.out.println("Test Bitti");

        //close session
        driver.close();


    }

}
