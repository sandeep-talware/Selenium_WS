package com.proj.tests;

import com.proj.listners.ListnerEventHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListnerEventTest {
    public static void main(String [] hk){
        System.setProperty("webdriver.chrome.driver","E:\\Workspaces\\Eclipse_New\\ListnersSelenium\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        EventFiringWebDriver eventCapture = new EventFiringWebDriver(driver);
        ListnerEventHandler lisnerEventHandle = new ListnerEventHandler();
        eventCapture.register(lisnerEventHandle);
        eventCapture.navigate().to("http://www.google.co.in");
        WebDriverWait wait = new WebDriverWait(eventCapture.getWrappedDriver(),5);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//input[@name='q']")));
        eventCapture.findElement(By.xpath(".//input[@name='q']")).click();
        eventCapture.findElement(By.xpath(".//input[@name='q']")).sendKeys("Selenium");
        eventCapture.findElement(By.xpath(".//input[@name='q']")).sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']")));
        eventCapture.findElement(By.xpath(".//div[@class='FPdoLc lJ9FBc']//input[@value='Google Search']")).click();
        System.out.println(driver.getTitle());
        eventCapture.unregister(lisnerEventHandle);
        driver.quit();
    }
}
