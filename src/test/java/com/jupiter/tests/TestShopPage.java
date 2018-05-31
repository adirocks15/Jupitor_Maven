package com.jupiter.tests;

import com.jupiter.interfaces.CompareByTitleStrategy;
import com.jupiter.pages.HomePage;
import com.jupiter.pages.Product;
import com.jupiter.pages.ShopPage;
import org.junit.Assert;
import org.junit.Test;


public class TestShopPage extends BaseTest {
	Double productPrice = 14.99;
	String productName = "Smiley Bear";
	
	@Test
	public void testProductPrice() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.clickShopMenu();
		ShopPage shopPage = new ShopPage(driver);
		
		Product product = shopPage.getProduct(new CompareByTitleStrategy(productName));
		Assert.assertEquals("Toy price should match", productPrice, product.getPrice()); 
	}
	
	@Test
	public void testCartCount() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.clickShopMenu();
		ShopPage shopPage = new ShopPage(driver); 
		
		Product product = shopPage.getProduct(new CompareByTitleStrategy(productName));
		product.clickBuyButton();
		
		Assert.assertEquals("Verify cart count", 1 ,shopPage.getCartCount());
	}
}
