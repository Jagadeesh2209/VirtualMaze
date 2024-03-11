package com.Vmmaps.Rest;


import org.testng.annotations.Test;

import com.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VmAPI extends BaseClass {

	
	@Test(priority = 0)
	public void launchUrl() {
    launchBrowser("chrome");
    launchUrl("https://www.virtualmaze.com/");
    quitBrowser();
	}
	
	@Test(priority = 1)
	public void getURI1() {
		Response response = RestAssured.given().get("https://www.virtualmaze.com/api/someendpoint");
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);
	}
	@Test(priority = 2)
	public void getURI2() {
		Response response = RestAssured.given().get("https://www.virtualmaze.com/api/someendpoint");
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);
	}
	@Test(priority = 3)
	public void getURI3() {
		Response response = RestAssured.given().get("https://www.virtualmaze.com/api/someendpoint");
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);
	}
	@Test(priority = 4)
	public void getURI4() {
		Response response = RestAssured.given().get("https://www.virtualmaze.com/api/someendpoint");
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);
	}
	@Test(priority = 5)
	public void getURI5() {
		Response response = RestAssured.given().get("https://www.virtualmaze.com/api/someendpoint");
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);
	}
	@Test(priority = 6)
	public void getURI6() {
		Response response = RestAssured.given().get("https://www.virtualmaze.com/api/someendpoint");
        int statusCode = response.getStatusCode();
        System.out.println("Response Code: " + statusCode);
	}
	@Test(priority = 7)
	public void quit() {
		quitBrowser();
	}
	
}
