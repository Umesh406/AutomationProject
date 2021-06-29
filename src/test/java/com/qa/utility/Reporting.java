package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	ExtentHtmlReporter htmlReport;
	ExtentReports reports;
	ExtentTest test;
	
	
	
	
	 public void onStart(ITestContext testContext) 
	 {
		 String time = new SimpleDateFormat("yyyy.dd.MM.HH.mm").format(new Date());
		 String repName="Test-Execution-Report"+time+".html";
		 String des =System.getProperty("user.dir")+"/Reports/"+repName;
		 
		 htmlReport = new ExtentHtmlReporter(des);
		 htmlReport.config().setDocumentTitle("Automation Testing");
		 htmlReport.config().setReportName("Functional Testing");
		 htmlReport.config().setTheme(Theme.DARK);
		 htmlReport.config().setAutoCreateRelativePathMedia(true);
		 
		 reports = new ExtentReports();
		 reports.attachReporter(htmlReport);
		 reports.setSystemInfo("HostName", "LocalHost");
		 reports.setSystemInfo("QA Name", "Umesh");
		 reports.setSystemInfo("OS", "Windows");
		 reports.setSystemInfo("version", "Windows 10");
		 reports.setSystemInfo("Processor","i3");
		 }

	 
	  public void onFinish(ITestContext testContext) {
		  reports.flush();
		  
	  }
	  
	  public void onTestSuccess(ITestResult tr) {
		  test = reports.createTest(tr.getName());
		  test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),  ExtentColor.GREEN));
	      test.log(Status.PASS,"Test is Passed");
		   
		  }

		
		  public void onTestFailure(ITestResult tr) {
			  test = reports.createTest(tr.getName());
			  test.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),  ExtentColor.RED));
		      test.log(Status.FAIL,"Test is Failed");
		      test.log(Status.FAIL,tr.getThrowable());
		      
		      String path = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		      File file = new File(path);
		      if(file.exists()) {
		    	  
		    	  try
		    	  {
		    		  test.fail("Screenshot for the failed test :"+ test.addScreenCaptureFromPath(path));
		         }
		    	  catch(IOException e) 
		    	  {
		    		  e.printStackTrace();
		    	  }
		      }
		      
		      
		  }

		 
		  public void onTestSkipped(ITestResult tr) {
			  test = reports.createTest(tr.getName());
			  test.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),  ExtentColor.ORANGE));
		      test.log(Status.SKIP,"Test is Skipped");
		      test.log(Status.SKIP,tr.getThrowable());
		   
		  }

		  


}
