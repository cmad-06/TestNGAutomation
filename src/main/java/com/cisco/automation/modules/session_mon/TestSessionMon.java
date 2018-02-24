package com.cisco.automation.modules.session_mon;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSessionMon {

	@Test(description="my first session mon test case", dependsOnMethods={"TestDependency2"})
	public void TestDependency1(){
		System.out.println("Session mon test1");
		int res = 11;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}
	
	@Test(description="my second session mon test case")
	public void TestDependency2(){
		System.out.println("Session mon test2");
		int res = 11;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}
	
	@Test(description="my third session mon test case")
	public void TestDependency3(){
		System.out.println("Session mon test3");
		int res = 11;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}
	
}
