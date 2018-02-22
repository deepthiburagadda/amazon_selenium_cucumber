package com.cucumber.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.locators.amazon.LoginLocators;
import com.locators.amazon.SearchItemLocators;
import com.resources.amazon.Base;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddingProductToCart extends Base {

	LoginLocators locators;
	SearchItemLocators search;

	public AddingProductToCart() throws IOException {

		initializingDriver();

		locators = new LoginLocators(driver);
		search = new SearchItemLocators(driver);
	}

	@Given("^User is on Amazon Home Page$")
	public void user_is_on_Amazon_Home_Page() throws Throwable {

		// driver.manage().window().maximize();

		System.out.println(driver.getTitle());
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {

		Actions action = new Actions(driver);

		action.moveToElement(locators.gethover_signin()).build().perform();

		action.click(locators.getsign_homepage()).build().perform();

		Assert.assertEquals("Amazon Sign In", driver.getTitle());

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String username, String password) throws Throwable {

		locators.getemail().sendKeys(username);

		int count = locators.getcountinuecount().size();

		if (count > 0) {
			locators.getcontinuebutton().click();

			locators.getpassword().sendKeys(password);

			locators.getsigninbutton().click();
		} else {

			locators.getpassword().sendKeys(password);

			locators.getsigninbutton().click();

		}

	}

	@Then("^Amazon User Home Page appears$")
	public void amazon_User_Home_Page_appears() throws Throwable {

		System.out.println(driver.getTitle());

		Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
				driver.getTitle());

	}

	@Given("^User enters \"([^\"]*)\" in searchbox$")
	public void user_enters(String text) throws Throwable {

		search.getsearchbox().sendKeys(text);
		search.getsearchbox().sendKeys(Keys.ENTER);
		System.out.println(driver.getTitle());

	}

	@When("^navigates to the first search result and adds it to the cart$")
	public void user_navigates_to_first_item() throws Throwable {

		Select sort = new Select(search.getsortitems());
		String handbagname = search.getfirstitem().getText();
		System.out.println(handbagname);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(search.getfirstitem())).click();
		search.getaddtocart().click();

		int count = search.getshippingcount().size();

		if (count > 0) {
			search.getshipping().click();

		} else {

			System.out.println(driver.getTitle());

		}

	}

	@Then("^User cart should contain the added item$")
	public void user_cart_should_contain_the_added_item() throws Throwable {
		search.getviewcart().click();
		driver.quit();

	}

}
