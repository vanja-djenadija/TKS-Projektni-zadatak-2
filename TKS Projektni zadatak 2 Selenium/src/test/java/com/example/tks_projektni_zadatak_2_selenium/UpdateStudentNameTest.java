package com.example.tks_projektni_zadatak_2_selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UpdateStudentNameTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();
    }

    @Test
    public void updateStudentNameTest() {
        driver.get("http://localhost:4200/");
        driver.findElement(By.linkText("Add Student")).click();
        driver.findElement(By.cssSelector(".form-group:nth-child(1) > .form-control")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[1]/input")).sendKeys("Vanja Djenadija");
        driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[2]/input")).sendKeys("vanja@gmail.com");
        WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-add-student/div[1]/div[2]/div/form/div[3]/select"));
        dropdown.findElement(By.xpath("//option[. = 'B-Tech']")).click();
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.linkText("View Student")).click();
        driver.findElement(By.cssSelector(".btn-info")).click();
        driver.findElement(By.cssSelector(".form-group:nth-child(2) > .form-control")).click();
        driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[1]/input")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[1]/input")).sendKeys("Vanja Đenadija");
        driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[2]/input")).clear();
        driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[2]/input")).sendKeys("vanja.djenadija@gmail.com");
        driver.findElement(By.cssSelector(".ng-untouched:nth-child(2)")).click();
        dropdown = driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[2]/div/div/form/div[2]/div[1]/div[3]/select"));
        dropdown.findElement(By.xpath("//option[. = 'M-Tech']")).click();
        driver.findElement(By.cssSelector(".btn-success")).click();
        driver.findElement(By.cssSelector(".btn-danger")).click();
        assertThat(driver.findElement(By.xpath("/html/body/app-root/div/app-student-list/div[1]/div[2]/div/table/tbody/tr/td[1]")).getText(), is("Vanja Đenadija"));
    }
}