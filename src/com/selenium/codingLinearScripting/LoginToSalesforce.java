package com.selenium.codingLinearScripting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginToSalesforce {
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
		if(driver.findElement(By.xpath("//input[@id='username']")).isDisplayed())
		{
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys("arti161@gmail.com");
		}
		else
		{
			System.out.println("Username textbox could not be found");
		}
		if(driver.findElement(By.xpath("//input[@id='password']")).isDisplayed())
		{
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Anjalijose1");
		}
		else
		{
			System.out.println("Password textbox could not be found");
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		if(driver.findElement(By.xpath("//button[@id='Login']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@id='Login']")).click();
		}
		else
		{
			System.out.println("Login button could not be found");
		}
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='owner-choice']/div")).click();
		driver.findElement(By.xpath("//*[@id='walkthrough-callout-controls']/a")).click();
		driver.findElement(By.xpath("//*[@id='walkthrough-callout-close']/img")).click();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//a[contains(text(),'View Company Performance')]")).click();
		driver.findElement(By.xpath("//img[@alt='Close button icon']")).click();
		//driver.findElement(By.xpath("//img[@alt='Close button icon']")).click();
		driver.close();
	String err=driver.findElement(By.xpath("//div[@id='error']")).getText();
	System.out.println("Error occured is "+err);
	driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	driver.close();

	}

}
