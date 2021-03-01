package Base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public WebDriver driver;
	public Properties prop;

	//@Test
	public WebDriver initialiseDriver() throws IOException {
		FileInputStream fs = new FileInputStream(
				"C:\\Users\\sid17\\OneDrive\\Desktop\\selUdemy\\E2E\\src\\main\\java\\Resources\\data.properties");
		prop=new Properties();
		prop.load(fs);
		
		if (prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	if (prop.getProperty("browser").equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		if (prop.getProperty("browser").equals("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} 
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		return driver;
	}
	public String takeScreenshot(String ssName,WebDriver driver) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\reports\\"+ssName+".png";
		FileUtils.copyFile(source,new File(destination)); 
		return destination;
	}

}
