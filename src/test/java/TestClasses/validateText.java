package TestClasses;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import Base.*;

public class validateText extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialise() throws IOException {
		
		driver = initialiseDriver();
		log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("navigated to homepage");
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

	@Test
	public void basePageNavigation() throws IOException {
		// base b=new base();
		LandingPage p = new LandingPage(driver);
		String text = p.getFeaturedText().getText();
		Assert.assertEquals(text, "FEATURED COsURSES");
		System.out.println("Name checked");
		log.info("successfully checked the Name");

	}

}
