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

	@FindBy(id = "user_email")
	public WebElement userEmail;

	@FindBy(id = "user_password")
	public WebElement userPassword;

	@FindBy(linkText = "LOGIN")
	public WebElement loginButton;

	@FindBy(linkText = "Forgot Password?")
	public WebElement forgotPassword;

	@FindBy(xpath = "//h2[contains(text(),'Forgot your password?')]")
	public WebElement forgotPasswordMessageDisplay;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement resetInstruction;

	@FindBy(xpath = "//div[@id='error_explanation']/ul/li")
	public WebElement emailCantBeBlank;

	@FindBy(linkText = "LOG OUT")
	public WebElement logout;

	@FindBy(css = "div[class='logo']")
	public WebElement logo;

	@FindBy(linkText = "DASHBOARD")
	public WebElement dashboard;

	@FindBy(xpath = "//div[@class='form-group']/input")
	public WebElement searchTab;

	@FindBy(css = "button[class = 'btn search-btn']")
	public WebElement searchButton;

	@FindBy(id = "login_status")
	public WebElement invalidmessage;

	@FindBy(xpath = "//*[@class='tooltip-inner']")
	public WebElement AfterclicktheButton;

	@FindBy(xpath = "//b[@class='ng-binding']")
	public WebElement result;

	@FindBy(xpath = "//div[@class='modal fade login-modal show']//div//div//div/button")
	public WebElement close;

	public void sendKeyToSearchBox() {
		searchTab.sendKeys("Washington, DC, USA");
	}
	
	public void sendKeyToSearchBox2() {
		searchTab.sendKeys("Washington, DC, USA");
	}
	
	public void clickSearchBox() {
		searchTab.click();
	}

	public boolean isAt() {
		return driver.getTitle().equals("Room rental, roommate finder, off-campus housing, homestay | 4stay");
	}

	public boolean isAtUrl() {
		return driver.getCurrentUrl().equals("https://fourstay-staging.herokuapp.com/");
	}

	public boolean forgotPasswordDisplay() {
		return forgotPasswordMessageDisplay.isDisplayed();
	}

	public boolean forgotPasswordMessage() {
		return forgotPassword.getText().equals(("Forgot Password?"));
	}

}
