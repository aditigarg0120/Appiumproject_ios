package com.Mbf.Nurvv.main.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Mbf.Nurvv.common.Constants;

import io.appium.java_client.MobileElement;

public class Backup {

//	//to check the landing page
//			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.id("button_create_account")));
//			
//			// Click on Create Account button
//			MobileElement bGetStarted = driver.findElement(By.id("button_create_account"));
//			bGetStarted.click();
//
//			// Click and send keys to enter name
//			MobileElement textName = driver.findElement(By.id("edit_text_name"));
//			textName.sendKeys("aditi devR4");
//			driver.hideKeyboard();
//
//			// Click and send keys to enter email
//			MobileElement textEmail = driver.findElement(By.id("edit_text_email"));
//			textEmail.sendKeys("aditi123@madebyfire.com");
//			driver.hideKeyboard();
//
//			// Click and send keys to enter password
//			MobileElement textPassword = driver.findElement(By.id("edit_text_password"));
//			textPassword.sendKeys("Mbf123456!");
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
//			boolean condition = Constants.INVALIDNAME_FORMATEXPECTEDSTRING.equals(errorMessage);
//			System.out.println("VALUE HERE --------------------------> " + error.getText().toString() + " CONDITION -> " + condition);
//			
//			
//			Assert.assertTrue(condition);
}
