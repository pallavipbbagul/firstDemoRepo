package com.project1.rough;

import java.io.IOException;
import java.net.InetAddress;

import org.openqa.selenium.WebDriver;

public class TestProperties {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.out.println(System.getProperty("user.dir"));
		System.out.println(InetAddress.getLocalHost().getHostAddress());
		String messageBody="http://"+InetAddress.getLocalHost().getHostAddress()+":8080/job/myAutomationArchitect/HTML_20Report/";
		System.out.println(messageBody);
	}

}
