package com.four_stay.pages.C_Alex_7_9;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.four_stay.utilities.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class HomePage {
	
	private WebDriver driver;
	
	public HomePage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	//	@FindBy(className="billLabel")
	//	public WebElement billLabel;
}
