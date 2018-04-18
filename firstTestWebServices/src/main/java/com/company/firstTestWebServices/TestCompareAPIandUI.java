package com.company.firstTestWebServices;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class TestCompareAPIandUI extends BaseTest {

	@Test
	public void testUntitled() throws IOException {
		HttpClient client = new HttpClient();
		final Properties properties = Utils.readProperties();

		String key = properties.getProperty("alphavantage.key");
		String company = "EPAM";
		String url =
				"https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + company + "&interval=1min&datatype=json&apikey="
						+ key;

		final String responseAsString = client.executeGet(url);

		ObjectMapper om = new ObjectMapper();
		final Response response = om.readValue(responseAsString, Response.class);

		final Response.TimeSeries lastStockPrices = response.getTimeSeries().entrySet().iterator().next().getValue();

		driver.get(BaseTest.baseUrl + "/quote/EPAM/history?p=EPAM");

		assertEquals(toBigDecimal(Float.parseFloat(driver.findElement(Locators.OPEN_UI).getText())),
				toBigDecimal(lastStockPrices.getOpen())
		);
		assertEquals(toBigDecimal(Float.parseFloat(driver.findElement(Locators.HIGH_UI).getText())),
				toBigDecimal(lastStockPrices.getHigh())
		);
		assertEquals(toBigDecimal(Float.parseFloat(driver.findElement(Locators.LOW_UI).getText())), toBigDecimal(lastStockPrices.getLow()));
		assertEquals(toBigDecimal(Float.parseFloat(driver.findElement(Locators.CLOSE_UI).getText())),
				toBigDecimal(lastStockPrices.getClose())
		);
	}

	private BigDecimal toBigDecimal(Float f) {
		final BigDecimal bigDecimal = BigDecimal.valueOf(f);
		return bigDecimal.setScale(0, BigDecimal.ROUND_HALF_DOWN);

	}


}
