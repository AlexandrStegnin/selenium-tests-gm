package ru.stegnin.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewProductPage extends BaseActions {

    public static final By ADD_NEW_PRODUCT_FORM = By.cssSelector("#crud_dialog");
    private static final By CATEGORY_FIELD = By.cssSelector("#category_combo");
    private static final By VENDOR_CODE_FIELD = By.cssSelector("#vendor_code_fld");
    private static final By TITLE_FIELD = By.cssSelector("#title_fld");
    private static final By SHORT_DESCR_FIELD = By.cssSelector("#short_descr_fld");
    private static final By FULL_DESCR_FIELD = By.cssSelector("#full_descr_fld");
    private static final By PRICE_FIELD = By.cssSelector("#price_fld");
    private static final By SAVE_BTN = By.cssSelector("#save_btn");
    private static final By CANCEL_BTN = By.cssSelector("#cancel_btn");
    private static final By ERROR_MESSAGE = By.cssSelector("#vaadin-text-field-error-11");


    public AddNewProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillProductPage(String category, String vendorCode, String title, String shortDescr, String fullDescr, String price) {
        typeInField(CATEGORY_FIELD, category);
        typeInField(VENDOR_CODE_FIELD, vendorCode);
        typeInField(TITLE_FIELD, title);
        typeInField(SHORT_DESCR_FIELD, shortDescr);
        typeInField(FULL_DESCR_FIELD, fullDescr);
        typeInField(PRICE_FIELD, price);
    }

    public void saveProduct() {
        driver.findElement(SAVE_BTN).click();
    }

    public boolean isErrorExists() {
        String invalidVendorCode = (String) ((JavascriptExecutor) driver)
                .executeScript("return document.getElementById('vendor_code_fld').getAttribute('invalid');");
        String invalidTitle = (String) ((JavascriptExecutor) driver)
                .executeScript("return document.getElementById('title_fld').getAttribute('invalid');");
        String invalidPrice = (String) ((JavascriptExecutor) driver)
                .executeScript("return document.getElementById('price_fld').getAttribute('invalid');");
        return invalidVendorCode != null ||
                invalidTitle != null ||
                invalidPrice != null;
    }

}
