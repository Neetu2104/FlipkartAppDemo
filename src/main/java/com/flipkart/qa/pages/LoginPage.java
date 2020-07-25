package com.flipkart.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//*[contains(text(),'Login')]")
	WebElement login;

	@FindBy(xpath = "//input[@type='text']")
	WebElement username;

	@FindBy(xpath = "//input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un, String pwd) {
		login.click();
		driver.switchTo().alert();
		username.sendKeys(Keys.ENTER);
		username.sendKeys(un);
		
		password.sendKeys(Keys.ENTER);
		password.sendKeys(pwd);
		// loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);

		return new HomePage();
	}

}
