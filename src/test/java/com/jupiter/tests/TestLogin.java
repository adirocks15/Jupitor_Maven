package com.jupiter.tests;

import org.junit.Assert;
import org.junit.Test;
import com.jupiter.pages.HomePage;
import com.jupiter.pages.LoginModal;
import com.jupiter.pages.UserPage;

public class TestLogin extends BaseTest {

	@Test
	public void testMandatoryErrorMessage() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginMenu();
		
		LoginModal loginModal = new LoginModal(driver);
		loginModal.login("", "");
		
		Assert.assertEquals("Login error does not match","Your login details are incorrect", loginModal.getErrorMessage());
	}
	
	@Test
	public void testInvalidCrednentialError() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginMenu();
		
		LoginModal loginModal = new LoginModal(driver);
		loginModal.login("testuser", "abc123");
		
		Assert.assertEquals("Login error does not match","Your login details are incorrect", loginModal.getErrorMessage());
	}
	
	@Test
	public void testSuccessfulLogin() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginMenu();
		
		LoginModal loginModal = new LoginModal(driver);
		loginModal.login("Aditya", "letmein");
		
		Assert.assertEquals( "Incorrect username displayed", "Aditya", loginModal.getUsername());
	}
	
	@Test
	public void testWelcomeMessage() {
		HomePage homePage = new HomePage(driver);
		homePage.clickLoginMenu();
		
		LoginModal loginModal = new LoginModal(driver);
		loginModal.login("Aditya", "letmein");
		
		homePage.clickUserMenu();
		UserPage userPage = new UserPage(driver);
		
		Assert.assertEquals( "Banner message incorrect", "Welcome Aditya", userPage.getWelcomeMessage());
	}
}
