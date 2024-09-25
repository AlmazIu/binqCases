package org.example.binqcases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        //\\ Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bing.com/");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("searchInputCase")
    public void search() {

        System.out.println("inputField..");
        WebElement searchField = driver.findElement(By.cssSelector("#sb_form_q"));
        System.out.println("ok");

        System.out.println("searchInput..");
        searchField.sendKeys("Selenium");
        System.out.println("ok");

        System.out.println("submit..");
        WebElement submitButton = driver.findElement(By.cssSelector("#search_icon"));
        submitButton.click();
        System.out.println("ok");

        System.out.println("checkInput..");
        WebElement searchPageField = driver.findElement(By.cssSelector("#sb_form_q"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
        System.out.println("ok");
    }
}
