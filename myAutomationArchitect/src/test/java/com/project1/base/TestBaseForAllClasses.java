package com.project1.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class TestBaseForAllClasses {

	//public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;

//	@BeforeClass
	//@Parameters({"Browser"})
	/*public void setup() {
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

			/*if (Browser.equalsIgnoreCase("chrome"))
					{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println("chrome driver is lunched");
				System.out.println(config.getProperty("testsiteURL"));
				driver.get(config.getProperty("testsiteURL"));
			} else if (Browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				System.out.println("Edge driver is lunched");
				driver.get(config.getProperty("testsiteURL"));
			}
		}

	}*/

	public boolean isElementPresent(WebDriver driver,By by)
	{
		try {
		driver.findElement(by);
		return true;
		}catch(NoSuchElementException e)
		{
			e.printStackTrace();
			return false;
		}
	}

	//@AfterClass
	/*public void teadDown() {
		if (driver != null)
			driver.quit();
	}*/

}
