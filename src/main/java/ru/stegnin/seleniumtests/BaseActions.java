package ru.stegnin.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseActions {

    WebDriver driver;
    WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void typeInField(By by, String msg) {
        WebElement element = driver.findElement(by);
        element.sendKeys(msg);
        element.sendKeys(Keys.TAB);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

}
