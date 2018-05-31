package com.jupiter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Product {
	public WebElement webElement;
	
	public Product(WebElement element) {
		this.webElement = element;	
	}
	
	public String getTitle(){
		return webElement.findElement(By.cssSelector(".product-title")).getText().trim();
	}
	
	public void clickBuyButton() {
		webElement.findElement(By.linkText("Buy")).click();
	}
	
	public Double getPrice() {
		return Double.valueOf(webElement.findElement(By.cssSelector(".product-price")).getText().replace("$", ""));
	}
}	

  