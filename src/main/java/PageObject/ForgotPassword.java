package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	WebDriver driver;
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
	}
	By email=By.xpath("//input[@name='email']");
	By sendIns=By.xpath("//input[@name='commit']");
	
	public WebElement sendEmail() {
		return driver.findElement(email);
	}
	
	public WebElement forgotPasswordSendIns()
	{
		return driver.findElement(sendIns);
	}

}
