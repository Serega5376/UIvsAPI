package com.company.firstTestWebServices;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class StartTest {
	public static void main(String[] args) {
		TestNG runner = new TestNG();
		List<String> suitefiles = new ArrayList<String>();
		suitefiles.add("testng.xml");
		runner.setTestSuites(suitefiles);
		runner.run();
}
}


