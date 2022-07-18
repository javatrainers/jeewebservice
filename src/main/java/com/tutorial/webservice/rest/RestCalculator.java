package com.tutorial.webservice.rest;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;

import io.swagger.annotations.*;
// spring annotation
@RestController
@Api(description="this is my web service to calulcate area")
public class RestCalculator {
	
	
	// http://www.google.com/areaOfSquare = Connected to method areaOfSq
	// @PathVariable = http url input SHOULD BE CONNECTED to Method input
	
	// http://localhost/areaOfSquare/5
		
	@RequestMapping(value = "/areaOfSquare/{input1}", method = RequestMethod.GET)
	@ApiOperation(value="this is webservice that will calulcte are of square for a given side")
	public int areaOfSq(@PathVariable("input1") int sides) {
		int areofSquare=sides * sides;
		return areofSquare;
	}
	
	//http://localhost/areaOfRectangle?length=5&breadth=4
	// from http url "/areaOfRectangle" CONNECTED to methd areaOfRec
	// from http url inputs "length/breadth" CONNECTED to method input "len/bre"
	@RequestMapping(value = "/areaOfRectangle", method = RequestMethod.GET)
	public int areaOfRec(@RequestParam("length") int len,
			@RequestParam("breadth") int bre) {
		int areaOfRe=len * bre;
		return areaOfRe;
	}
	
	
	// http://localhost/jsonReqMul - send json in request body,
	// input type json string
	@RequestMapping(value = "/jsonReqMul",  method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public int mulCalculator(@RequestBody Input in) {
		// "Input" parameter is json compliant java program
		int mul=in.param1 * in.param2;
		return mul;
	}
	
	// http://localhost/complexOutput/50/10
	@RequestMapping(value = "/complexOutput/{input1}/{input2}", 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public 	ComplexJsonOutput  complexOutput(
			@PathVariable("input1") int a, 
			@PathVariable("input2") int b){
		ComplexJsonOutput  co=new ComplexJsonOutput  ();
		co.add=a+b;
		co.sub=a-b;
		co.mul=a*b;
		co.div=a/b;
		return co;
	} 
}