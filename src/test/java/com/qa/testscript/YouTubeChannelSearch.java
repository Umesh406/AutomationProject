package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class YouTubeChannelSearch extends TestBase{
	
	@Test(dataProvider="getData")
    public void searchChannelName(String channelName) throws IOException, InterruptedException 
     {
	  int i=0;
	  yt.getsearchBox().clear();
      yt.getsearchBox().sendKeys(channelName);
      yt.getsearchButton().click();
      Thread.sleep(5000);
	  String name = yt.getchannelNames().getText();
	
            if(name.equals(channelName))
			{
				Reporter.log("Channel Name is same as SearchName",true);
				Thread.sleep(5000);
				yt.getclickImage().click();
			    Thread.sleep(3000);
			    Reporter.log("No of subscribers for this channel is :"+yt.getsubscribers().getText(),true);
				Thread.sleep(3000);
				yt.getplayList().click();
				Thread.sleep(5000);
				JavascriptExecutor Js = (JavascriptExecutor)driver;
				for(int j=0;j<=7;j++)
				{
			    Js.executeScript("window.scrollBy(0,500)");
			    Thread.sleep(3000);
				}
				Thread.sleep(3000);
			    List<WebElement> playListItems = yt.getlistToPlay();
			    List<WebElement> Numbers =yt.getNoofVideos();
			    Reporter.log("PlayList of searched channel :",true);
			    for(WebElement playListItem:playListItems)
				{
					
						
						Reporter.log(i+1+"."+playListItem.getText()+"  "+"has "+Numbers.get(i).getText()+" videos.",true);
						i++;
						
						
				}
				Reporter.log("-----------------------------------------------",true);
				Assert.assertTrue(true);
				
			}
			else
			{
				takeScreenShot(driver,"searchChannelName");
				Reporter.log("Channel Name is not same as SearchName",true);
				Reporter.log("-----------------------------------------------",true);
				Assert.assertTrue(false);
			}
		
 }	
	
	 @DataProvider
     public String[][] getData() throws IOException
     {
  	   String xFile="C:\\Users\\saisa\\eclipse-workspace\\AutomationProject\\src\\test\\java\\com\\qa\\testdata\\InputData.xlsx";
  	   String xSheet="Sheet1";
  	   int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
  	   int cellCount= ExcelUtility.getCellCount(xFile, xSheet, rowCount);
  	   String[][] data = new String[rowCount][cellCount];
  	   for(int i=1;i<=rowCount;i++)
  	   {
  		   for(int j=0;j < cellCount;j++)
  		   {
  			   data[i-1][j]= ExcelUtility.getData(xFile, xSheet, i, j);
  		   }
  	   }
  	   return data;
  	   
     }
	
	

}
