package com.SeleniumExcercise.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Tours.Excercise.MethodsReusable;

public class Success extends MethodsReusable {
	
  @Test
  public static void getSuccessPage() {
	  String actual="Thank you for registering. You may now sign-in using the user name and password you've just entered.";
	  String expected=driver.findElement(By.xpath("//tr[3]/td/p[2]/font")).getText();
	  Assert.assertEquals(actual,expected);
  }
}
