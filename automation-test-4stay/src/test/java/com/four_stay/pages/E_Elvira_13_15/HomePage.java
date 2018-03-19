package com.four_stay.pages.E_Elvira_13_15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "LOG IN")
	public WebElement login;
	
	@FindBy(id="user_email")
	public WebElement userEmail;
	
	@FindBy(id="user_password")
	public WebElement userPassword;
	
	@FindBy(linkText="LOGIN")
	public WebElement loginButton;
	
	@FindBy(linkText="DASHBOARD")
	public WebElement dashboard;
	
	@FindBy(xpath="//div[@class='form-group']/input")
	public WebElement searchTab;
	
	@FindBy(css="button[class = 'btn search-btn']")
	public WebElement searchButton;
	
}
