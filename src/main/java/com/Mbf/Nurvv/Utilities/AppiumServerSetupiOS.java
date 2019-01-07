package com.Mbf.Nurvv.Utilities;


import java.io.File;

/*
 * This Class contain appium server start and stop code
 * @version-0.1
 * @author-Aditi
 */


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.Mbf.Nurvv.main.impl.iPhoneCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class AppiumServerSetupiOS {
	static Logger log = Logger.getLogger(AppiumServerSetupiOS.class);
	AppiumDriverLocalService service;
	
	private static final String APPLICATION_ID = "com.nurvv.flagship.staging";
	static Properties prop = new Properties();
	static {
		BasicConfigurator.configure();
		log.info("Inside AppiumServerSetup Static Block");
		InputStream input = null;
		String workspace = System.getProperty("user.dir");
		try {
			input = new FileInputStream(workspace + "/src/main/resources/config.properties");
			prop.load(input);
		} catch (FileNotFoundException e) {
			log.error("FileNotFoundException in ValidateLogin:", e);
		} catch (IOException e) {
			log.error("IOException in ValidateLogin:", e);
		}

	}
	
	public AppiumDriver<MobileElement> setup(){
		System.out.println("Server about to start....");
//		service = AppiumDriverLocalService.buildDefaultService();
//		service.start();
		AppiumServiceBuilder builder = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.usingDriverExecutable(new File("/usr/local/bin/node"))
				.withArgument(GeneralServerFlag.LOG_LEVEL, "info")
				.withIPAddress("0.0.0.0")
				.usingPort(4723);
				service = AppiumDriverLocalService.buildService(builder);
				service.start();
		System.out.println("Server started .. on port " + service.getUrl().getPort());
		return new IOSDriver<MobileElement>(service.getUrl(), new iPhoneCapabilities().getCapabilities());
		
			
		
		
		
		
	}
	
	public void tearDown() {
		
		log.info("Inside tearDown() closing the driver");
		//service.stop();
		log.info("Driver closed successfully");
		
	}

}
