package com.userfront.seleniumtestcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MakeReservation {
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
  public void testMakeReservation() throws Exception {
    driver.get(baseUrl + "/logout");
    driver.get(baseUrl + "/landing");
    driver.findElement(By.linkText("BORROW and REQUEST")).click();
    driver.findElement(By.linkText("Reservations")).click();
    driver.findElement(By.linkText("Reserve a Room")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user1");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.cssSelector("i.fa.fa-calendar")).click();
    driver.findElement(By.cssSelector("td.day.active")).click();
    driver.findElement(By.cssSelector("span.hour.active")).click();
    driver.findElement(By.cssSelector("span.minute.active")).click();
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Peter Kiewit Institute");
    driver.findElement(By.cssSelector("i.fa.fa-calendar")).click();
    driver.findElement(By.id("description")).clear();
    driver.findElement(By.id("description")).sendKeys("I am making a reservation at PKI in May to study with my classmates.");
    driver.findElement(By.id("submitAppointment")).click();
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
    assertTrue(driver.findElement(By.cssSelector("div.panel.panel-warning > div.panel-body")).getText().matches("^[\\s\\S]*making a reservation at PKI in May[\\s\\S]*$"));
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
