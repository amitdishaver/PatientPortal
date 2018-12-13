package pages;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import utils.ReadExcelSheetData;


//import driverFactory.DriverFactory;
//import utils.inputFileStream;

public class LoginPage extends BasePage{
//	public static WebDriver driver;

//	public LoginPage(WebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	private Map<String, String> myDat;
//	}
	 
	public static By userName		=	By.id("UserName");
	public static By password		=	By.id("Password");
	public static By signIn			=	By.xpath("//input[@value='Sign in']");
	public static By forgotUserName	=	By.xpath("//a[contains(text(),'Forgot username?')]");
	public static By forgotPassword	=	By.xpath("//a[contains(text(),'Forgot password?')]");
	public static By signUp			=	By.id("signup");
	public static By userValidation =	By.xpath("//*[contains(@id,'tooltip')]");
	
	
	static ReadExcelSheetData excel = new ReadExcelSheetData();
	public static void entUserName(){

		try {
			driver.findElement(userName).sendKeys(excel.getMapData("UserName"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void clrUserName(){
		driver.findElement(userName).clear();
	}
	public static void entPassword(){
		try {
			driver.findElement(password).sendKeys(excel.getMapData("Password"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void clrPassword(){
		driver.findElement(password).clear();
	}
	public static void clkSignIn(){
		driver.findElement(signIn).click();
//		return new HomePage(driver);
	}
	public void DoSignUp(){
		driver.findElement(signUp).click();
	}
	public void ForgotUserName(){
		driver.findElement(forgotUserName).click();
	}
	public void ForgotPassword(){
		driver.findElement(forgotPassword).click();
	}
}
