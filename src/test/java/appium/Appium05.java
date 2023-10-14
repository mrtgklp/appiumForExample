package appium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium05 {


    @Test
    public void appiumTest() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/ASUS/IdeaProjects/AppiumTechpro/src/Apps/Calculator.apk");


        /**
        URL("http://127.0.0.1:4723/") sürekli değiştirmek zorunda kaldım
        çünkü bazen appium server çalışmadıgı zaman cmd local den appium server açtım bu yüzden /wd/hub baglantısı koymadım

         */
        AppiumDriver  driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);

        Thread.sleep(5000);

        WebElement num1 = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
        WebElement num2 = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
        WebElement num3 = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
        WebElement num4 = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        WebElement num5 = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        WebElement num6 = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
        WebElement num7 = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
        WebElement num8 = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
        WebElement num9 = driver.findElement(By.id("com.google.android.calculator:id/digit_9"));
        WebElement num0 = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));

        WebElement plus = driver.findElement(By.xpath("//android.widget.Button[@content-desc='plus']"));
        WebElement minus = driver.findElement(By.xpath("//android.widget.Button[@content-desc='minus']"));
        //WebElement multipl = driver.findElement(By.xpath("//android.widget.Button[@content-desc='multipl']"));
        WebElement divide = driver.findElement(By.xpath("//android.widget.Button[@content-desc='divide']"));
        WebElement equals = driver.findElement(By.xpath("//android.widget.Button[@content-desc='equals']"));

        //64 + 71

        num6.click();
        num4.click();
        plus.click();
        num7.click();
        num1.click();

        Thread.sleep(3000);

        WebElement preResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
        System.out.println("Pre result " + preResult);
        String preResultText =preResult.getText();
        equals.click();
        Thread.sleep(3000);
        WebElement result = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
        System.out.println("Final result " + result.getText());

        Assert.assertEquals(result.getText(),preResultText);




    }

}
