package com.four_stay.pages.D_Dzmitry_10_12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

public class SingUpPage {
	private WebDriver driver;

	public SingUpPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "LIST YOUR STAY")
	public WebElement listYourStayButton;

	@FindBy(xpath = "//a[@id='login-here']")
	public WebElement loginHereLink;
	
	@FindBy(xpath = "//input[@id='user_email']")
	public WebElement emailAddressBox;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement passwordBox;

	@FindBy(xpath = "//a[@id='login_btn']")
	public WebElement loginButton;

	public String profileDetailsPage = "https://4stay.com/sign-up#!/profile-details";

	public String currentUrl = Driver.getDriver().getCurrentUrl().toString();
}
