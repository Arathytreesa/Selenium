package com.SeleniumExcercise.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Tours.Excercise.MethodsReusable;

public class Register extends MethodsReusable {
	static Success obj= new Success();
		
	@Parameters("browser")
	
	@BeforeClass
	  public void SetUp(String browser){
		
            if (browser.equalsIgnoreCase("firefox")) {
                   driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("chrome")) {
                   // Set Path for the executable file
                 //  System.setProperty("webdriver.chrome.driver",
                           //     "D:\\chromedriver.exe");
                   driver = new ChromeDriver();
            } /*else if (browser.equalsIgnoreCase("ie")) {
                   // Set Path for the executable file
                  // System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
                  // driver = new InternetExplorerDriver();
            }*/ else {
                   throw new IllegalArgumentException("The Browser Type is Undefined");
            }
		driver.get("http://newtours.demoaut.com/");
	 	}
	
	@DataProvider(name="DynamicUsername")
	
		public Object[][] userdata(){
		  return new Object[][]{
				  {"Ab","12","12"},
				  {"Abc","123","123"},
				  {"Abcd","1234","1234"},
				  {"Abcde","12345","12345"},
				  {"Abcdef","123456","123456"}
		  };
	  }
		
	@Test(dataProvider="DynamicUsername")
  
	  public static void getRegister(String UserName, String Password , String ConfirmPassword){
	  clickMethod("//a[contains(text(),'REGISTER')]","Register");
	  enterText("//input[@name='firstName']","Arathy", "First Name");
	  enterText("//input[@name='lastName']","jose", "Last Name");
  	  enterText("//input[@id='email']",UserName, "Username");
	  enterText("//input[@name='password']",Password, "Password");
	  enterText("//input[@name='confirmPassword']",ConfirmPassword, "Confirm Password");
	  clickMethod("//input[@name='register']","Submit");
	  Success.getSuccessPage();
	  }
	  
	  @AfterClass
	  public void TearDown(){
	  driver.close();
	 	}
	
	  
	  
  }

