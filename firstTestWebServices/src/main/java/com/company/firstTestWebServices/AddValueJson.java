package com.company.firstTestWebServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class AddValueJson {
	public static String openValue;
	public static String highValue;
	public static String lowValue;
	public static String closeValue;
	public static String openV;
	public static String highV;
	public static String lowV;
	public static String closeV;
	static double open;
	static double high;
	static double low;
	static double close;

	public static void addValuesJson() {
		try {
			String key = "TRZSGHIFF2UOANY6";
			String company = "EPAM";
			String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + company
					+ "&interval=1min&datatype=json&apikey=" + key;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject obj_JSONObject = new JSONObject(response.toString());
			JSONObject obj_JSONObject1 = obj_JSONObject.getJSONObject("Meta Data");
			String date = obj_JSONObject1.getString("3. Last Refreshed");
			int limit = 10;
			String subStr = date.codePointCount(0, date.length()) > limit
					? date.substring(0, date.offsetByCodePoints(0, limit))
					: date;
			JSONObject obj_JSONObject2 = obj_JSONObject.getJSONObject("Time Series (Daily)");
			JSONObject obj_JSONObject3 = obj_JSONObject2.getJSONObject(subStr);
			openValue = obj_JSONObject3.getString("1. open");
			highValue = obj_JSONObject3.getString("2. high");
			lowValue = obj_JSONObject3.getString("3. low");
			closeValue = obj_JSONObject3.getString("4. close");
			open = Double.parseDouble(openValue);
			String open1 = String.format("%.2f", open);
			openV = open1;
			high = Double.parseDouble(highValue);
			String high1 = String.format("%.2f", high);
			highV = high1;
			low = Double.parseDouble(lowValue);
			String low1 = String.format("%.2f", low);
			lowV = low1;
			close = Double.parseDouble(closeValue);
			String close1 = String.format("%.2f", close);
			closeV = close1;
		} catch (Exception e) {
		}

	}
}