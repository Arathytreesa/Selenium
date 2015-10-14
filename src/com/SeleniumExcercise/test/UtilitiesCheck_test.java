package com.SeleniumExcercise.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.Tours.Excercise.BookAFlight;

public class UtilitiesCheck_test {
	WebDriver driver;
	
	  @BeforeTest
	  public void beforeTest() {
		  driver = new FirefoxDriver();
		  driver.get("http://newtours.demoaut.com/");
	  }

  @Test
  public void testCheck() {
	  BookAFlight.FlightBooking();
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }


}
