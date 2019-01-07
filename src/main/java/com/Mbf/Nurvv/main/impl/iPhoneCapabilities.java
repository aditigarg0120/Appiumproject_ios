package com.Mbf.Nurvv.main.impl;

import java.io.File;

import org.openqa.selenium.remote.CapabilityType;

/*
* This Class will Store the Xiaomi device desired capabilities
* @version-0.1
* @author-Aditi
*/

import org.openqa.selenium.remote.DesiredCapabilities;

import com.Mbf.Nurvv.main.IDeviceCapability;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class iPhoneCapabilities implements IDeviceCapability {

	public DesiredCapabilities getCapabilities() {
		DesiredCapabilities cap = new DesiredCapabilities ();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
		cap.setCapability("bundleId", "com.nurvv.dev.r4");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITEST");
		cap.setCapability("xcodeSigningId", "iOS Developer");
		//cap.setCapability("buildName", "#100");
		String ipapath=("/Users/mbf/Documents/Workspace" + "/Nurvv.app");
		File app=new File(ipapath);
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		//System.out.println("------------>" + app.getAbsolutePath());
		//cap.setCapability(CapabilityType.PLATFORM, "Mac");
		//cap.setCapability("xcodeOrgId", "9L9KA7D3KT");
		//cap.setCapability("updatedWDABundleId", "com.nurvv.appiumTest");
		//cap.setCapability("udid", "75275f7ad06a45778bf1e44f707b4fe22a3413f2");
		//cap.setCapability("udid", "c833e9bbb094064d033b4514a53e3e4cbb4246c5");
		return cap;
		
		
		
		
		
		
	}

}
