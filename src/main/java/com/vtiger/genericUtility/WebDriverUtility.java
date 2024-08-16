package com.vtiger.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class WebDriverUtility {
	
	/**
	 * This Method is use to maximize the window
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
		
	}
		/**
		 * This method minimize window
		 * @param driver
		 */
	public void minimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
	}
	/**
	 * This method wait till entire webpage load.
	 * @param driver
	 */
	public void pageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	
	
	/**
	 * This method handle Drop down by Index
	 * @param ele
	 * @param index
	 */
	public void dropDrown(WebElement ele,int index) {
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	
	/**
	 * This method is handle DropDown by Value
	 * @param ele
	 * @param value
	 */
	public void dropDown(WebElement ele , String value) {
		Select s= new Select(ele);
		s.selectByValue(value);
	}
	
	
	/**
	 * This method is handle DropDown by visible Text
	 * @param text
	 * @param ele
	 */
	public void dropDown(String text , WebElement ele) {
		Select s= new Select(ele);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method used to move the cursor.
	 * @param driver
	 * @param ele
	 */
	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions a= new Actions(driver);
		a.moveToElement(ele).perform();;
	}
	
	/**
	 * This method is use to RightClick on Element.
	 * @param driver
	 * @param ele
	 */
	public void rightClickOnElement(WebDriver driver,WebElement ele) {
		Actions a= new Actions(driver);
		a.contextClick(ele).perform();
	}
	
	/**
	 * This method is use to click on element.
	 * @param driver
	 * @param ele
	 */
	public void clickOnElement(WebDriver driver,WebElement ele) {
		Actions a = new Actions(driver);
		a.click(ele).perform();
	}
	
	/**
	 * This method is use for DragDrop 
	 * @param driver
	 * @param src
	 * @param desc
	 */
	public void dragDrop(WebDriver driver, WebElement src, WebElement desc) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, desc);
	}
	
	/**
	 * This method is use to take Screenshot.
	 * @param driver
	 */
	public void takeScreenshot(WebDriver driver) { 
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File desc= new File("./" + "\\rashi\\Screenshot");
		try {
			Files.copy(src, desc);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

	
