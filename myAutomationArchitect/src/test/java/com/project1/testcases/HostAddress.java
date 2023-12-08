package com.project1.testcases;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.annotations.Test;

import com.project1.utilities.MonitoringMail;
import com.project1.utilities.TestConfig;
//import com.w2a.utilities.TestConfig;

//import com.w2a.rough.MonitoringMail;

public class HostAddress {

	@Test
	public void mymail() throws AddressException, MessagingException, UnknownHostException
	{
	MonitoringMail mail = new MonitoringMail();
	String messageBody1 = "http://" + InetAddress.getLocalHost().getHostAddress()
			+ ":8080/job/myAutomationArchitect/HTML_20Report/";


	//mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject,messageBody1);
	mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody1);
}
}