package com.eProofing.DataProviders;

import org.testng.annotations.DataProvider;

public class eProofingDataProvider {

	@DataProvider(name = "eProofing")
	public static Object[][] Credentials() {

		return new Object[][] { { "Uname", "pwd" }, { "Uname1", "pwd1" }, { "Uname2", "Pwd2" }

		};
	}

}
