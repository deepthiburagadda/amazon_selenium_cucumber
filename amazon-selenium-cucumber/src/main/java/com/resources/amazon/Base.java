package com.resources.amazon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public Properties prop;
	public WebDriver driver;

	public void initializingDriver() throws IOException {
		
//"C:\\Users\\dburagadda\\git\\amazon_selenium_cucumber\\amazon_automation\\src\\main\\java\\com\\resources\\amazon\\Data.properties
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("//Users//deepthimaddula//GIT_GODADDY//amazon//amazon-selenium-cucumber//src//main//java//com//resources//amazon//Data.properties");
		prop.load(fis);
		String browsertype = prop.getProperty("browser");
		String baseurl = prop.getProperty("url");
		System.out.println(browsertype);
		System.out.println(baseurl);

		if (browsertype.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/deepthimaddula/chromedriver");
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\dburagadda\\Documents\\chromedriver.exe");
			this.driver = new ChromeDriver();
			this.driver.get(baseurl);
		//	driver.manage().window().maximize();
		} else {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(baseurl);
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	

}
