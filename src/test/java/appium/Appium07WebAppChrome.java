package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.apache.hc.client5.http.ContextBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;




public class Appium07WebAppChrome {


    @Test
    public void appiumTest() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60000");

        //chrome driver versiyonunuzu burdan indirebilrisiniz
        //https://chromedriver.storage.googleapis.com/index.html
        //sonrasinda driver in absolute path bir alt satirda tanimliyorsunuz
        capabilities.setCapability("chromedriverExecutable", "C:/Users/ASUS/IdeaProjects/AppiumTechpro/src/driver/chromedriver.exe");

        AppiumDriver driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);


        Thread.sleep(5000);
        driver.get("https://www.amazon.com");

        Thread.sleep(6000);

         /*System.out.println( ((SupportsContextSwitching) driver).getContext() + "<====app acildiginda tur");
        //burda aplikasyonun hangi turleri oldugunu gorem icin getContextHandles() kullaniyoruz.
        Set<String> butunturler = ((SupportsContextSwitching) driver).getContextHandles();
        for (String tur : butunturler) {
            System.out.println(tur);
            if (tur.contains("WEBVIEW_chrome")) {
                ((SupportsContextSwitching) driver).context(tur);
            }
        }
        System.out.println( ((SupportsContextSwitching) driver).getContext() + "<====app sonraki durumu");

          */
       WebElement logo =  driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isEnabled());
        System.out.println("Ana Sayfadayız");

        Thread.sleep(3000);
        //sing butona tıklar
        WebElement singInbutton= driver.findElement(By.id("nav-logobar-greeting"));
        singInbutton.click();

        Thread.sleep(3000);
        //Emailimiz girdik
        WebElement email = driver.findElement(By.xpath("//input[@id='ap_email_login']"));
        email.sendKeys("gokalpmurat1453@gmail.com");
        Thread.sleep(4000);

        WebElement singInTitle = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(singInTitle.isDisplayed());
        System.out.println("Sing in sayfasındasınız");

        Thread.sleep(4000);
        driver.findElement(By.xpath("(//input[@class='a-button-input'])[3]")).click();

        Thread.sleep(3000);
        WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("*******");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

        //close session
        //driver.close();


    }

}
