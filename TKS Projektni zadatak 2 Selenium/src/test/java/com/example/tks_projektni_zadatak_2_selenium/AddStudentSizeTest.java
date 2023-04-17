package com.example.tks_projektni_zadatak_2_selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AddStudentSizeTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void addStudentSizeTest() {
        driver.get("http://localhost:4200/");
        vars.put("x", driver.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr")).size());
        driver.findElement(By.linkText("Add Student")).click();
        driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("Vanja Djenadija");
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[2]/input")).sendKeys("vanja@gmail.com");
        driver.findElement(By.cssSelector(".ng-untouched")).click();
        WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
        dropdown.findElement(By.xpath("//option[. = 'B-Tech']")).click();
        driver.findElement(By.cssSelector("option:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.linkText("View Student")).click();
        vars.put("y", driver.findElements(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr")).size());
        vars.put("x", js.executeScript("return arguments[0]+1", vars.get("x")));
        assertEquals(vars.get("y").toString(), vars.get("x").toString());
    }
}