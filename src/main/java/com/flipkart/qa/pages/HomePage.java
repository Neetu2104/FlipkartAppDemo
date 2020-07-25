package com.flipkart.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//input[@title='Search for products, brands and more']")
	WebElement search;

	@FindBy(xpath = "//img[@src='https://rukminim1.flixcart.com/image/312/312/camera/z/v/z/sony-cybershot-dsc-w810-point-shoot-original-imadsm8hgzdvgxsn.jpeg?q=70']")
	WebElement camera;

	@FindBy(xpath = "//div[contains(text(),'Sony CyberShot DSC-W810/BC IN5')]")
	WebElement name;

	@FindBy(xpath = "//div[contains(text(),'7,790')]")
	WebElement price;

	@FindBy(xpath = "//button[contains(text(),'BUY NOW')]")
	WebElement buyNowBtn;

	@FindBy(xpath = "//button[contains(text(),'BUY NOW')]")
	WebElement continueBtn;

	@FindBy(xpath = "//button[contains(text(),'PAY ₹7,790')]")
	WebElement payBtn;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void searchAndPurchase() {
		search.sendKeys("Camera");
		search.click();
		camera.click();
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		buyNowBtn.click();
		continueBtn.click();
		payBtn.click();
		// After purchasing go back to parent window
		driver.switchTo().window(parentWindow);
	}
}
