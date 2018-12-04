package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	

@Test (priority = 4,description= "To verify user should be login with valid username and passeord", groups= "positive scenario" )
	public void validLogin(){
		LoginPage loginObj = new LoginPage(driver);
		PageFactory.initElements(driver, loginObj);
		loginObj.clrUserName();
		loginObj.clrPassword();
		loginObj.entUserName();
		loginObj.entPassword();
		loginObj.clkSignIn();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingOverlay")));
		System.out.println("Logged In Passed====>" + driver.getTitle());
		
	}
@Test (priority = 1, description= "To verify user should not be login with blank username and passeord", groups= "negative scenario" )
	public void blankLogin(){
		LoginPage loginObj = new LoginPage(driver);	
		PageFactory.initElements(driver, loginObj);
		loginObj.clkSignIn();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginObj.userValidation));
	}
@Test (priority = 2,description= "To verify user should not be login with blank username", groups= "negative scenario" )
	public void blankUser() {
		LoginPage loginObj = new LoginPage(driver);
		PageFactory.initElements(driver, loginObj);
		loginObj.entPassword();
		loginObj.clkSignIn();
	}
@Test (priority = 3, description= "To verify user should not be login with blank passeord", groups= "negative scenario" )
	public void blankPassword() {
		LoginPage loginObj = new LoginPage(driver);
		PageFactory.initElements(driver, loginObj);
		loginObj.entUserName();
		loginObj.clkSignIn();
	}
		
@Test (priority = 5, description= "To verify user should be logout")
	public void logOut() {
		BasePage baseObj = new BasePage(driver);
		PageFactory.initElements(driver, baseObj);
		baseObj.logOut();
	}

}
