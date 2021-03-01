package TestClasses;

import java.io.IOException;
import Base.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;

public class validateNavbar extends base{
	public WebDriver driver;
	@BeforeTest
	public void initialise() throws IOException {
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void basePageNavigation() throws IOException {
		// base b=new base();
		LandingPage p = new LandingPage(driver);
		Assert.assertTrue(p.getNavigation().isDisplayed());
		String ul = p.getStr();
		for (int i = 1; i < 9; i++) {
			// System.out.println(ul+"/li["+i+"]");
			System.out.println(driver.findElement(By.xpath(ul + "/li[" + i + "]")).getText());
		}

	}

}
