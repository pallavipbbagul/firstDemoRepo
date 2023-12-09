package com.project1.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.project1.base.TestBaseForAllClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
public class AddCustomer extends TestBaseForAllClasses{

	//BankManagerLoginTest obj=new BankManagerLoginTest();


	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

	@BeforeClass
	//@Parameters({"Browser"})
	public void setup() {
		if (fis == null) {
			try {
				System.out.println("Modified the AddCustomer Class");
				FileInputStream fis = new FileInputStream(
						(System.getProperty("user.dir")) + "\\src\\test\\resources\\Properties\\config.properties");
				config.load(fis);
				FileInputStream ORfs = new FileInputStream(
						(System.getProperty("user.dir")) + "\\src\\test\\resources\\Properties\\OR.properties");
				OR.load(ORfs);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}}

	@Test(priority = 0)
	//@Parameters({ "Browser" })
	public void lunchBrowser() {
		//if (Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("chrome driver is lunched");
			System.out.println(config.getProperty("testsiteURL"));
			driver.get(config.getProperty("testsiteURL"));
		/*} else if (Browser.equalsIgnoreCase("edge"))
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Edge driver is lunched");
			driver.get(config.getProperty("testsiteURL"));
		}*/
	}
	@Test(priority=1)
	public void clickBankManagerLogin() throws InterruptedException
	{
		driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		System.out.println("Clicked on Bank Manager login");
		Thread.sleep(1000);
	}

	@Test(priority=2)
	public void clickonAddCustomer() throws InterruptedException
	{
		driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		System.out.println("Clicked on addcustomerButton");
		Thread.sleep(2000);

	}

	@Test(priority=3)
	public void addCustomerDetails() throws InterruptedException
	{
		Thread.sleep(2000);
		System.out.println(OR.getProperty("firstNametxtbox"));
		driver.findElement(By.cssSelector(OR.getProperty("firstNametxtbox"))).sendKeys(config.getProperty("firstName"));
		driver.findElement(By.cssSelector(OR.getProperty("lastNametxtbox"))).sendKeys(config.getProperty("lastName"));
		driver.findElement(By.cssSelector(OR.getProperty("postCodetxtbox"))).sendKeys(config.getProperty("postCode"));
		driver.findElement(By.cssSelector(OR.getProperty("addCostbtn"))).click();
	}



}