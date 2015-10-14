package com.Tours.Excercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MethodsReusable{
	public static WebDriver driver;
	
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
  
  public static String[][] readXLFile(String dataTablePath, String sheetName) throws IOException{


		/*Step 1: Get the XL Path*/
		File  xlFile = new File(dataTablePath);

		/*step2: Access the Xl File*/
		FileInputStream  xlDoc  = new FileInputStream(xlFile);

		/*Step3: Access the work book (POI jar file) */
		HSSFWorkbook wb = new HSSFWorkbook(xlDoc);

		/*Step4: Access the Sheet */
		HSSFSheet sheet = wb.getSheet(sheetName);

		/*Get row and col*/
		int iRowCount = sheet.getLastRowNum() + 1;


		int iColCount = sheet.getRow(0).getLastCellNum();

		String[][] xlData = new String[iRowCount][iColCount];

		for(int j = 0; j <iRowCount; j++){
			for(int i = 0; i<iColCount; i++){
				xlData[j][i] = sheet.getRow(j).getCell(i).getStringCellValue() ;
				System.out.print(sheet.getRow(j).getCell(i).getStringCellValue() + " ");
			}
			System.out.println();
		}

		return xlData;
	}
}
