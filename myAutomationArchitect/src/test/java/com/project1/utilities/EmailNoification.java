package com.project1.utilities;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class EmailNoification {

	static WebDriver driver;

	static Properties prop;

	static String filename;

	static String Env_URL = null;

	static Boolean flag = false;

	static String ENVname = null;

	static Session session = null;

	@Test

	      public static void email() throws IOException

	      {
			/*File file1 = new File("Config\\Environment_Details.properties");
			FileInputStream fileInput1 = null;
	            try
	            {
	                  fileInput1 = new FileInputStream(file1);
	            } catch (FileNotFoundException e)

	            {
	                  e.printStackTrace();
	            }

	            prop = new Properties();
	            prop.load(fileInput1);
	           Env_URL =prop.getProperty("current_Execution_Env");
	            System.out.println("current environment url" +Env_URL);
	            if (Env_URL.contains("onqsmqa"))
	                        {
	                              System.out.println("Accessing QA Environment" +Env_URL);
	                              ENVname="QA Environment";
	                       }

	            else if (Env_URL.contains("onqsmuat"))
	            {
	                  System.out.println("Accessing UAT Environment" +Env_URL);
	                  ENVname="UAT Environment";
	            }

	            else if (Env_URL.contains("onqsmstg"))
	            {
	                  System.out.println("Accessing Stage Environment" +Env_URL);
	                  ENVname="Stage Environment";
	            }*/

	            // Create object of Property file

				Properties props = new Properties();
				// this will set host of server- you can change based on your requirement
				props.put("mail.smtp.host", "smtpmail.gmail.com");
				// set the port of socket factory
				props.put("mail.smtp.socketFactory.port", "587");
				// set socket factory
				props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				// set the authentication to true
				props.put("mail.smtp.auth", "true");
				// set the port of SMTP server
				props.put("mail.smtp.port", "587");
				// This will handle the complete authentication

				session = Session.getDefaultInstance(props,

						new javax.mail.Authenticator() {

							@Override
							protected PasswordAuthentication getPasswordAuthentication() {

								return new PasswordAuthentication("pallavipbagul@gmail.com","Avira123#");
							}
						});

				try {

					// Create object of MimeMessage class

					Message message = new MimeMessage(session);

					// Set the from address

					message.setFrom(new InternetAddress("pallavipbagul@gmail.com"));

					// Set the recipient address

					message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("pallavipbagul@gmail.com"));

					// , Bhavya.Chadha.contractor@hilton.com , Pratik.Popat.contractor@hilton.com

					message.setRecipients(Message.RecipientType.CC,

							InternetAddress.parse("Pallavipb109@gmail.com"));

					// Add the subject link

					message.setSubject("Regression Suite execution is completed in ");

					// Create object to add multimedia type content

					BodyPart messageBodyPart1 = new MimeBodyPart();

					// Set the body of email

					messageBodyPart1.setText(
							"SM automation Regression suite execution is completed, This is an auto generated email,Triggred by automation script");

					// Create another object to add another content

					MimeBodyPart messageBodyPart2 = new MimeBodyPart();

					// Mention the file which you want to send

					/*
					 * filename=(prop.getProperty("emailablereportpath"));
					 *
					 * System.out.println("this is emailable file location"+filename);
					 */

					// String filename =
					// "C:\\Users\\sravan.kumar.annam\\git\\onqsm_regressiontest\\SMAutomation\\test-output\\emailable-report2.html";

					filename = System.getProperty("user.dir") + "\\test-output\\emailable-report.html";

					// Create data source and pass the filename

					DataSource source = new FileDataSource(filename);

					// set the handler

					messageBodyPart2.setDataHandler(new DataHandler(source));

					// set the file

					messageBodyPart2.setFileName("EmailableReport.html");

					// Create object of MimeMultipart class

					Multipart multipart = new MimeMultipart();

					// add body part 1

					multipart.addBodyPart(messageBodyPart2);

					// add body part 2

					// multipart.addBodyPart(messageBodyPart1);

					// set the content

					message.setContent(multipart);

					// finally send the email

					Transport.send(message);

					System.out.println("=====Email Sent=====");

	                  } catch (MessagingException e) {



	                        throw new RuntimeException(e);



	                  }





	            }

}
