package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class RegisterUtil {
	//creating a private constructor
	private RegisterUtil(){
		
	}
	private static WebElement register = null;
	private static WebElement firstName= null;
	private static WebElement lastName= null;
	private static WebElement userName= null;
	private static WebElement password= null;
	private static WebElement confirmPassword= null;
	private static WebElement submit= null;
	
	public static WebElement ClickRegister(WebDriver driver){
		{
			register = driver.findElement(By.linkText("REGISTER"));
			return register;
		}

	}

	public static WebElement getfirstName(WebDriver driver){
		{
			firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
			return firstName;
		}
	}
		public static WebElement getlastName(WebDriver driver){
			{
				lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
				return lastName;
			}
		}
			
		public static WebElement getuserName(WebDriver driver){
				{
					userName = driver.findElement(By.xpath("//input[@id='email']"));
					return userName;
				}
		}
		public static WebElement getpassword(WebDriver driver){
			{
				password = driver.findElement(By.xpath("//input[@name='password']"));
				return password;
			}
}
		public static WebElement getconfirmPassword(WebDriver driver){
					{
						confirmPassword = driver.findElement(By.xpath("//input[@name='password']"));
						return confirmPassword;
					}
		}
		public static WebElement getsubmit(WebDriver driver){
			{
		submit = driver.findElement(By.xpath("//input[@name='register']"));
		return submit;
		
	}
		}

}
