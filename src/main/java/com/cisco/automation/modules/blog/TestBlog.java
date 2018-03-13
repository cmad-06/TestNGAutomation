package com.cisco.automation.modules.blog;

import org.testng.annotations.Test;

import com.cisco.automation.modules.global.CMADTest;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestBlog extends CMADTest{

	@Test(description="test blog ID getting populated automatically in DB")
	public void TestBlogId(){
		
		RequestSpecification httpRequest = CMADTest.getBasicRequestInstance();
		
		Response response = httpRequest.request(Method.GET, "/service/blog/1");
		response.prettyPrint();
		response.then().assertThat().body("blogId", equalTo(1));
	}
	
	
	@Test(description="test blog title getting populated properly in DB")
	public void TestBlogTitle(){
		
		RequestSpecification httpRequest = CMADTest.getBasicRequestInstance();
		
		Response response = httpRequest.request(Method.GET, "/service/blog/1");
		response.prettyPrint();
		response.then().assertThat().body("blogTitle", equalTo("Sample title2"));
	}
	
	
}
