package com.four_stay.pages.A_Arman_1_3;

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
	public WebElement LogIn;

	@FindBy(linkText = "LOG OUT")
	public WebElement LogOut;

	@FindBy(xpath = "//div[@class='logo']")
	public WebElement logo;

	@FindBy(id = "user_email")
	public WebElement Emailaddress;

	@FindBy(id = "user_password")
	public WebElement Password;

	@FindBy(id = "login_btn")
	public WebElement Loginbutton;

	@FindBy(linkText = "DASHBOARD")
	public WebElement dashboard;

	@FindBy(id = "login_status")
	public WebElement invalidmessage;

	@FindBy(xpath = "//div[@class='modal fade login-modal show']//div//div//div/button")
	public WebElement close;

}
