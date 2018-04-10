package com.company.firstTestWebServices;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestCompareAPIandUI extends BaseTest {

	@Test
	public void testUntitled() {
		AddValueJson.addValuesJson();
		driver.get(BaseTest.baseUrl + "/quote/EPAM/history?p=EPAM");
		assertEquals(driver.findElement(Locators.OPEN_UI).getText(), AddValueJson.openV);
		assertEquals(driver.findElement(Locators.HIGH_UI).getText(), AddValueJson.highV);
		assertEquals(driver.findElement(Locators.LOW_UI).getText(), AddValueJson.lowV);
		assertEquals(driver.findElement(Locators.CLOSE_UI).getText(), AddValueJson.closeV);

	}

}
