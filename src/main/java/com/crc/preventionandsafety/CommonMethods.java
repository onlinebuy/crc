package com.crc.preventionandsafety;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.StringJoiner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {
	public WebDriver browser;
	public WebDriverWait wait;
	public Logger log;
	
	public String searchTerm;
	
	public CommonMethods() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/WebDrivers/chromedriver.exe");
		browser = new ChromeDriver();
		wait = new WebDriverWait(this.browser, 5);
		log = new Logger("src/test/resources/logs/" + new SimpleDateFormat("yyyyMMdd HHmmss ").format(Calendar.getInstance().getTime()) + "TestLog.txt");
	}
	
	public void launchBrowser() throws IOException {
		browser.navigate().to("https://ps-uat.redcross-croixrouge.ca/en/");
		log.logToFile("Chrome Browser Launched");
	}
	
	public static void main(String[] args) {
		CommonMethods comm = new CommonMethods();
		try {
			comm.launchBrowser();
			Thread.sleep(5000);
			comm.closeBrowser();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*public void googleSearchForTerm() throws IOException {
		WebElement searchInput = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@title, 'Search')]")));
		searchInput.sendKeys(searchTerm);
		searchInput.sendKeys(Keys.ENTER);
		log.logToFile("Google Search for term " + searchTerm);
	}
	
	public List<WebElement> getSearchResults() {
		WebElement searchResults = this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@data-async-context, 'query:" + searchTerm + "')]")));
		return searchResults.findElements(By.xpath("//div[contains(@class, 'f kv _SWb')]/cite"));
	}
	
	public Boolean isExpectedValueInResults(String expectedValue) throws IOException {
		Boolean result = false; 
		StringJoiner positions = new StringJoiner(", ");
		
		Integer i = 1;
		for(WebElement eachResult : getSearchResults()) {
			if (eachResult.getText().contains(expectedValue)) {
				result = true;
				positions.add(i.toString());
			}
			i++;
		}
		
		if (result)
			log.logToFile("Google Search returned the expected value of " + expectedValue + " on the first page at position(s) " + positions.toString());
		else 
			log.logToFile("Google Search did not return the expected value of " + expectedValue + " on the first page");
		return result;
	}*/
	
	public void closeBrowser() {
		this.browser.close();
		try {
			log.logToFile("Chrome Browser Closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
