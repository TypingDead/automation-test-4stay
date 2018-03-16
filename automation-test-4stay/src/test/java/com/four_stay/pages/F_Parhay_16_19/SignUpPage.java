package com.four_stay.pages.F_Parhay_16_19;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

public class SignUpPage {
private WebDriver driver;
	
	public SignUpPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[.='Log In']")
	public WebElement login;
	
	
	
	
	
	
}
