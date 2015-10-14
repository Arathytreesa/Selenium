/**
 * 
 */
package com.selenium.codingLinearScripting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Arathy
 *
 */
public class ForgotPasswordA {
	static WebDriver driver;
	public static void main(String[] args) {
		driver=new FirefoxDriver();
		driver.get("http://www.salesforce.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		if (driver.findElement(By.xpath("//a[contains(text(),'Login')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
			
		}
		else
		{
			System.out.println("Login could not be found");
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]")).click();
		}
		else
		{
			System.out.println("Forgot password link not available");
		}
		driver.findElement(By.xpath("//input[@id='un']")).sendKeys("arti161@gmail.com");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	String str1=driver.findElement(By.xpath("//div[@id='content']")).getText();
	System.out.println("Message displayed is: "+str1);
	//String str2=driver.findElement(By.xpath("//div[@id='forgotPassForm']/div/div")).getText();
	//System.out.println("Message displayed is: "+str2);
	driver.close();
		
	}

}
