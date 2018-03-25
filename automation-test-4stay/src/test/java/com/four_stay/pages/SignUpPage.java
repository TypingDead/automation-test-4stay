package com.four_stay.pages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.ConfigurationReader;
import com.four_stay.utilities.Driver;
import com.four_stay.utilities.TestBase;

public class SignUpPage extends TestBase {

	public SignUpPage() {
		PageFactory.initElements(Driver.getDriver(), this);
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
			Driver.getDriver().findElement(By.id("first-name"));

		} catch (NoSuchElementException e) {
			System.out.println("First Name Input is not present");
		}
	}

	public void verifyLastNameIsNotPresent() {
		try {
			Driver.getDriver().findElement(By.id("last-name"));

		} catch (NoSuchElementException e) {
			System.out.println("Last Name Input is not present");
		}
	}
	
	public void verifyLogOutIsNotPresent() {
		try {
			Driver.getDriver().findElement(By.cssSelector("a[href='/users/sign_out']"));

		} catch (NoSuchElementException e) {
			System.out.println("Log Out link is not present");
		}
	}
	///////////////////////////////////////////////
	@FindBy(xpath = ("//a[@class='btn facebook-btn w-100 m-0 mb-3']"))
	public WebElement continueWithFacebookButton;
	
	@FindBy(xpath = ("//a[@class='btn google-btn w-100 m-0 mb-3']"))
	public WebElement continueWithGoogleButton;
	
	@FindBy(xpath = "//div[@class='btn email-btn w-100 m-0 mb-3']")
	public WebElement continueEmailButton;
	
	@FindBy(linkText = "Jimmy")
	public WebElement nameLink;
	
	@FindBy(xpath = "//div[contains(@class,'role-icon host-icon')]")
	public WebElement hostIcon;
	
	@FindBy(xpath = "//div[@class='role-icon host-icon selected']")
	public WebElement hostIconIsSelected;
	
	@FindBy(xpath = "//div[@class='role-icon guest-icon selected']")
	public WebElement guestButtonIsSelected;
	
	@FindBy(id = "occupation")
	public WebElement hostEmail;
	
	public String userfirstName = "Jimmy";
	public String userlLastName = "Johns";
	public String newEmailAddress = "JimmyJohns@gmail.com";
	public String newUserPassword = "123456";
	public String userPhoneNumber = "1233211234";
	public String aboutMyself = "Student";
	public String userDoB = "1999";
	
	public void completeUserForm(
			String userFirstName, String userlLastName, String userEmail, String userPassword
			) {
		firstName.clear();
		firstName.sendKeys(userFirstName);
		lastName.clear();
		lastName.sendKeys(userlLastName);
		emailAddress.clear();
		emailAddress.sendKeys(newRandomEmailAddress(userEmail));
		newPassword.clear();
		newPassword.sendKeys(userPassword);
	}
	public String newRandomEmailAddress(String emailAddress) {
		Random random = new Random();
		int emailNumber = random.nextInt(10000) + 1;
		String[] nameFromEmail = emailAddress.split("@");
		String newEmailAddress = nameFromEmail[0]+emailNumber+"@"+nameFromEmail[1];
		return newEmailAddress;
	}
	public void navigateToSingUpPage() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().get(ConfigurationReader.getProperty("signupurl"));
	}
	public void profileDetails(String phoneNumber,
			String aboutMyself, String dateOfBirth) {
		phoneInput.clear();
		phoneInput.sendKeys(phoneNumber);
		aboutMe.clear();
		aboutMe.sendKeys(aboutMyself);
		yearInput.clear();
		yearInput.sendKeys(dateOfBirth);
	}
}
