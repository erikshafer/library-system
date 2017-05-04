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

public class PublicFindHobbitBook {
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
  public void testPublicFindHobbitBook() throws Exception {
    driver.get(baseUrl + "/logout");
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("BORROW and REQUEST")).click();
    driver.findElement(By.linkText("Books")).click();
    driver.findElement(By.linkText("All Books")).click();
    driver.findElement(By.xpath("//table[@id='table_units']/tbody/tr[2]/td/a/span")).click();
    assertTrue(driver.findElement(By.xpath("//div[2]/div/div/div[2]/p")).getText().matches("^Bilbo Baggins is a hobbit[\\s\\S]*$"));
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
