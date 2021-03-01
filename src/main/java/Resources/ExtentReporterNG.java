package Resources;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReporterNG {
	ExtentReports extent;
	public ExtentReports getReoprtObject() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentHtmlReporter rep=new ExtentHtmlReporter(path);
		rep.config().setReportName("QA Click");
		rep.config().setDocumentTitle("Test QA");
		
		extent=new ExtentReports()
				;
		extent.attachReporter(rep);
		extent.setSystemInfo("Tester","Raj");
		return extent;
	}

}
