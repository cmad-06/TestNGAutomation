package com.cisco.automation.modules.global;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

/**
 * 
 * @author vibhjain
 *
 */
@SuppressWarnings("restriction")
public class CMADTest {

	private static String app_ip;
	private static String app_username;
	private static String app_password;
	private static String jsessionid;
	
	public final static Logger logger = Logger.getRootLogger();

	
//----------------------------------------------------------------------------------------------------------------------	
	
	/**
	 * This method is used to pre-configure automation framework with App configurations.
	 * @param ip	IP address of App server
	 * @param app_user username
	 * @param app_pwd password
	 */
	@BeforeSuite(alwaysRun=true)
	@Parameters({"server_ip","username", "password"})
	public void setup(String ip, String app_user, String app_pwd){
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.baseURI = "http://"+ ip + ":8080/heapunderflow";
		app_username = app_user;		//Initializing global configurations
		app_password = app_pwd;
		app_ip = ip;
		
	
	}
	
	
//----------------------------------------------------------------------------------------------------------------------
	
	/**
	 * This method is responsible for creating RequestSpecification based httpRequest object with basic auth done.
	 * @return RequestSpecification object with Authorization header.
	 */
	public static RequestSpecification getBasicRequestInstance(){
				
		RequestSpecification httpRequest = RestAssured.given();
		try{
			String encodedAuth = getBase64EncodedAuth();
			httpRequest.header("Authorization", "Basic "+ encodedAuth);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return httpRequest;
	}

//----------------------------------------------------------------------------------------------------------------------

	/**
	 * This method is responsible for creating RequestSpecification based httpRequest object with JSESSIONID and Referer header
	 * @return RequestSpecification object with JSESSIONID and Referer.
	 */
	public static RequestSpecification getHTTPRequestInstance(){
		
		RequestSpecification httpRequest = getBasicRequestInstance();	//get basic instance and add JSESSIONID in cookies
		httpRequest.cookies("JSESSIONID", jsessionid);
		httpRequest.header("Referer", "https://" + app_ip + ":8443/emsam/index.html");	//This header is required for most of the REST endpoints under modules
		return httpRequest;
	}

//----------------------------------------------------------------------------------------------------------------------

	/**
	 * This method is responsible for creating RequestSpecification based httpRequest object with content-type and accept header
	 * @return RequestSpecification object with content-type and Accept header.
	 */
	public static RequestSpecification getHTTPRequestInstanceWithHeaders(ContentType contentType, ContentType accept){
		
		RequestSpecification httpRequest = getHTTPRequestInstance();
		if(contentType != null)
			httpRequest.contentType(contentType);
		if(accept != null)
			httpRequest.accept(accept);
		return httpRequest;
	}

//----------------------------------------------------------------------------------------------------------------------

	/**
	 * This method takes App creds and convert them into Base64 encoded string which is used for Authorization
	 * @return Base64 encoded string
	 * @throws UnsupportedEncodingException
	 */
	public static String getBase64EncodedAuth() throws UnsupportedEncodingException{
		
		String auth = app_username+":"+app_password;
		String encodedAuth = DatatypeConverter.printBase64Binary(auth.getBytes("UTF-8"));
		return encodedAuth;
	}
	
//----------------------------------------------------------------------------------------------------------------------
	
}
