package ru.stegnin.seleniumtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeleniumTestsApplicationTests {

    @Test
    public void contextLoads() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.close();
        driver.quit();

    }

}
