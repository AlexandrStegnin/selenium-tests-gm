package ru.stegnin.seleniumtests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddNewProductPageTest extends BaseUITest {

    @DataProvider(name = "failProducts")
    public Object[][] failData() {
        return new Object[][]{
                {"Телевизоры", "00000020", "TV Sony", "TV Sony 55", "Nice TV Sony 55", "67000"},
                {"Телевизоры", "00000022", "TV", "TV Sony 55", "Nice TV Sony 55", "67000"},
                {"Телевизоры", "00000022", "TV Sony", "TV Sony 55", "Nice TV Sony 55", ""}
        };
    }

    @DataProvider(name = "successProducts")
    public Object[][] successData() {
        return new Object[][]{
                {"Телевизоры", "00000023", "TV Sony", "TV Sony 55", "Nice TV Sony 55", "67000"},
                {"Ноутбуки", "00000024", "Notebook HP", "Notebook HP 15", "Nice Notebook HP 15", "110000"},
                {"Телевизоры", "00000025", "Notebook LG", "Notebook LG 13", "Nice Notebook LG 13", "98000"}
        };
    }

    @BeforeMethod
    public void logIn() {
        loginPage.go();
        loginPage.fillAndSubmitAuthForm("admin", "100");
        wait.until(ExpectedConditions.titleIs("Administration"));
        adminProductPage.go();
        wait.until(ExpectedConditions.titleIs("Admin products"));
        adminProductPage.showAddNewProductForm();
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "failProducts")
    public void testAddNewProductFail(String category, String vendorCode, String title,
                                      String shortDescr, String fullDescr, String price) {
        addNewProductPage.fillProductPage(category, vendorCode, title, shortDescr, fullDescr, price);
        addNewProductPage.saveProduct();
        Assert.assertTrue(addNewProductPage.isErrorExists());
    }

    @Test(dataProvider = "successProducts")
    public void testAddNewProductSuccess(String category, String vendorCode, String title,
                                         String shortDescr, String fullDescr, String price) {
        addNewProductPage.fillProductPage(category, vendorCode, title, shortDescr, fullDescr, price);
        addNewProductPage.saveProduct();
        Assert.assertTrue(adminProductPage.isNotificationShowed());
    }

}
