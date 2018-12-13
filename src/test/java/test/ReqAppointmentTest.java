package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.ReqAppointmentPage;

public class ReqAppointmentTest extends BaseTest {
@BeforeClass(groups="positiveScenario")
	public void login (){
//		BasePage.LaunchBrowser();
//		BasePage.launchUrl();
//		Assert.assertEquals(driver.getTitle(),config.getProperty("landingPageTitle"));
		LoginPage.clrUserName();
		LoginPage.clrPassword();
		LoginPage.entUserName();
		LoginPage.entPassword();
		LoginPage.clkSignIn();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(HomePage.loadingIcon));
		System.out.println("Logged In Passed====>" + driver.getTitle());
	}

@Test(priority = 1,description= "Open Request an Appointment page", groups= "positiveScenario"/*, dependsOnMethods = "login"*/ )
	public void openReqAppointment (){
		HomePage.ReqAppointment();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
@Test(priority = 2,description= "Verify subject in subject box", groups= "positiveScenario" )
	public void entSubject (){
		ReqAppointmentPage.Subject();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
@Test(priority = 3,description= "Verify message in message box", groups= "positiveScenario" )
	public void entMessage (){
		ReqAppointmentPage.Message();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
@Test(priority = 4,description= "Verify send message button", groups= "positiveScenario" )
	public void sendReq (){
		ReqAppointmentPage.SendBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
@AfterClass(groups="positiveScenario")
	public void signOff (){
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(BasePage.msgDialogBox));
	BasePage.logOut();
	Assert.assertEquals(driver.getTitle(),config.getProperty("landingPageTitle"));
	}

}
