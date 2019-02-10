package com.duco.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
 * @author Aditi Garg
 *
 * Version 0.1
 */
public class GoogleHomePage {
	
	// get elements
	@FindBy(how= How.NAME, using = "q")
	private WebElement searchBoxName;
	
	@FindBy(how= How.CSS, using = "input[name='btnK']")
	private WebElement googleSearchButton;
	
	@FindBy(css="input[name='btnI'][type='submit']")
	private WebElement feelingLuckyBtn;
	
	@FindBy(linkText="Terms")
	private WebElement termsLink;
	
	@FindBy(linkText="Gmail")
	private WebElement gmailLink;
	
	@FindBy(id="gbwa")
	private WebElement googleApps;
	
	@FindBy(id="gb36")
	private WebElement youtubeLink;
	
	
	
	// Initialising the Page Objects:
	public GoogleHomePage(WebDriver driver) {
	     PageFactory.initElements(driver,this);
	 }
	


		// Actions
		// Method to get title of page
		public void validateGooglePageTitle(WebDriver driver) {
			 String title=driver.getTitle();
			 Assert.assertEquals(title, "Google");
		}

		// Method to search keyword "inputName"
		public void search(String inputName) {
			searchBoxName.sendKeys(inputName);
		}
		
		public void googleSearch(WebDriver driver) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(googleSearchButton));
			googleSearchButton.click();
		}
		
		
	
		public void feelingLucky(WebDriver driver){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(feelingLuckyBtn));
			feelingLuckyBtn.click();
}

	public void checkLinkText(WebDriver driver, String arg1) {
		switch (arg1) {
		case "Terms":
			this.clickOnTermsLink(driver);
			break;
		case "Gmail":
			this.clickOnGmailLink(driver);
			break;
		case "Google Apps":
			this.clickOnGoogleappsLink(driver);
			break;
		case "You Tube":
			this.clickOnYoutubeLink(driver);
			break;

		}

	}
		
		public void clickOnTermsLink(WebDriver driver){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(termsLink));
			termsLink.click();
		}
		
		public void clickOnGmailLink(WebDriver driver){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(gmailLink));
			gmailLink.click();
		}
		
		public void clickOnGoogleappsLink(WebDriver driver){
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(googleApps));
			googleApps.click();
		}
		
		public void clickOnYoutubeLink(WebDriver driver){
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(youtubeLink));
			youtubeLink.click();
		}
		
		
}
