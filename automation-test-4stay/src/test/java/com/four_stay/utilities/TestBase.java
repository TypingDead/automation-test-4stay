package com.four_stay.utilities;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.four_stay.pages.AdvancedSearchResultsPage;
import com.four_stay.pages.HomePage;
import com.four_stay.pages.ListYourStayPage;
import com.four_stay.pages.SignUpPage;

public class TestBase {

//	protected WebDriver driver;
	
	protected HomePage homepage;
	protected ListYourStayPage listYourStayPage;
	protected AdvancedSearchResultsPage advancedSearchPage;
	protected SignUpPage signUpPage;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() {

		homepage = new HomePage();
		listYourStayPage = new ListYourStayPage();
		advancedSearchPage = new AdvancedSearchResultsPage();
		signUpPage = new SignUpPage();
		Driver.getDriver().manage().window().maximize();
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		Driver.closeDriver();
	}
}
