package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import driverFactory.DriverFactory;
//import utils.inputFileStream;

public class LoginPage extends BasePage{
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	 
	public  By UserName			=	By.id("UserName");
	public  By Password			=	By.id("Password");
	public  By SignIn			=	By.xpath("//input[@value='Sign in']");
	public  By ForgotUserName	=	By.xpath("//a[contains(text(),'Forgot username?')]");
	public  By ForgotPassword	=	By.xpath("//a[contains(text(),'Forgot password?')]");
	public  By SignUp			=	By.id("signup");
	public 	By userValidation 	=	By.xpath("//*[contains(@id,'tooltip')]");
	
	
	
	public void entUserName(){
		driver.findElement(UserName).sendKeys(config.getProperty("Username"));
	}
	public void clrUserName(){
		driver.findElement(UserName).clear();
	}
	public void entPassword(){
		driver.findElement(Password).sendKeys(config.getProperty("Password"));
	}
	public void clrPassword(){
		driver.findElement(Password).clear();
	}
	public void clkSignIn(){
		driver.findElement(SignIn).click();
	}
	public void DoSignUp(){
		driver.findElement(SignUp).click();
	}
	public void ForgotUserName(){
		driver.findElement(ForgotUserName).click();
	}
	public void ForgotPassword(){
		driver.findElement(ForgotPassword).click();
	}
}
