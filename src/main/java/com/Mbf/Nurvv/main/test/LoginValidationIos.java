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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Mbf.Nurvv.Utilities.AppiumServerSetupiOS;
import com.Mbf.Nurvv.Utilities.User;
import com.Mbf.Nurvv.common.Constants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class LoginValidationIos {

	AppiumDriver<MobileElement> driver;

	AppiumServerSetupiOS appiumServerSetupiOS;
	static Logger log = Logger.getLogger(LoginValidationIos.class);
	List<User> users = FileImporter.getUsers().getUsers();

	@BeforeMethod
	public void beforeCreateAccountValidationRun() {
		appiumServerSetupiOS = new AppiumServerSetupiOS();
		System.out.println("hello1");
		driver = appiumServerSetupiOS.setup();

	}

	// Test case when invalid name format is provided
	@Test(priority = 0)
	public void shouldReturnSuccessWhenLoginCredIsProvided() throws IOException, InterruptedException {
		log.info("Validating shouldReturnSuccessWhenLoginCredIsProvided()");

		//for (User user : users) {

			// to check the landing page
			 new WebDriverWait(driver,
			 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//XCUIElementTypeButton[@name=\"Log In\"]")));
			try {
				// Click on login button
				MobileElement bLoginStarted = driver.findElementByAccessibilityId("Log In");
				bLoginStarted.click();

				// Click and send keys to enter email
				MobileElement textEmail = driver.findElementByAccessibilityId("emailTextField");
				textEmail.sendKeys("aditi@madebyfire.com");
				driver.hideKeyboard();

				// Click and send keys to enter password
				MobileElement textPassword = driver.findElementByAccessibilityId("passwordTextField");
				textPassword.sendKeys("Mbf123456!");
				// driver.hideKeyboard();

				// toggle password
				MobileElement pwdToggle = driver.findElementByAccessibilityId("viewPassword");
				pwdToggle.click();
                  
				
//				String fontSize = driver.findElementByAccessibilityId("Log In").getCssValue("font-size");
//				String fontFamily = driver.findElementByAccessibilityId("Log In").getCssValue("fontFamily");
//				String fontColor = driver.findElementByAccessibilityId("Log In").getCssValue("fontColor");
//				String fontAlign = driver.findElementByAccessibilityId("Log In").getCssValue("text-align");
//				
//				System.out.println("Font Size" + fontSize);
//				System.out.println("Font Style" + fontFamily);
//				System.out.println("Font Color" + fontColor);
//				System.out.println("Font Align" + fontAlign);
				
				
				// hide password
				MobileElement pwdToggleActive = driver.findElementByAccessibilityId("viewPasswordActive");
				pwdToggleActive.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				// Click and un-click on stay logged in button
				MobileElement stayLoggedIn = driver.findElementByAccessibilityId("stayLoggedInSwitch");
				stayLoggedIn.click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				stayLoggedIn.click();

				// Click on login button
				MobileElement clickLoginBtn = driver.findElementByAccessibilityId("loginButton");
				clickLoginBtn.click();

				// navigate to next screen
				MobileElement nav = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"RUN\"]"));
				String navigateScreen = nav.getText();

				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				System.out.println("hello Appium 2----------------------------------->" + navigateScreen);

				// Assert the error text message with expected condition
				boolean condition = Constants.SUCCESSFUL_LOGIN.equals(nav.getText());
				System.out.println("ERROR VALUE HERE ------------------------------------------------> " + nav.getText()
						+ " CONDITION -> " + condition);
				Assert.assertTrue(condition);
				
			} catch (Exception e) {
				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshotFile, new File("/Users/mbf/Documents/Screenshot/error.png"));
			}
		//}

		driver.closeApp();

		log.info("Validated shouldReturnSuccessWhenLoginCredIsProvided()");
	}



	


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

		LoginValidationIos obj = new LoginValidationIos();

		obj.shouldReturnSuccessWhenLoginCredIsProvided();
//		obj.shouldReturnErrorWhenInvalidEmailFormatIsProvided();
//		obj.shouldReturnErrorWhenInvalidPwdFormatIsProvided();

		// obj.validateText();

		obj.tearDown();

	}

}