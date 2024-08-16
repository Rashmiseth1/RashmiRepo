package com.vtiger.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectrepos.HomePage;
import com.vtiger.objectrepos.LoginPage;
public class Base {
public PropertyFileUtility putil=new PropertyFileUtility();
public ExcelFileUtility eutil=new ExcelFileUtility();
public JavaUtility jutil=new JavaUtility();
public WebDriverUtility wutil=new WebDriverUtility();
//runtime Polymorphism
public WebDriver driver=null;
public static final Logger log = LoggerFactory.getLogger(Base.class);
@BeforeSuite
public void bsconfig() {
	Reporter.log("===DB CONNECTION===",true);
	

}

@BeforeClass
public void bcconfig() throws Throwable {
	String BROWSER = putil.readDataFromPf("browser");
	String URL = putil.readDataFromPf("url");
	if(BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
		Reporter.log("ChromeBrowser has Launched",true);
		
	}
	else if(BROWSER.equals("edge")) {
		driver=new EdgeDriver();
		Reporter.log("EdgeBrowser has Launched",true);
	}
	else if(BROWSER.equals("firefox")) {
		driver=new FirefoxDriver();
		Reporter.log("FireFoxBrowser has Launched",true);
	}
	else {
		System.out.println("Boss U have given Invalid Browser name into PropertyFile");
	}
	driver.get(URL);
	 wutil.maximizeWindow(driver);
	 wutil.pageLoad(driver);
	 
}
@AfterClass
public void tearDown() {
	driver.quit();
	Reporter.log("Close Browser",true);
}
@BeforeMethod
public void loginToApp() throws Throwable {
	String UN = putil.readDataFromPf("un");
	String PWD = putil.readDataFromPf("pwd");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(UN, PWD);
	Reporter.log("User  gets Login To app Successfully",true);	
}
@AfterMethod
public void logoutfomapp() {
	HomePage hp=new HomePage(driver);
	hp.logoutfromApp(driver);
	Reporter.log("User  gets Logout From app Successfully",true);
	
}
@AfterSuite
public void asconfig() {
	Reporter.log("===DB DISCONNECTION===",true);
	try {
		System.out.println("User password\t"+putil.readDataFromPf("un"));
	System.out.println("User password\t"+ putil.readDataFromPf("pwd"));

	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}


