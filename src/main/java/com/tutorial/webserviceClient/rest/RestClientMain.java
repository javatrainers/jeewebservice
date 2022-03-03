package com.tutorial.webserviceClient.rest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.tutorial.webserviceClient.rest.Input;
import com.tutorial.webserviceClient.rest.Output;

public class RestClientMain {

	public static void main(String[] args) {
		testJsonRes(); // Consume get rest service with path param
	}
	
/*	
	Get Http client
	URL = ? includes url and input both
	Response = what output is expected from rest services
		int/string/float etc.. if response is json an object(json compliant)
*/
	public static void testAdd() {
		RestTemplate rt=new RestTemplate ();
		int result=	rt.getForObject( "http://localhost/addCal/12/10", Integer.class);
		System.out.println("result :"+result);
	}
	// get method
	// URL = url include http part + input
	// output = resonse
	public static void testSub() {
		RestTemplate rt=new RestTemplate ();
		int result=	rt.getForObject( "http://localhost/subCal?param1=100&param2=40", Integer.class);
		System.out.println(result);
	}
/*
	Post Http client
	URL = ? includes url 
	Request = if sending json input pass object(json compliant) 
	Response = what output is expected from rest services
		int/string/float etc.. object(json compliant) if response is json
*/
	public static void testMultiplyJsonReq()
	{
		RestTemplate rt=new RestTemplate ();
		Input in=new Input();
		in.param1=150;
		in.param2=20;
		//output_date type result=rt.postForObject( URL, json_compliant_java_object, expected_output_class);
		int result=	rt.postForObject( "http://localhost/jsonReqMul", in , Integer.class);
		System.out.println(result);
		
	}
	public static void testJsonRes()
	{
		RestTemplate rt=new RestTemplate ();
		Output result=	rt.getForObject( "http://localhost/jsonRes/20/5", Output.class);
		System.out.println(result);
		
	}
}
