package com.jupiter.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage extends BasePage {

	public ContactPage(WebDriver driver) {
		super(driver);
	}

	public void clickSubmitButton() {
		driver.findElement(By.linkText("Submit")).click();
	}

	public String getForenameError() {
		return getErrorMessge(By.id("forename-err"));
	}
	
	public String getEmailError() {
		return getErrorMessge(By.id("email-err"));
	}
	
	public String getMessageError() {
		return getErrorMessge(By.id("message-err"));
	}
	
	public String getTelephoneError() {
		return getErrorMessge(By.id("telephone-err"));
	}
	
	public void setForename(String forename) {
		setFormValues(By.id("forename"), forename);
	}

	public void setEmail(String email) {
		setFormValues(By.id("email"), email);
	}
	public void setMessage(String message) {
		setFormValues(By.id("message"), message);
	}
	
	public String getErrorMessge(By selector) {
		List<WebElement> mandatoryErrorMessage = driver.findElements(selector);		
		if (mandatoryErrorMessage.size()>0) {
			return mandatoryErrorMessage.get(0).getText();
		}
		else {
			return "";
		}
	}

	private void setFormValues(By selector, String fieldValue) {
		driver.findElement(selector).sendKeys(fieldValue);
	}

	public void setTelephone(String telephone) {
		driver.findElement(By.id("telephone")).sendKeys(telephone);
	}
}
