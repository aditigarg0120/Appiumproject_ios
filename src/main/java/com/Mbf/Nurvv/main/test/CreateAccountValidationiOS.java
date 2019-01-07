package com.Mbf.Nurvv.main.test;

/*
 * This Class will Store the test cases for create nurvv account 
 * @version-0.1
 * @author-Aditi
 */


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mbf.Nurvv.Utilities.AppiumServerSetupiOS;
import com.Mbf.Nurvv.Utilities.User;
import com.Mbf.Nurvv.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CreateAccountValidationiOS {

	AppiumDriver<MobileElement> driver;
	
	AppiumServerSetupiOS appiumServerSetupiOS;
	static Logger log = Logger.getLogger(CreateAccountValidationiOS.class);
	List<User> users = FileImporter.getUsers().getUsers();

	@BeforeMethod
	public void beforeCreateAccountValidationRun() {
		appiumServerSetupiOS = new AppiumServerSetupiOS();
		System.out.println("hello1");
		driver = appiumServerSetupiOS.setup();
		

	}

	// Test case when invalid name format is provided
	@Test(priority = 0)
	public void shouldReturnErrorWhenInvalidNameFormatIsProvided() throws IOException, InterruptedException {
		log.info("Validating shouldReturnErrorWhenInvalidNameFormatIsProvided()");

		for (User user : users) {

			// to check the landing page
			 new WebDriverWait(driver,
			 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Log In\"]")));

			// Click on Create Account button
			MobileElement bGetStarted = driver.findElementByAccessibilityId("Create Your Account");
			bGetStarted.click();

			// Click and send keys to enter name
			MobileElement textName = driver.findElementByAccessibilityId("emailTextField");
			textName.sendKeys(user.getFullName());
			driver.hideKeyboard();

			// Click and send keys to enter email
			MobileElement textEmail = driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Nurvv\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField[2]"));
			textEmail.sendKeys(user.getEmail());
			driver.hideKeyboard();

			// Click and send keys to enter password
			MobileElement textPassword = driver.findElement(By.xpath(
					"//XCUIElementTypeApplication[@name=\"Nurvv\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField"));
			textPassword.sendKeys(user.getPassword());
			driver.hideKeyboard();

			// To show and hide password
			MobileElement pwdToggle = driver.findElementByAccessibilityId("viewPassword");
			pwdToggle.click();
			pwdToggle.click();

			// Click to sign up button
			MobileElement signUpClick = driver.findElementByAccessibilityId("Sign Up");
			signUpClick.click();

			// find the error message displayed
			MobileElement error = driver.findElement(By.id("textinput_error"));

			String errorMessage = error.getText().toString();

			// Assert the error text message with expected condition

			//boolean condition = Constants.INVALIDNAME_FORMATEXPECTEDSTRING.equals(errorMessage);
//			System.out.println("VALUE HERE --------------------------> " + error.getText().toString() + " CONDITION -> "
//					+ condition);
//
//			Assert.assertTrue(condition);

			MobileElement backButton = driver.findElement(By.id("toolbar_button_action_left"));
			backButton.click();
		}

		driver.closeApp();

		log.info("Validated shouldReturn_Error_WhenInvalidNameFormatIsProvided()");
	}

	// Test case when invalid email format is provided

//	@Test(priority=1)
//	public void shouldReturnErrorWhenInvalidEmailFormatIsProvided() throws IOException, InterruptedException {
//		log.info("Validating shouldReturnErrorWhenInvalidEmailFormatIsProvided()");
//		for(User user: users) {
//		//to check the landing page
//		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("button_create_account")));
//		
//		// Click on Create Account button
//		MobileElement bGetStarted = driver.findElement(By.id("button_create_account"));
//		bGetStarted.click();
//
//		// Click and send keys to enter name
//		MobileElement textName = driver.findElement(By.id("edit_text_name"));
//		textName.sendKeys(user.getFullName());
//		driver.hideKeyboard();
//
//		// Click and send keys to enter email
//		MobileElement textEmail = driver.findElement(By.id("edit_text_email"));
//		textEmail.sendKeys(user.getEmail());
//		driver.hideKeyboard();
//
//		// Click and send keys to enter password
//		MobileElement textPassword = driver.findElement(By.id("edit_text_password"));
//		textPassword.sendKeys(user.getPassword());
//		driver.hideKeyboard();
//		
//		// To show and hide password
//		MobileElement pwdToggle = driver.findElement(By.id("text_input_password_toggle"));
//		pwdToggle.click();
//		pwdToggle.click();
//
//		// Click to sign up button
//		MobileElement signUpClick = driver.findElement(By.id("dev.com.nurvv.app.debug:id/button_sign_up"));
//		signUpClick.click();
//				
//		// expected message
//		// find the error message displayed
//		MobileElement error = driver.findElement(By.id("textinput_error"));
//		
//		String errorMessage = error.getText().toString();
//
//		
//		// Assert the error text message with expected condition
//		
//		
//		boolean condition = Constants.INVALIDEMAIL_FORMATEXPECTEDSTRING.equals(errorMessage);
//		System.out.println("VALUE HERE --------------------------> " + error.getText().toString() + " CONDITION -> " + condition);
//		
//		
//		Assert.assertTrue(condition);
//		MobileElement backButton = driver.findElement(By.id("toolbar_button_action_left"));
//		backButton.click();
//	}
//		
//		driver.closeApp();
//		log.info("Validated shouldReturnErrorWhenInvalidEmailFormatIsProvided()");
//	}

	// Test case when invalid pwd format is provided

