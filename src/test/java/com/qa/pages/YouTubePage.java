package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YouTubePage {
	WebDriver driver;
	
	//search
	@FindBy(xpath="//input[@id=\"search\"]")
	WebElement searchBox;
	
	public WebElement getsearchBox() {
		return searchBox;
	}
	
	//SearchItems 
	@FindAll(@FindBy(xpath="//li[@class=\"sbsb_c gsfs\"]"))
	List<WebElement> SearchItems;
	public List<WebElement> getSearchItems() {
		return SearchItems;
	}
	
	//SearchButton 
	@FindBy(xpath="//*[@id=\"search-icon-legacy\"]")
	WebElement searchButton;

	public WebElement getsearchButton() {
		
		return searchButton;
	}
	
	//videoTitles  
	@FindAll(@FindBy(xpath="//a[@id='video-title']"))
	List<WebElement> videoTitle;

	public List<WebElement> getvideoTitle() {
		
		return videoTitle;
	}
	
	//clickOnChannel  
	@FindBy(xpath="//body/ytd-app[1]/div[1]/ytd-page-manager[1]/ytd-search[1]/div[1]/ytd-two-column-search-results-renderer[1]/div[1]/ytd-section-list-renderer[1]/div[2]/ytd-item-section-renderer[1]/div[3]/ytd-channel-renderer[1]/div[1]/div[1]/a[1]/div[1]/yt-img-shadow[1]/img[1]")
	WebElement clickImage;

	public WebElement getclickImage() {
		
		return clickImage;
	}
	
	//playList  
	@FindBy(xpath="//*[@id=\"tabsContent\"]/tp-yt-paper-tab[3]/div")
	WebElement playList;

	public WebElement getplayList() {
		
		return playList;
	}
	
	//listToPlay 
	@FindAll(@FindBy(xpath="//a[@class=\"yt-simple-endpoint style-scope ytd-grid-playlist-renderer\"]"))
	List<WebElement> listToPlay ;
	public List<WebElement> getlistToPlay () {
		return listToPlay;
	}
	
	//channelName   
	@FindBy(xpath="//div[@id='inner-header-container']//div[@id='meta']//ytd-channel-name[@id='channel-name']//div[@id='container']//div[@id='text-container']//yt-formatted-string[@id='text']")
	WebElement channelName;

	public WebElement getchannelName() {
		
		return channelName;
	}
	
	//subscribers  
	@FindBy(xpath="//*[@id=\"subscriber-count\"]")
	WebElement subscribers;

	public WebElement getsubscribers() {
		
		return subscribers;
	}
	
	//channelNames
	@FindBy(xpath="//ytd-channel-name[@id='channel-title']//div[@id='container']//div[@id='text-container']//yt-formatted-string[@id='text']")
	WebElement channelNames;

	public WebElement getchannelNames() {
		
		return channelNames;
	}
	
	//No of PlayList 
	@FindAll(@FindBy(xpath="//a[@class=\"yt-simple-endpoint style-scope ytd-grid-playlist-renderer\"]/../../ytd-playlist-thumbnail[1]//ytd-thumbnail-overlay-side-panel-renderer/yt-formatted-string"))
	List<WebElement> NoofVideos ;
	public List<WebElement> getNoofVideos() {
		return NoofVideos;
	}
	
	public YouTubePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		

}
}
