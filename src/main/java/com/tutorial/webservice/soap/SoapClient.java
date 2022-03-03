package com.tutorial.webservice.soap;

import com.tutorial.webserviceClient.soap.stub.SoapCalculator;
import com.tutorial.webserviceClient.soap.stub.SoapCalculatorService;

public class SoapClient {

	public static void main(String[] args) {
		SoapCalculatorService service=new SoapCalculatorService();
		SoapCalculator port=service.getSoapCalculatorPort();
		int result=port.add(100, 35);
		System.out.println(result);
		
	}

}
