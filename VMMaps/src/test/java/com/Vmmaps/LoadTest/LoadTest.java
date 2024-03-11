package com.Vmmaps.LoadTest;

import com.base.BaseClass;
import com.pageObjectManager.PageObjectManager;

public class LoadTest extends BaseClass{
	

	PageObjectManager pom = new PageObjectManager(driver);
	public void multiUser() {
		int numUsers = 10;
		long[] time= new long[10];

	    for (int i = 0; i < numUsers; i++) {
	        
	    	long startTime = System.currentTimeMillis();
	        launchBrowser("chrome");
	        launchUrl("https://www.virtualmaze.com/");
	        pom.getVMSignin().getSigninbtn().click();
			pom.getVMSignin().getUsername().sendKeys("jagadeeshkrishnan2209@gmail.com");
			pom.getVMSignin().getPassword().sendKeys("Virtualmaze");
			pom.getVMSignin().getLoginBtn().click();
			long endTime = System.currentTimeMillis();
			long pageLoadTime = endTime - startTime;
			time[i]=pageLoadTime;
			System.out.println("Time taken for user"+i+" ="+time[i]);
	        quitBrowser();
	}
	    
	
}
}
