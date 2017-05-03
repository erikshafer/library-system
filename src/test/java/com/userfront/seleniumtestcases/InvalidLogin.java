package com.userfront.seleniumtestcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class InvalidLogin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
      //System.setProperty("webdriver.chrome.driver", "C:/Users/TagnikHome/Downloads/CSCI_4830/chromedriver.exe");
      //WebDriver driver = new ChromeDriver();
	  driver = new FirefoxDriver();
      //driver.get("http://www.google.com");
    baseUrl = "http://localhost:8080/";
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @Test
  public void testInvalidLogin() throws Exception {
    driver.get(baseUrl + "/logout");
    Thread.sleep(2000);
    driver.get(baseUrl + "/index?error");
    Thread.sleep(2000);
    driver.findElement(By.id("username")).clear();
    Thread.sleep(2000);
    driver.findElement(By.id("username")).sendKeys("invaliduser");
    Thread.sleep(2000);
    driver.findElement(By.id("password")).clear();
    Thread.sleep(2000);
    driver.findElement(By.id("password")).sendKeys("invalidpass");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
    assertTrue(driver.findElement(By.cssSelector("div.bg-danger")).getText().matches("^Invalid username[\\s\\S]*$"));
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
