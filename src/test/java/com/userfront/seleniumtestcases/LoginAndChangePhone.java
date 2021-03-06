package com.userfront.seleniumtestcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class LoginAndChangePhone {
    private WebDriver driver;
    private String baseUrl = "http://localhost:8080/";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private final static String driverLocation = "lib/chromedriver.exe";

  @BeforeClass
  public static void init() {
	  System.setProperty("webdriver.chrome.driver", "C:/Users/TagnikHome/Downloads/CSCI_4830/chromedriver.exe");
  }
  
  @Before
  public void setUp() throws Exception {        
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-web-security");
      
      DesiredCapabilities capabilities = DesiredCapabilities.chrome();
      capabilities.setCapability("binary", driverLocation);
      capabilities.setCapability(ChromeOptions.CAPABILITY, options);
      
      driver = new ChromeDriver(capabilities);
      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
  }

  @Test
  public void testLoginAndChangePhone() throws Exception {
    driver.get(baseUrl + "/landing");
    driver.findElement(By.cssSelector("img[alt=\"login\"]")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("user1");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("user1");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Me")).click();
    driver.findElement(By.linkText("Profile")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [isEditable | id=phone | ]]
    driver.findElement(By.id("phone")).clear();
    driver.findElement(By.id("phone")).sendKeys("402-123-5555");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.linkText("Me")).click();
    driver.findElement(By.linkText("Profile")).click();
    driver.findElement(By.linkText("Me")).click();
    assertEquals("402-123-5555", driver.findElement(By.id("phone")).getAttribute("value"));
    driver.findElement(By.linkText("Logout")).click();
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