//		@Test(priority=2)
//		public void shouldReturnErrorWhenInvalidPwdFormatIsProvided() throws IOException, InterruptedException {
//			log.info("Validating shouldReturnErrorWhenInvalidPwdFormatIsProvided()");
//			for(User user: users) {	
//			//to check the landing page
//			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("button_create_account")));
//			
//			// Click on Create Account button
//			MobileElement bGetStarted = driver.findElement(By.id("button_create_account"));
//			bGetStarted.click();
//
//			// Click and send keys to enter name
//			MobileElement textName = driver.findElement(By.id("edit_text_name"));
//			textName.sendKeys(user.getFullName());
//			driver.hideKeyboard();
//
//			// Click and send keys to enter email
//			MobileElement textEmail = driver.findElement(By.id("edit_text_email"));
//			textEmail.sendKeys(user.getEmail());
//			driver.hideKeyboard();
//
//			// Click and send keys to enter password
//			MobileElement textPassword = driver.findElement(By.id("edit_text_password"));
//			textPassword.sendKeys(user.getPassword());
//			driver.hideKeyboard();
//			
//			// To show and hide password
//			MobileElement pwdToggle = driver.findElement(By.id("text_input_password_toggle"));
//			pwdToggle.click();
//			pwdToggle.click();
//
//			// Click to sign up button
//			MobileElement signUpClick = driver.findElement(By.id("dev.com.nurvv.app.debug:id/button_sign_up"));
//			signUpClick.click();
//					
//			// expected message
//			// find the error message displayed
//			MobileElement error = driver.findElement(By.id("textinput_error"));
//			
//			String errorMessage = error.getText().toString();
//
//			
//			// Assert the error text message with expected condition
//			
//			
//			boolean condition = Constants.INVALIDPWD_FORMATEXPECTEDSTRING.equals(errorMessage);
//			System.out.println("VALUE HERE --------------------------> " + error.getText().toString() + " CONDITION -> " + condition);
//			
//			
//			Assert.assertTrue(condition);
//			MobileElement backButton = driver.findElement(By.id("toolbar_button_action_left"));
//			backButton.click();
//		}
//		
//			driver.closeApp();
//			log.info("Validated shouldReturnErrorWhenInvalidPwdFormatIsProvided()");
//		}

//		// Test case when name , email , pwd inputs are valid
//		
//			@Test(priority=3)
//			public void shouldReturnSuccessWhenValidFormatIsProvided() throws IOException, InterruptedException {
//				log.info("Validating shouldReturnSuccessWhenValidFormatIsProvided()");
//				for(User user: users) {	
//				//to check the landing page
//				new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("button_create_account")));
//				
//				// Click on Create Account button
//				MobileElement bGetStarted = driver.findElement(By.id("button_create_account"));
//				bGetStarted.click();
//
//				// Click and send keys to enter name
//				MobileElement textName = driver.findElement(By.id("edit_text_name"));
//				textName.sendKeys(user.getFullName());
//				driver.hideKeyboard();
//
//				// Click and send keys to enter email
//				MobileElement textEmail = driver.findElement(By.id("edit_text_email"));
//				textEmail.sendKeys(user.getEmail());
//				driver.hideKeyboard();
//
//				// Click and send keys to enter password
//				MobileElement textPassword = driver.findElement(By.id("edit_text_password"));
//				textPassword.sendKeys(user.getPassword());
//				driver.hideKeyboard();
//				
//				// To show and hide password
//				MobileElement pwdToggle = driver.findElement(By.id("text_input_password_toggle"));
//				pwdToggle.click();
//				pwdToggle.click();
//
//				// Click to sign up button
//				MobileElement signUpClick = driver.findElement(By.id("dev.com.nurvv.app.debug:id/button_sign_up"));
//				signUpClick.click();
//						
//				// expected message
//				// find the navigation message displayed
//				MobileElement message = driver.findElement(By.id("toolbar_title"));
//				
//				String successMessage = message.getText().toString();
//
//				
//				// Assert the success text message with expected condition
//				
//				
//				boolean condition = Constants.INVALIDPWD_FORMATEXPECTEDSTRING.equals(successMessage);
//				System.out.println("VALUE HERE --------------------------> " + message.getText().toString() + " CONDITION -> " + condition);
//				
//				
//				//Assert.assertTrue(condition);
//				MobileElement backButton = driver.findElement(By.id("toolbar_button_action_left"));
//				backButton.click();
//			}
//			
//				driver.closeApp();
//				log.info("Validated shouldReturnSuccessWhenValidFormatIsProvided()");
//			}

	@AfterMethod
	public void tearDown() throws Exception {
		appiumServerSetupiOS.tearDown();
		driver.closeApp();
	}

	/**
	 * 
	 * @param args
	 * @throws Exception
	 * 
	 */

	public static void main(String[] args) throws Exception {

		CreateAccountValidationiOS obj = new CreateAccountValidationiOS();

		obj.shouldReturnErrorWhenInvalidNameFormatIsProvided();
//		obj.shouldReturnErrorWhenInvalidEmailFormatIsProvided();
//		obj.shouldReturnErrorWhenInvalidPwdFormatIsProvided();

		// obj.validateText();

		obj.tearDown();

	}

}