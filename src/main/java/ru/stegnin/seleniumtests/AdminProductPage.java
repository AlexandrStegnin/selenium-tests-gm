package ru.stegnin.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminProductPage extends BaseActions {

    private static final String PRODUCT_PAGE_URL = "http://localhost:8189/wintermarket/admin/products";
    private static final By ADD_NEW_BTN = By.cssSelector("#add_product");
    private static final By NOTIFICATION_WINDOW = By.cssSelector("#action_status");
    private static final By PROGRESS_BAR = By.cssSelector(".v-loading-indicator.first");


    public AdminProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void go() {
        driver.get(PRODUCT_PAGE_URL);
    }

    public void showAddNewProductForm() {
        driver.findElement(ADD_NEW_BTN).click();
    }

    public boolean isNotificationShowed() {
        return isElementPresent(NOTIFICATION_WINDOW);
    }

}
