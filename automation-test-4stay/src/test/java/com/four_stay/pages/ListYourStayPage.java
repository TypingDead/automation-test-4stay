package com.four_stay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class ListYourStayPage extends TestBase {

	public ListYourStayPage() {
		PageFactory.initElements(Driver.getDriver(), this);
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

	@FindBy(linkText = "Log Out")
	public WebElement logoutListyourStay;

	@FindBy(linkText = "SIGN UP WITH FACEBOOK")
	public WebElement facebookSignup;

	@FindBy(xpath = "//div[@id='email_container']//input")
	public WebElement facebookEmail;

	@FindBy(xpath = "(//div[@class='clearfix form_row'])[2]//input")
	public WebElement facebookpassword;

	@FindBy(xpath = "(//button[@class='close'])[2]")
	public WebElement close;

	@FindBy(linkText = "LOG OUT")
	public WebElement logOut;

	public void logOut() {
		try {
			if (logOut.isDisplayed()) {
				logOut.click();
			}
		} catch (Exception e) {
			System.out.println("Its not logged in");
		}
	}

	public boolean isAtUrl() {
		return Driver.getDriver().getCurrentUrl().equals("fourstay-staging.herokuapp.com/");
	}

	public String expectedHostUrl() {
		return Driver.getDriver().getCurrentUrl();
	}

	public String actualHostUrl = "https://4stay.com/how-to-become-a-host";
	public String actualHostUrl1 = "https://4stay.com/dashboard/stays/new";

	public String profileDetailsPage = "https://4stay.com/sign-up#!/profile-details";

	public String currentUrl = Driver.getDriver().getCurrentUrl().toString();

	public WebElement checkBox() {
		String checkboxXPath = "//label[@class='checkbox i-minus-checks']/i";
		WebElement elementToClick = Driver.getDriver().findElement(By.xpath(checkboxXPath));
		elementToClick.click();
		return elementToClick;
	}
}
