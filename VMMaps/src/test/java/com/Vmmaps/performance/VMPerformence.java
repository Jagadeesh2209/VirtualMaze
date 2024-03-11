package com.Vmmaps.performance;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class VMPerformence extends BaseClass {

	@Test
	public void loadTime() {
		launchBrowser("chrome");
		long startTime = System.currentTimeMillis();
		launchUrl("https://www.virtualmaze.com/");
		long endTime = System.currentTimeMillis();
		long pageLoadTime = endTime - startTime;
		System.out.println("Page Load Time= " + pageLoadTime + " milliseconds");
	}
	
	@Test
	public void networkActivity() {
		launchBrowser("chrome");
		launchUrl("https://www.virtualmaze.com/");
		LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);
		for (LogEntry entry : logs) {
		    System.out.println(entry.getMessage());
		}
	}
	@Test
	public void resourceLoadTime() {
		launchBrowser("chrome");
		launchUrl("https://www.virtualmaze.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        long resourceLoadTime = (Long) js.executeScript("return window.performance.timing.loadEventEnd - window.performance.timing.navigationStart");
        System.out.println("Resource loading time: " + resourceLoadTime + " milliseconds");
	}
	
}
