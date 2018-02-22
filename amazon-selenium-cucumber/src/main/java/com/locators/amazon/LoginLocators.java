package com.locators.amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators {

	WebDriver driver;

	public LoginLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By hover_signin = By.xpath("//*[@id='nav-link-accountList']");

	public WebElement gethover_signin() {
		return driver.findElement(hover_signin);
	}
	
	@FindBy(xpath ="//*[@id=\"nav-flyout-ya-signin\"]/a/span")
	WebElement sign_homepage;
	
	public WebElement getsign_homepage() {
		return sign_homepage;
	}
	
	@FindBy(xpath="//*[@id='ap_email']")
	WebElement email;
	
	public WebElement getemail() {
		return email;
	}
	
	By continuebutton = By.id("continue");
	
	public WebElement getcontinuebutton() {
		return driver.findElement(continuebutton);
	}

	@FindBy(css="#ap_password")
	WebElement password;
	
	public WebElement getpassword() {
		return password;
	}
	
	@FindBy(id="signInSubmit")
	WebElement signinbutton;
	
	public WebElement getsigninbutton() {
		return signinbutton;
	}

	
	By countinuecount = By.id("continue");

	public List<WebElement> getcountinuecount() {
		return driver.findElements(countinuecount);
	}
	

}
