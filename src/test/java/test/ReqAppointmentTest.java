package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.HomePage;

public class ReqAppointmentTest extends BaseTest{
	
@BeforeTest
	public void login (){
		LoginTest login = new LoginTest();
		login.validLogin();
	}

@Test
	public void appointmentReq (){
	HomePage homeObj = new HomePage(driver);
	PageFactory.initElements(driver, homeObj);
	homeObj.ReqAppointment();
	
	
}
}
