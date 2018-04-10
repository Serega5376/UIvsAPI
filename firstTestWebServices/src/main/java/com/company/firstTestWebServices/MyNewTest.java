package com.company.firstTestWebServices;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Properties;

public class MyNewTest {

	public static void main(String[] args) throws IOException {
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
		System.out.println(response);

		System.out.println(response.getTimeSeries().entrySet().iterator().next().getKey());
	}
}
