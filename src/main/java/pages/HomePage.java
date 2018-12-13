package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {
	public static By updateInfo		=	By.xpath("//span[contains(text(),'Update your information')]");
	public static By reqAppointment =	By.xpath("//button[@id='sendApptRequest']");
	public static By payBill		=	By.xpath("//span[contains(text(),'Pay your bill')]");
	public static By sendMessage	=	By.id("sendNewButton");
	public static By loadingIcon	=	By.id("loadingOverlay");
	
	public static void UpdateInfo(){
		driver.findElement(updateInfo).click();
	}
	public static void ReqAppointment(){
		driver.findElement(reqAppointment).click();
	}
	public static void PayBill(){
		driver.findElement(payBill).click();
	}
	public static void SendMessage(){
		driver.findElement(sendMessage).click();
	}

}
