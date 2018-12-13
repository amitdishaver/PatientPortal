package test;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;

public class LoginTest extends BaseTest{

	
@Test (priority = 4,description= "To verify user should be login with valid username and passeord", groups= "positiveScenario")
	public void validLogin(){

		LoginPage.clrUserName();
		LoginPage.clrPassword();
		LoginPage.entUserName();
		LoginPage.entPassword();
		LoginPage.clkSignIn();
		Assert.assertEquals(driver.getTitle(),config.getProperty("homePageTitle"));

	}
@Test (priority = 1, description= "To verify user should not be login with blank username and passeord", groups= "negativeScenario")
	public void blankLogin(){
		LoginPage.clkSignIn();
		WebDriverWait wait = new WebDriverWait(driver,30);
//		Assert.tru
//		assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.userValidation)));
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.userValidation));
	}
@Test (priority = 2,description= "To verify user should not be login with blank username", groups= "negativeScenario" )
	public void blankUser() {
		LoginPage.entPassword();
		LoginPage.clkSignIn();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(LoginPage.userValidation));
	}
@Test (priority = 3, description= "To verify user should not be login with blank passeord", groups= "negativeScenario" )
	public void blankPassword() {
		LoginPage.entUserName();
		LoginPage.clkSignIn();
	}
		
@AfterClass(groups="positiveScenario"/*, dependsOnMethods = "validLogin"*/)
	public void signOff() {
		BasePage.logOut();
		Assert.assertEquals(driver.getTitle(),config.getProperty("landingPageTitle"));
//		driver.quit();
	}

}
