package com.four_stay.pages.F_Parhay_16_19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HomePage {
	
	private WebDriver driver;
	
	public HomePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='form-group']/input")
	public WebElement searchBox;
	
	
	@FindBy(xpath="//*[@class='btn search-btn']")
	public WebElement searchButton;
	
	@FindBy(xpath="//*[@class='tooltip-inner']")
	public WebElement AfterclicktheButton;
	
	
	@FindBy(xpath="//b[@class='ng-binding']")
	public WebElement result;
	
	
	public void clickSearchBox() {
		searchBox.click();
	
	}
	public void sendKeyToSearchBox() {
		searchBox.sendKeys("Jones Branch Dr, Tysons");
		
	}
	
	
	public void ClickSearchButton() {
		searchButton.click();
	}
	
	
	public boolean isAt() {
		return driver.getTitle().equals("Room rental, roommate finder, off-campus housing, homestay | 4stay");
	}
	
	public boolean isAtUrl() {
		return driver.getCurrentUrl().equals("https://4stay.com/");
	}
	
	
	
}
