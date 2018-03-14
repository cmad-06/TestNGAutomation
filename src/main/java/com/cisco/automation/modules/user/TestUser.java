package com.cisco.automation.modules.user;

import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cisco.automation.modules.global.CMADTest;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestUser extends CMADTest{

//----------------------------------------------------------------------------------------	

	@Test(description="test user first name getting populated properly in DB")
	public void TestFirstName(){
		
		RequestSpecification httpRequest = CMADTest.getBasicRequestInstance();
		
		Response response = httpRequest.request(Method.GET, "/service/user/1");
		response.prettyPrint();
		response.then().assertThat().body("firstName", equalTo("Vibhor"));
	}

//----------------------------------------------------------------------------------------
	
	@Test(description="test user last name getting populated properly in DB")
	public void TestLastName(){
		
		RequestSpecification httpRequest = CMADTest.getBasicRequestInstance();
		
		Response response = httpRequest.request(Method.GET, "/service/user/1");
		response.prettyPrint();
		response.then().assertThat().body("lastName", equalTo("Jain"));
	}

//----------------------------------------------------------------------------------------
	
	@Test(description="test username getting populated properly in DB")
	public void TestUserName(){
		
		RequestSpecification httpRequest = CMADTest.getBasicRequestInstance();
		
		Response response = httpRequest.request(Method.GET, "/service/user/1");
		response.prettyPrint();
		response.then().assertThat().body("username", equalTo("vjcalling"));
	}

//----------------------------------------------------------------------------------------

	@Test(description="test user email getting populated properly in DB")
	public void TestUserEmail(){
		
		RequestSpecification httpRequest = CMADTest.getBasicRequestInstance();
		
		Response response = httpRequest.request(Method.GET, "/service/user/1");
		response.prettyPrint();
		response.then().assertThat().body("email", equalTo("vibhjain@cisco.com"));
	}
	
//----------------------------------------------------------------------------------------	
	
}
