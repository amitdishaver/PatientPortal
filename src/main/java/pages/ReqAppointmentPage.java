package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReqAppointmentPage extends BasePage {
	public WebDriver driver;

	public ReqAppointmentPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public static By UpdateInfo		=	By.xpath("//span[contains(text(),'Update your information')]");

}
