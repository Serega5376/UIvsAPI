package com.company.firstTestWebServices;

import org.openqa.selenium.By;

public final class Locators {
	
	private Locators() {

	}
	
	public final static By OPEN_UI = By.xpath(
			"//div[@id='Col1-1-HistoricalDataTable-Proxy']/section/div[2]/table/tbody/tr/td[2]/span");
	public final static By HIGH_UI = By.xpath(
			".//*[@id='Col1-1-HistoricalDataTable-Proxy']/section/div[2]/table/tbody/tr[1]/td[3]/span");
	public final static By LOW_UI = By.xpath(
			".//*[@id='Col1-1-HistoricalDataTable-Proxy']/section/div[2]/table/tbody/tr[1]/td[4]/span");
	public final static By CLOSE_UI = By.xpath(
			".//*[@id='Col1-1-HistoricalDataTable-Proxy']/section/div[2]/table/tbody/tr[1]/td[5]/span");

}
