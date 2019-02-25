package ru.stegnin.seleniumtests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUITest {

    WebDriver driver;
    WebDriverWait wait;
    AdminProductPage adminProductPage;
    LoginPage loginPage;
    AddNewProductPage addNewProductPage;

    @BeforeMethod
    public void init() {
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, 5);
        this.adminProductPage = new AdminProductPage(driver, wait);
        this.addNewProductPage = new AddNewProductPage(driver, wait);
        this.loginPage = new LoginPage(driver, wait);
    }


    @AfterMethod
    public void shutdown() {
        driver.quit();
    }

}
