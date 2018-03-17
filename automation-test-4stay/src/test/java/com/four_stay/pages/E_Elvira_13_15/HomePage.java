package com.four_stay.pages.E_Elvira_13_15;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

	@FindBy(id = "first-name")
	public WebElement firstName;

	@FindBy(id = "last-name")
	public WebElement lastName;

	@FindBy(id = "email")
	public WebElement emailAddress;

	@FindBy(id = "password")
	public WebElement newPassword;

	@FindBy(css = "button[type='submit']")
	public WebElement signUpButton;

	@FindBy(css = "button[class='close p-1 mr-3 mt-2 mb-2']")
	public WebElement closeX;

	@FindBy(css = "div[class='role-icon guest-icon selected']")
	public WebElement guestIcon;

	@FindBy(partialLinkText = "NEXT")
	public WebElement nextButton;

	@FindBy(id = "phone")
	public WebElement phoneInput;

	@FindBy(id = "about_me")
	public WebElement aboutMe;

	@FindBy(id = "dob")
	public WebElement yearInput;

	@FindBy(css = "button[class='btn btn-primary w-100 m-0 ng-binding']")
	public WebElement saveButton;
	
	@FindBy(css= "a[href='/users/sign_out']")
	public WebElement logOut;

	public void verifyFirstNameIsNotPresent() {
		try {
			driver.findElement(By.id("first-name"));

		} catch (NoSuchElementException e) {
			System.out.println("First Name Input is not present");
		}
	}

	public void verifyLastNameIsNotPresent() {
		try {
			driver.findElement(By.id("last-name"));

		} catch (NoSuchElementException e) {
			System.out.println("Last Name Input is not present");
		}
	}
	
	public void verifyLogOutIsNotPresent() {
		try {
			driver.findElement(By.cssSelector("a[href='/users/sign_out']"));

		} catch (NoSuchElementException e) {
			System.out.println("Log Out link is not present");
		}
	}
}
