package TestClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.base;
import PageObject.ForgotPassword;
import PageObject.LandingPage;
import PageObject.LoginPage;

public class LoginTest extends base {
	public WebDriver driver;

	@AfterMethod
	public void terminate() {
		driver.close();
	}

	@Test(dataProvider = "getData")
	public void testlogin(String userName, String password, String type) throws IOException, InterruptedException {
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		LoginPage lo=lp.login();
		lo.getEmail().sendKeys(userName);
		lo.getPassword().sendKeys(password);
		lo.getLogin().click();
		
		ForgotPassword fp=lo.forgotPassword();
		fp.sendEmail().sendKeys("john cena");
		Thread.sleep(3000);
		fp.forgotPasswordSendIns();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "siddi@gmail.com";
		data[0][1] = "siddi@fp";
		data[0][2] = "non res";

		data[1][0] = "ss@gmail.com";
		data[1][1] = "sss";
		data[1][2] = "resss";

		return data;
	}

}
