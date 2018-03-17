package com.four_stay.pages.C_Alex_7_9;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

/**
 * 
 * @author Rodriguez HomeTest Beta_4Stay
 *
 */

public class HomePage {

	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Log In')]")
	public WebElement logIn;

	@FindBy(xpath = "//input[@id='user_email']")
	public WebElement emailAddress;

	@FindBy(xpath = "//input[@id='user_password']")
	public WebElement password;

	@FindBy(xpath = "//a[@id='login_btn']")
	public WebElement loginButton;

	@FindBy(xpath = "//a[@class='forgot-link']")
	public WebElement forgotPassword;

	@FindBy(xpath = "//h2[contains(text(),'Forgot your password?')]")
	public WebElement forgotPasswordMessageDisplay;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement resetInstruction;

	@FindBy(xpath = "//div[@id='error_explanation']/ul/li")
	public WebElement emailCantBeBlank;

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogIn() {
		return logIn.isDisplayed();
	}

	public boolean forgotPasswordDisplay() {
		return forgotPasswordMessageDisplay.isDisplayed();
	}

	public void logInClickable() {
		try {
			logIn.click();
			System.out.println("Log In is clickable");

		} catch (NoSuchElementException e) {
			System.out.println("Log in is not clickable");
		}

	}

	public void emailAddressIsEmpty() {
		try {
			emailAddress.getText().isEmpty();
			System.out.println("Email Address field is empty");

		} catch (NoSuchElementException e) {
			System.out.println("Email Address field is not empty");
		}

	}

	public void passwordIsEmpty() {
		try {
			password.getText().isEmpty();
			System.out.println("Password field is empty");

		} catch (NoSuchElementException e) {
			System.out.println("Password Field is not empty");
		}

	}

}
