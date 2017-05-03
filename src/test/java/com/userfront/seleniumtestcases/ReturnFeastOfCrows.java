package com.userfront.seleniumtestcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ReturnFeastOfCrows {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testReturnFeastOfCrows() throws Exception {
    driver.get(baseUrl + "/logout");
    driver.get(baseUrl + "/landing");
    driver.findElement(By.linkText("BORROW and REQUEST")).click();
    driver.findElement(By.linkText("Admin Options")).click();
    driver.findElement(By.linkText("Checked Out List")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user1");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//span[text()='A Feast for Crows (A Song of Ice and Fire, Book 4)']")).click();
    driver.findElement(By.xpath("//input[@value='Confirm Book Return']")).click();
    assertTrue(driver.findElement(By.cssSelector("div.panel.panel-primary > div.panel-body")).getText().matches("^[\\s\\S]*A Feast for Crows[\\s\\S]*$"));
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
