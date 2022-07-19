package com.tutorial.webservice.soap;

import java.util.ArrayList;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT, 
	parameterStyle = ParameterStyle.WRAPPED)
public class SoapCalculator {
	public int add(int p1, int p2) {
		System.out.println("adding " + p1 + "  " + p2);
		return p1 + p2;
	}
	public int mul(int p1, int p2) {
		System.out.println("multiplying " + p1 + "  " + p2);
		return p1 * p2;
	}
	public int div(int p1, int p2) throws Exception {
		System.out.println("dividing " + p1 + "  " + p2);
		return p1 / p2;
	}
	public int sub(int p1, int p2) {
		System.out.println("substraction " + p1 + "  " + p2);
		return p1 - p2;
	}
	
}



//@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.WRAPPED)