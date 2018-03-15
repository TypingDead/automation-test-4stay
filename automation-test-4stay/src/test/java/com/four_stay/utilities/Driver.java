package com.four_stay.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
private Driver () {
		
	}
	
	private static WebDriver driver;
	
	public static WebDriver getDriver() {
		if (driver == null) {
			switch (ConfigurationReader.getProperty("browser")) {
				case "firefox" :
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					break;
				case "chrome" :
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					break;
				case"MicrosoftEdge":
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					break;
				default :
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
			}
		}
		return driver;
	}
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}
