package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HealthSummaryPage extends BasePage{
	
	public static By name		=	By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]");
	public static By dob		=	By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[3]/div[2]");
	public static By sex		=	By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[4]/div[2]");
	public static By email		=	By.xpath("/html[1]/body[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[10]/div[2]/div[1]");
	
	
	public static void getName() {
		WebElement val_name = driver.findElement(name);	
	}
	public static void getDob() {
		WebElement Val_Dob =  driver.findElement(dob);	
	}
	public static void getSex() {
		WebElement val_sex =  driver.findElement(sex);	
	}
	public static void getEmail() {
		WebElement val_email =  driver.findElement(email);	
	}
}
