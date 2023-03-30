package com.proj.basic;

import com.proj.Util.excelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class Elements {

	public static WebElement locateElement(WebDriver driver, String fileName, String objName) throws Exception {
		WebElement elem = driver.findElement(Elements.getByObject(fileName, objName));
		return elem;
	}

	public static By getByObject(String fileName, String objName) throws Exception {
		HashMap<String, String> hs = new HashMap<String, String>();
		hs = excelUtility.getLocatorInfo(fileName, objName);
		String locatorName = hs.get("locatorProperties");
		String locatorValue = hs.get("locatorValue");
		By ByObject;
		if (locatorName.equalsIgnoreCase("classname")) {
			ByObject = By.className(locatorValue);
		} else if (locatorName.equalsIgnoreCase("id")) {
			ByObject = By.id(locatorValue);
		} else if (locatorName.equalsIgnoreCase("name")) {
			ByObject = By.name(locatorValue);
		} else if (locatorName.equalsIgnoreCase("xpath")) {
			ByObject = By.xpath(locatorValue);
		} else if (locatorName.equalsIgnoreCase("cssselector")) {
			ByObject = By.cssSelector(locatorValue);
		} else if (locatorName.equalsIgnoreCase("linktext")) {
			ByObject = By.linkText(locatorValue);
		} else if (locatorName.equalsIgnoreCase("partiallinktext")) {
			ByObject = By.partialLinkText(locatorValue);
		} else if (locatorName.equalsIgnoreCase("tagname")) {
			ByObject = By.tagName(locatorValue);
		} else {
			throw new Exception("No Valid Locator");
		}
		return ByObject;
	}

	public static List<WebElement> locateElements(WebDriver driver, String fileName, String objName) throws Exception {
		List<WebElement> elems = driver.findElements(Elements.getByObject(fileName, objName));
		return elems;
	}
}
