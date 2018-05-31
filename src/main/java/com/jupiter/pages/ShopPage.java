package com.jupiter.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.jupiter.interfaces.ICompareStrategy;

public class ShopPage extends BasePage {

	public ShopPage(WebDriver driver) {
		super(driver);
	}
	
	public Product getProduct(ICompareStrategy compareStrategy) throws Exception {
		
		List<WebElement> productList = driver.findElements(By.cssSelector(".product"));
		
		for(WebElement productElement :productList) {
			Product product = new Product(productElement);
			if(compareStrategy.compare(product)) {
				return product; 
			}
		}
		throw new Exception("Unable to find product");
	}
}
