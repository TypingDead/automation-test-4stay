package com.four_stay.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class AdvancedSearchResultsPage extends TestBase {
	
	public AdvancedSearchResultsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy (css="h2[class='ng-binding']")
	public WebElement firstResult;
	
	@FindBy (id="check-button")
	public WebElement requestStay;
	
	
	
	@FindBy (css="a[class='dropdown-toggle']")
	public WebElement dropDown;
	
	@FindBy(linkText="Log Out")
	public WebElement logOut;
	
	@FindBy(xpath="//div[@class='logo animated fadeInDown ml-auto mr-auto']")
	public WebElement logo;
	
	@FindBy(xpath="//*[@id=\"page-container\"]/div[2]/div/h2")
	public WebElement congratulation;
	
	@FindBy(xpath="//a[@class='btn-outline-primary btn']")
	public WebElement requestCenter;
	
	@FindBy(linkText="Cancel")
	public WebElement cancelButton;
	
	public void CongratulationDisplay() {
		congratulation.isDisplayed();
		requestCenter.isDisplayed();
	}
	
	public boolean isAt() {
		return Driver.getDriver().getTitle().contains("Washington, DC, USA");
	}
	  
	public boolean isUrl() {
		return Driver.getDriver().getCurrentUrl().contains("https://4stay.com/advanced_search");
	}
	
	
	public boolean titleContains() {
		return Driver.getDriver().getTitle().contains(firstResult.getText());
	}
	
	
	public static void changeWindow(WebDriver driver) {
		String origin = driver.getWindowHandle();
		for (String handle : driver.getWindowHandles()) {
			if(!handle.equals(origin)) {
				driver.switchTo().window(handle);
			}
		}
	}
	
	
}
