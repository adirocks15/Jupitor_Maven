package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage {

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	public String getWelcomeMessage() {
		return driver.findElement(By.tagName("h1")).getText();
	}
}
