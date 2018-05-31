package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginModal extends BasePage{	
	
		
	public LoginModal(WebDriver driver) {
		super(driver);
	}

	public String getErrorMessage() {
		return driver.findElement(By.id("login-error")).getText();
	}
	
	public void clickLoginButton() {
		driver.findElement(By.cssSelector(".modal .btn-primary")).click();
	}
	
	public void login(String username, String password) {
		driver.findElement(By.id("loginUserName")).sendKeys(username);
		driver.findElement(By.id("loginPassword")).sendKeys(password);
		clickLoginButton();
	}
}
