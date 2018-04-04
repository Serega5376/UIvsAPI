package com.company.firstTestWebServices;

import org.testng.annotations.*;

public class TestCompareAPIandUI extends BaseTest {

	@Test
	public void testUntitled() throws Exception {

		Helper.compare(driver);

	}

}
