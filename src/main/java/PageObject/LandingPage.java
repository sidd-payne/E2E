package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.base;

public class LandingPage {

	WebDriver driver;
	WebDriverWait wait;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	//By link = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By navbar = By.xpath("//div[@class='navbar-header']/following-sibling::nav/ul/li/a");
	By text = By.xpath("//div/h2[text()='Featured Courses']");

	public LoginPage login() {
		
driver.findElement(By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']")).click();
LoginPage lo = new LoginPage(driver);
return lo;
	}

	public WebElement getFeaturedText() {
		return driver.findElement(text);
	}

	public WebElement getNavigation() {
		return driver.findElement(navbar);
	}

//	public WebElement getNav() {
//		return driver.findElement(ul);
//	}
	public String getStr() {
		return "//div[@class='navbar-header']/following-sibling::nav/ul";
	}

}
