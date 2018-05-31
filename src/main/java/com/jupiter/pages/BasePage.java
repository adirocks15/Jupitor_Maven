package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

	protected WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickContactMenu() {
		driver.findElement(By.id("nav-contact")).click();
	}
	
	public void clickLoginMenu() {
		driver.findElement(By.id("nav-login")).click();
	}
	
	public void clickShopMenu() {
		driver.findElement(By.id("nav-shop")).click();
	}
	
	public void clickUserMenu() {
		driver.findElement(By.id("nav-user")).click();
	}
	
	public String getUsername() {	
		return driver.findElement(By.id("nav-user")).getText();
	}
	
	public int getCartCount() {
		return Integer.valueOf(driver.findElement(By.cssSelector("#nav-cart .cart-count")).getText().trim());
	}
}
