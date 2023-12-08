package com.project1.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.project1.base.TestBaseForAllClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BankManagerLoginTest extends TestBaseForAllClasses {


	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;


	@BeforeClass
	//@Parameters({"Browser"})
	public void setup() {
		if (fis == null) {
			try {
				FileInputStream fis = new FileInputStream(
						(System.getProperty("user.dir")) + "\\src\\test\\resources\\Properties\\config.properties");
				config.load(fis);
				FileInputStream ORfs = new FileInputStream(
						(System.getProperty("user.dir")) + "\\src\\test\\resources\\Properties\\OR.properties");
				OR.load(ORfs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}}
	@Test(priority = 0)
	//@Parameters({ "Browser" })
	public void lunchBrowser() throws InterruptedException {
		/*if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome driver is lunched");
			System.out.println(config.getProperty("testsiteURL"));
			driver.get(config.getProperty("testsiteURL"));
		} if (Browser.equalsIgnoreCase("edge")) {*/
		System.out.println("Executing BankManger Login test..");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge driver is lunched");
			Thread.sleep(1000);
			driver.get(config.getProperty("testsiteURL"));
		//}
	}

	@Test(priority = 1)
	public void loginAsBankManager() throws InterruptedException {
		//Thread.sleep(1000);
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		Thread.sleep(1000);

		Assert.assertTrue(isElementPresent(driver,By.cssSelector(OR.getProperty("addCustBtn"))));
	}

}
