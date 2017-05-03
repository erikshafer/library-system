package com.userfront.seleniumtestcases;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoToGoogle {
	  private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://google.com";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testInvalidLogin() throws Exception {
	    driver.get(baseUrl + "/logout");
	    driver.get(baseUrl + "/index?error");
	    driver.findElement(By.id("username")).clear();
	    driver.findElement(By.id("username")).sendKeys("invaliduser");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("invalidpass");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
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
	  
}
