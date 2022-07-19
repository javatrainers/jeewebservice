package com.tutorial.webserviceClient.rest;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.tutorial.webservice.rest.ComplexJsonOutput;
import com.tutorial.webserviceClient.rest.Input;
import com.tutorial.webserviceClient.rest.Output;

public class RestClientMain {

	public static void main(String[] args) {
		testJsonOutputService();
	}
	public static void testJsonOutputService() {
		RestTemplate rt=new RestTemplate ();
		ComplexJsonOutput result=rt.getForObject("http://localhost/complexOutput/50/10", ComplexJsonOutput.class);
		System.out.println(result.add);
		System.out.println(result.sub);
		System.out.println(result.mul);
		System.out.println(result.div);
	}
	public static void testJsonInputService() {
		RestTemplate rt=new RestTemplate ();
		Input in=new Input();
		in.param1=10;
		in.param2=20;
		int result=rt.postForObject("http://localhost/jsonReqMul", in , Integer.class);
		System.out.println(result);
	}
	public static void testAreaOfRectangle() {
		RestTemplate rt=new RestTemplate ();
		int result=rt.getForObject("http://localhost/areaOfRectangle?length=4&breadth=10", Integer.class);
		System.out.println(result);
	}
	
	public static void testAreaOfSquare() {
		RestTemplate rt=new RestTemplate ();
		int result=rt.getForObject("http://localhost/areaOfSquare/20", Integer.class);
		System.out.println(result);
	}
/*	
	Get Http client
	URL = ? includes url and input both
	Response = what output is expected from rest services
		int/string/float etc.. if response is json an object(json compliant)
*/
}
