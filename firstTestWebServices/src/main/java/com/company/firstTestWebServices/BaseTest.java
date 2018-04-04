package com.company.firstTestWebServices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.company.firstTestWebServices.Listener;

public class BaseTest {
	protected WebDriver driver;
	static String baseUrl;
	public static WebDriverEventListener myEvent;


	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		myEvent = new Listener();
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new EventFiringWebDriver(new ChromeDriver()).register(myEvent);
		baseUrl = "https://finance.yahoo.com/";
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
	}
}
