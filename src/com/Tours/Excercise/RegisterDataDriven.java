package com.Tours.Excercise;

import java.io.IOException;

public class RegisterDataDriven extends MethodsReusable {
	public static void getDataDrivenRegister() throws IOException{
		
		String dataTablePath="C:/Users/Arathy/Desktop/Workbook3.xls";
		Object[][] recData= MethodsReusable.readXLFile(dataTablePath, "Sheet1");
		clickMethod("//a[contains(text(),'REGISTER')]","Register");
		enterText("//input[@name='firstName']","Arathy", "First Name");
		enterText("//input[@name='lastName']","jose", "Last Name");
	  	enterText("//input[@id='email']","UserName", "Username");
		enterText("//input[@name='password']","Password", "Password");
		enterText("//input[@name='confirmPassword']","ConfirmPassword", "Confirm Password");
		clickMethod("//input[@name='register']","Submit");
	}
	
	

}
