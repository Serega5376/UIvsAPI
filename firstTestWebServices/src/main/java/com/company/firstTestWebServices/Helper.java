package com.company.firstTestWebServices;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

public class Helper {
	public static void compare(WebDriver driver) throws InterruptedException {
		AddValueJson.addValuesJson();
		driver.get(BaseTest.baseUrl + "/quote/EPAM/history?p=EPAM");
		assertEquals(driver.findElement(Locators.OPEN_UI).getText(), AddValueJson.openV);
		assertEquals(driver.findElement(Locators.HIGH_UI).getText(), AddValueJson.highV);	
		assertEquals(driver.findElement(Locators.LOW_UI).getText(), AddValueJson.lowV);
		assertEquals(driver.findElement(Locators.CLOSE_UI).getText(), AddValueJson.closeV);
	}
}
