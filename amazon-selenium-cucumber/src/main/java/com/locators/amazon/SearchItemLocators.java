package com.locators.amazon;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchItemLocators {

	WebDriver driver;

	public SearchItemLocators(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement searchbox;

	public WebElement getsearchbox() {
		return searchbox;
	}
	@FindBy(id = "sort")
	WebElement sortitems;

	public WebElement getsortitems() {
		return sortitems;
	}
	@FindBy(xpath = "//*[@id=\"result_0\"]")
	WebElement firstitem;

	public WebElement getfirstitem() {
		return firstitem;
	}
	@FindBy(id = "add-to-cart-button")
	WebElement addtocart;

	public WebElement getaddtocart() {
		return addtocart;
	}
	By shipping = By.id("sbbop-no-button");
	
	public WebElement getshipping() {
		return driver.findElement(shipping);
	}
	By shippingcount = By.id("sbbop-no-button");

	public List<WebElement> getshippingcount() {
		return driver.findElements(shippingcount);
	}
	@FindBy(xpath = "//*[@id=\"nav-cart\"]")
	WebElement viewcart;

	public WebElement getviewcart() {
		return viewcart;
	}
}
