package com.four_stay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

public class ListYourStayPage {
	private WebDriver driver;

	public ListYourStayPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "LIST YOUR STAY")
	public WebElement listYourStayButton;

	@FindBy(id = "login-here")
	public WebElement loginHereLink;

	@FindBy(id = "user_email")
	public WebElement emailAddressBox;

	@FindBy(id = "user_password")
	public WebElement passwordBox;

	@FindBy(id = "login_btn")
	public WebElement loginButton;
//	
	@FindBy(name = "user[first_name]")
	public WebElement firstName;
	
	@FindBy(name = "user[last_name]")
	public WebElement lastName;
	
	@FindBy(name = "user[email]")
	public WebElement emailAddress;
	
	@FindBy(name = "user[password]")
	public WebElement password;
	
	@FindBy(name = "user[phone]")
	public WebElement phoneNumber;
	
	@FindBy(name = "//label[@class='checkbox i-minus-checks']/i")
	public WebElement checkBox;
	
	@FindBy(xpath = "//input[@type='submit'][@value='Create account']")
	public WebElement createAccount;
	
	@FindBy(linkText="Log Out")
	public WebElement logoutListyourStay;
	
	@FindBy(linkText="SIGN UP WITH FACEBOOK")
	public WebElement facebookSignup;
	
	@FindBy(xpath="//div[@id='email_container']//input")
	public WebElement facebookEmail;
	
	@FindBy(xpath="(//div[@class='clearfix form_row'])[2]//input")
	public WebElement facebookpassword;
	
	public boolean isAtUrl() {
		return driver.getCurrentUrl().equals("fourstay-staging.herokuapp.com/");
	}

	public String expectedHostUrl() {
		return driver.getCurrentUrl();
	}
	public String actualHostUrl = "https://fourstay-staging.herokuapp.com/how-to-become-a-host";
	
//
	public String profileDetailsPage = "https://fourstay-staging.herokuapp.com/sign-up#!/profile-details";

	public String currentUrl = Driver.getDriver().getCurrentUrl().toString();
	
	public WebElement checkBox() {
	String checkboxXPath = "//label[@class='checkbox i-minus-checks']/i";
			WebElement elementToClick = driver.findElement(By.xpath(checkboxXPath));
			elementToClick.click();
			return elementToClick;
	}
}
