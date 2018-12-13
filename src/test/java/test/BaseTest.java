package test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import pages.BasePage;


public class BaseTest extends BasePage{
	
	public BaseTest() {
		BasePage.LaunchBrowser();
		BasePage.launchUrl();
		
	}
	@AfterSuite (description= "Close Driver", groups= "positiveScenario")
	public void closeBrowser()
	{
	  driver.close();
	}
	


}
