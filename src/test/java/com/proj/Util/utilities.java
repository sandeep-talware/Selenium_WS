package com.proj.Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class utilities {
	public static String getProperties(String propName) {
		String propValue = null;
		try{
			InputStream input = new FileInputStream("Properties\\config.properties");
            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            propValue=prop.getProperty(propName);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return propValue;	
}

	public static WebDriver setdriver(String browserName) {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", utilities.getProperties("FIREFOX_DRIVER"));
			driver=new FirefoxDriver();
			return driver;
		}
		else if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", utilities.getProperties("CHROME_DRIVER"));
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		}else {
			System.setProperty("webdriver.ie.driver", utilities.getProperties("IE_DRIVER"));
			driver=new InternetExplorerDriver();
			return driver;
		}
	}
}
