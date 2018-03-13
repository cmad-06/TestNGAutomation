package com.cisco.automation.modules.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.cisco.automation.modules.global.CMADTest;

public class TestUser extends CMADTest{

	@Test(description="my first session mon test case", dependsOnMethods={"TestDependency2"})
	public void TestDependency1(){
		System.out.println("Session mon test1");
		int res = 10;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}
	
	@Test(description="my second session mon test case")
	public void TestDependency2(){
		System.out.println("Session mon test2");
		int res = 10;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}
	
	@Test(description="my third session mon test case")
	public void TestDependency3(){
		System.out.println("Session mon test3");
		int res = 10;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}
	
}
