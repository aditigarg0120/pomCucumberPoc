package com.duco.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.duco.base.Base;
import com.duco.pageobjects.GoogleHomePage;
import com.duco.pageobjects.SearchResultPage;
import com.duco.util.Utility;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Aditi Garg
 *
 * Version 0.1
 */
public class GoogleHome {
	WebDriver driver;
	GoogleHomePage googleHomePage;
	SearchResultPage searchResultPage;
	Base base;

	@Given("^I am on the homepage$")
	public void i_m_on_the_homepage() throws Throwable {
		base = new Base();
		driver = base.initialization();
		driver.get(Base.prop.getProperty("url"));
		googleHomePage = new GoogleHomePage(driver);
	}

	@Then("^I should see the title of the page$")
	public void i_should_see_the_header() throws Throwable {
		googleHomePage.validateGooglePageTitle(driver);

	}

	@When("^I type \"([^\"]*)\" into the search field$")
	public void i_type_into_the_search_field(String arg1) throws Throwable {
		googleHomePage.search(arg1);
	}

	@And("^I click the Google Search button$")
	public void i_click_the_Google_Search_button() throws Throwable {
		googleHomePage.googleSearch(driver);
	}

	@And("^I see the \"([^\"]*)\" page search results$")
	@Then("^I should see the \"([^\"]*)\" page search results$")
	public void i_should_see_the_duco_page_search_results(String arg1) throws Throwable {
		System.out.println(arg1);
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.validateSearchResultPageloaded(arg1, driver);
	}

	@When("^I click the I’m Feeling Lucky button$")
	public void i_click_the_I_m_Feeling_Lucky_button() throws Throwable {
		googleHomePage.feelingLucky(driver);
	}

	@Then("^I should see a duco website home page$")
	public void i_should_see_a_duco_website_home_page() throws Throwable {
		searchResultPage = new SearchResultPage(driver);

	}

	@When("^I click on \"([^\"]*)\" link$")
	public void i_click_on_link(String arg1) throws Throwable {
		googleHomePage.checkLinkText(driver, arg1);
	}

	@Then("^I should see the Privacy & Terms Page$")
	public void i_should_see_the_Privacy_Terms_Page() throws Throwable {
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.validateTermsPage();
	}

	@Then("^I should see the Gmail website$")
	public void i_should_see_the_Gmail_website() throws Throwable {
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.validateGmailPage(driver);
	}

	@Then("^I should see the You tube page$")
	public void i_should_see_the_You_tube_page() throws Throwable {
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.validateYoutubePage(driver);
	}

	@Then("^I should see \"([^\"]*)\" keyword in all the links on search result page$")
	public void i_should_see_keyword_in_all_the_links_on_search_result_page(String arg1) throws Throwable {
		searchResultPage = new SearchResultPage(driver);
		searchResultPage.elementsList(driver);
	}

	@After()
	public void closeBrowser(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
				// Code to capture images if scenario fails
				Utility.takeScreenshotAtEndOfTest("Failed_" + scenario.getId() + "_");
		}
		else{
		Utility.takeScreenshotAtEndOfTest("Scenario_" + scenario.getId() + "_");
		}
		driver.quit();

	}
	
}