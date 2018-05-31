package com.jupiter.tests;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static void setUpWebDriver() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\POC\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@Before
	public void setUp() throws Exception {
		driver.manage().deleteAllCookies();
		driver.get("http://jupiter.cloud.planittesting.com/");
	}
}
