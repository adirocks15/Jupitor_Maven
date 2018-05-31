package com.jupiter.tests;

import org.junit.Assert;
import org.junit.Test;

import com.jupiter.pages.ContactPage;
import com.jupiter.pages.HomePage;

public class TestContactPage extends BaseTest{

	@Test
	public void testMandatoryErrorMessages() {
		HomePage homePage = new HomePage(driver);
		homePage.clickContactMenu();
		
		ContactPage contactPage = new ContactPage(driver);
		contactPage.clickSubmitButton();
		
		//Forename error validation scenarios
		Assert.assertEquals("Forename error does not match","Forename is required", contactPage.getForenameError());
		contactPage.setForename("Aditya");
		Assert.assertEquals("Forename error is present","", contactPage.getForenameError());
		
		//Email error validation scenarios
		Assert.assertEquals("Email error does not match","Email is required", contactPage.getEmailError());
		contactPage.setEmail("abc@test.com");
		Assert.assertEquals("Email error is present","", contactPage.getEmailError());
			
		//Message error validation scenarios
		Assert.assertEquals("Message error does not match","Message is required", contactPage.getMessageError());
		contactPage.setMessage("Hope you are doing well");
		Assert.assertEquals("Message error is present","", contactPage.getMessageError());
	}
	
	@Test
	public void testInvalidInputs() {
		HomePage homePage = new HomePage(driver);
		homePage.clickContactMenu();
		ContactPage contactPage = new ContactPage(driver);
		
		contactPage.setEmail("abc123");
		Assert.assertEquals("Email error does not match","Please enter a valid email", contactPage.getEmailError());
		
		contactPage.setTelephone("abc123#@");
		Assert.assertEquals("Invalid Telephone error does not match","Please enter a valid telephone number", contactPage.getTelephoneError());
	}
}
