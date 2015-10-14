/*
 USING REUSABLE METHODS FOR LOGIN OPERATION
 */
package com.selenium.codingLinearScripting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReusableMethodsSampleLogin {
static WebDriver driver;

public static void main(String[] args)throws InterruptedException{
	String expectedErrMsg="Please enter your password";

	driver=new FirefoxDriver();
	driver.get("http://www.salesforce.com/");
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	/*
	 Enabling the click login operation using reusable method clickMethod
	 */
	clickMethod("//a[contains(text(),'Login')]","Login");
		
	Thread.sleep(3000);
	/*
	 Enabling the textbox operations using reusable method enterText
	 */
	enterText("//input[@id='username']","arti161@gmail.com","UserName");
	enterText("//input[@id='password']","Anjalijose1","Password");
	
	Thread.sleep(3000);
	
	clickMethod("//button[@id='Login']","Login to Salesforce");
		
	Thread.sleep(3000);
	clickMethod("//*[@id='owner-choice']/div","Owner");
	clickMethod("//*[@id='walkthrough-callout-controls']/a","Walkthrough");
	clickMethod("//*[@id='walkthrough-callout-close']/img","Close");
	
	validateError("//div[@id='error']",expectedErrMsg,"Error");
	driver.close();
	}
	
	
	
	
/*
 -Created a reusable method 'enterText' for textbox entry.
 -Arguments: objXpath-->Xpath locater for the object
 			: TextVal-->Value entered in the object.
 			:objName-->Name of the object.
 */
public static void enterText(String objXpath, String TextVal, String objName)
{
	if(driver.findElement(By.xpath(objXpath)).isDisplayed())
	{
		driver.findElement(By.xpath(objXpath)).sendKeys(TextVal);
	}
	else
	{
		System.out.println(objName+"textbox could not be found");
	}
	
}
/*
 -Created a reusable method 'clickMethod'for enabling click operations.
 -Arguments: Objxpath,ObjName
 */
public static void clickMethod(String Objxpath,String ObjName){
	if (driver.findElement(By.xpath(Objxpath)).isDisplayed())
	{
		driver.findElement(By.xpath(Objxpath)).click();
		
	}
	else
	{
		System.out.println(ObjName+" could not be found");
	}

}
public static void validateError(String objXpath,String expectedErrMsg, String ObjName ){
	if(driver.findElement(By.xpath(objXpath)).isDisplayed())
			{
		String actualMessage=driver.findElement(By.xpath(objXpath)).getText();
		if(expectedErrMsg.equals(actualMessage))
		{
		System.out.println(actualMessage+" is same as"+expectedErrMsg);
		}
		else{
			System.out.println(actualMessage+" is not same as"+expectedErrMsg);
		}
			}
	else{
		System.out.println(ObjName+" could not be found");
	}
	}

}