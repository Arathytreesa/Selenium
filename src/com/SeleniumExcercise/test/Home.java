package com.SeleniumExcercise.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Tours.Excercise.MethodsReusable;

public class Home extends MethodsReusable{
		
	
@Parameters("browser")

@BeforeClass
  public void SetUp(String browser){
	
        if (browser.equalsIgnoreCase("firefox")) {
               driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
               //Set Path for the executable file
              System.setProperty("webdriver.chrome.driver",
                      "C:\\chromedriver.exe");
               driver = new ChromeDriver();
        }/* else if (browser.equalsIgnoreCase("ie")) {
               // Set Path for the executable file
            //  System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
              // driver = new InternetExplorerDriver();
        }*/ else {
               throw new IllegalArgumentException("The Browser Type is Undefined");
        }
	driver.get("http://newtours.demoaut.com/");
 	}


 @Test
 public void getHomePage(){
	 		 
		 clickMethod("//a[contains(text(),'Home')]","Home");
		
	   
 }
 	 	  
  
  
 @AfterClass
 
  public void TearDown(){
  driver.close();
 	}

}
