package com.four_stay.pages;

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
		System.out.println(congratulation.getText());
		System.out.println(requestCenter.getText());
	}
	
	
	
	
	
	
	public boolean isAt() {
		return driver.getTitle().equals("Advanced searchLos Angeles, CA, USA stays | Room rental, roommate finder, off-campus housing, homestay | 4stay");
	}
	
	public boolean isUrl() {
		return driver.getCurrentUrl().contains("https://4stay.com/advanced_search?lat=34.0522342&long=-118.2436849&place_title=Los%20Angeles,%20CA,%20USA&move_in=2018-03-22&move_out=2018-09-21&number_of_beds=1");
	}
	
	
	public boolean titleContains() {
		return driver.getTitle().contains(firstResult.getText());
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
