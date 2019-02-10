package com.duco.pageobjects;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.duco.util.Utility;

/**
 * @author Aditi Garg
 *
 * Version 0.1
 */
public class SearchResultPage {

	@FindBy(className = "LC20lb")
	List<WebElement> searchResultClassname;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/c-wiz/div/div/div[2]/div[3]/c-wiz/div/div/h1")
	private WebElement termsPage;

	@FindBy(className = "h-c-header__product-logo-text")
	private WebElement gmailPage;

	// Initializing the Page Objects:
	public SearchResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Actions

	// Method to get title of page
	public void validateSearchResultPageloaded(String titleArg, WebDriver driver) {
		String title = driver.getTitle();
		Assert.assertEquals(title, titleArg + " - Google Search");

	}

	public void validateUrl(WebDriver driver) {
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "https://du.co/");

	}

	public void validateTermsPage() {
		Assert.assertEquals(termsPage.getText(), "GOOGLE TERMS OF SERVICE");
	}

	public void validateGmailPage(WebDriver driver) {
		// System.out.println(gmailPage.);
		Assert.assertEquals(driver.getTitle(), "Gmail - Free Storage and Email from Google");
	}

	public void validateYoutubePage(WebDriver driver) {
		// System.out.println(gmailPage.);
		Assert.assertEquals(driver.getTitle(), "YouTube");
	}

	// Method to get search list of web element which contains particular string
	// and takes screenshot while navigating to each page
	public void elementsList(WebDriver driver) throws InterruptedException {

		String pagesearch = driver.getCurrentUrl();
		if (!searchResultClassname.isEmpty()) {
			System.out.println("total sites found - " + searchResultClassname.size());
			String pattern = ".*Duco.*";
			Pattern r = Pattern.compile(pattern);
			for (int i = 0; i < searchResultClassname.size(); i++) {
				try {
					Matcher m = r.matcher(searchResultClassname.get(i).getText());
					if (m.matches()) {
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
						searchResultClassname.get(i).click();
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
					    Utility.takeScreenshotAtEndOfTest("Url_" + (i + 1) + "_");				
						driver.navigate().to(pagesearch);
						driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

					}
				} catch (TimeoutException e) {
					System.out.println(
							"Page: " + searchResultClassname.get(i).getText() + " did not load within 40 seconds!");
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
}