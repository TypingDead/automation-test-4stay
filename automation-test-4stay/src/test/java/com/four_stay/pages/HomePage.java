package com.four_stay.pages;

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
	
	@FindBy(linkText = "LOG OUT")
	public WebElement logout;
	
	@FindBy(css= "div[class='logo']")
	public WebElement logo;
	
	@FindBy(linkText="DASHBOARD")
	public WebElement dashboard;
	
	@FindBy(xpath="//div[@class='form-group']/input")
	public WebElement searchTab;
	
	@FindBy(css="button[class = 'btn search-btn']")
	public WebElement searchButton;
	
	@FindBy(id = "login_status")
	public WebElement invalidmessage;
	
	@FindBy(xpath = "//div[@class='modal fade login-modal show']//div//div//div/button")
	public WebElement close;
	
}
