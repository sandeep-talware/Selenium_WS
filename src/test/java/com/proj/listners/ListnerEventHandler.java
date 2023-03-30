package com.proj.listners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.Arrays;

public class ListnerEventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        System.out.println("Before Accepting alert");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        System.out.println("After Accepting alert");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        System.out.println("After Dismiss alert");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        System.out.println("Before Dismiss alert");
    }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigating to URL : " + s);
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("After navigating to URL : " + s);
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Before navigating back");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("After navigating back");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Before navigating forward");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Before navigating forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.println("Before navigating refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("After navigating refresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Before Find Element");
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("After Find Element");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Before Click on Element");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("After Click on Element");
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Before Changing value webelement to : " + Arrays.toString(charSequences));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("After Changing value webelement to : " + Arrays.toString(charSequences));
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) {
        System.out.println("Before Script : " + s);
    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {
        System.out.println("After Script : " + s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occurs : ");
        throwable.printStackTrace();
    }
}
