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

	@FindBy(linkText = "More options")
	public WebElement moreOptions;

	@FindBy(css = "div[class='btn email-btn w-100 m-0 mb-3']")
	public WebElement emailSignInOption;

	@FindBy(id="first-name")
	public WebElement firstName;

	@FindBy(id ="last-name")
	public WebElement lastName;

	@FindBy(id = "email")
	public WebElement emailAddress;

	@FindBy(id = "password")
	public WebElement newPassword;
	
	@FindBy(css = "button[type='submit']")
	public WebElement signUpButton;

}
