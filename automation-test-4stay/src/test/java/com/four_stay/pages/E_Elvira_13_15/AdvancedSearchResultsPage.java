package com.four_stay.pages.E_Elvira_13_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

public class AdvancedSearchResultsPage {

	private WebDriver driver;
	
	public AdvancedSearchResultsPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="h2[class='ng-binding']")
	public WebElement firstResult;
	
	@FindBy (id="check-button")
	public WebElement requestStay;
	
	@FindBy (css="a[class='dropdown-toggle']")
	public WebElement dropDown;
	
	@FindBy(linkText="Log Out")
	public WebElement logOut;
	
	
	public static void changeWindow(WebDriver driver) {
		String origin = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if(!handle.equals(origin)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	
}
