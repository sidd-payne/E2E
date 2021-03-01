package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By email = By.xpath("//input[@name='email']");
	By password = By.xpath("//input[@name=' password']");
	By login = By.xpath("//input[@value='Log In']");
	By forgot=By.xpath("//*[@href='password/new/index.php']");
	
	public ForgotPassword forgotPassword(){
		driver.findElement(forgot).click();
		return new ForgotPassword(driver);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
