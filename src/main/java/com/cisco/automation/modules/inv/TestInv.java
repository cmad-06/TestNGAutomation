package com.cisco.automation.modules.inv;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestInv {

//---------------------------------------------------------------------------------------------
	
	@BeforeMethod
	public void preSetup(){
		System.out.println("inside before test");
	}
	
//---------------------------------------------------------------------------------------------	
	
	@Test(description="my first test case")
	public void TestSoftAssertion(){
		SoftAssert sa = new SoftAssert();
		System.out.println("Inv test1");
		sa.assertEquals(10, 11);		//soft assertion, continue even on failure
		System.out.println("Inv test1 2nd assert");
		sa.assertEquals(10, 10);
		sa.assertAll();
	}
	
//---------------------------------------------------------------------------------------------	
	
	@Test(description="my second test case")
	public void TestHardAssertion(){
		System.out.println("Inv test1");
		int res = 11;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}

//---------------------------------------------------------------------------------------------

	
	@Test(description="my third test case", groups={"ent"})
	public void TestGrouping(){
		System.out.println("Inv test3");
		int res = 11;
		Assert.assertEquals(res, 10);  //fails here
		System.out.println("Inv test1 2nd assert");	//never executed

	}

//---------------------------------------------------------------------------------------------

}
