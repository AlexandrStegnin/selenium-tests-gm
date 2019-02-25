package ru.stegnin.seleniumtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseActions {

    private static final String LOGIN_PAGE_URL = "http://localhost:8189/wintermarket/login";
    private static final By USER_NAME_FIELD = By.cssSelector("#user_name_field");
    private static final By PASSWORD_FIELD = By.cssSelector("#pwd_field");
    private static final By LOGIN_BTN = By.cssSelector("#login_btn");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void go() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void fillAndSubmitAuthForm(String login, String password) {
        typeInField(USER_NAME_FIELD, login);
        typeInField(PASSWORD_FIELD, password);
        submitForm();
    }

    private void submitForm() {
        driver.findElement(LOGIN_BTN).click();
    }

}
