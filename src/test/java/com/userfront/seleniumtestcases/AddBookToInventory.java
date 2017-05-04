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

public class AddBookToInventory {

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

	public void testAddBookToInventory() throws Exception {
		// open | /logout |
		driver.get(baseUrl + "/logout");
		// open | / |
		driver.get(baseUrl + "/");
		// selectWindow | null |
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// null | ]]
		// click | link=BORROW and REQUEST |
		driver.findElement(By.linkText("BORROW and REQUEST")).click();
		// click | link=Books |
		Thread.sleep(2000);
		driver.findElement(By.linkText("Books")).click();
		// click | link=Admin Options |
		driver.findElement(By.linkText("Admin Options")).click();
		// click | link=Add Book |
		driver.findElement(By.linkText("Add Book")).click();
		// type | id=username | user1
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("user1");
		// type | id=password | user1
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("user1");
		Thread.sleep(500);
		// click | //button[@type='submit'] |
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// type | id=bookTitle | testcasebookdelete
		driver.findElement(By.id("bookTitle")).clear();
		driver.findElement(By.id("bookTitle")).sendKeys("testcasebookdelete");
		// type | id=isbn | 1113334440
		driver.findElement(By.id("isbn")).clear();
		driver.findElement(By.id("isbn")).sendKeys("1113334440");
		// select | id=authorDrop | label=J. R. R. Tolkien
		new Select(driver.findElement(By.id("authorDrop"))).selectByVisibleText("J. R. R. Tolkien");
		// select | id=authorDrop | label=RA Salvatore
		new Select(driver.findElement(By.id("authorDrop"))).selectByVisibleText("RA Salvatore");
		// select | id=authorDrop | label=Tony Robbins
		new Select(driver.findElement(By.id("authorDrop"))).selectByVisibleText("Tony Robbins");
		// select | id=genreDrop | label=Science fiction
		new Select(driver.findElement(By.id("genreDrop"))).selectByVisibleText("Science fiction");
		// select | id=genreDrop | label=Religion, Spirituality & New Age
		new Select(driver.findElement(By.id("genreDrop"))).selectByVisibleText("Religion, Spirituality & New Age");
		// select | id=countryDrop | label=Canada
		new Select(driver.findElement(By.id("countryDrop"))).selectByVisibleText("Canada");
		// type | id=publicationYear | 1985
		driver.findElement(By.id("publicationYear")).clear();
		driver.findElement(By.id("publicationYear")).sendKeys("1985");
		// type | id=description | testcasebookdelete description
		// testcasebookdelete description
		driver.findElement(By.id("description")).clear();
		driver.findElement(By.id("description"))
		        .sendKeys("testcasebookdelete description testcasebookdelete description");
		Thread.sleep(2500);
		// click | id=savebook |
		driver.findElement(By.id("savebook")).click();
		Thread.sleep(2500);
		// assertText | css=div.panel.panel-primary > div.panel-body |
		// *testcasebookdelete*
		assertTrue(driver.findElement(By.cssSelector("div.panel.panel-primary > div.panel-body")).getText()
		        .matches("^[\\s\\S]*testcasebookdelete[\\s\\S]*$"));
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
