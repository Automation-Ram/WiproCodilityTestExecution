package com.codilitytestcases.arrpage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ARRTestCases {

	static WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		driver = new ChromeDriver();
		driver.get(
				"https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_search/6f03f4361b080eeb747193aadd94cd2b/static/attachments/reference_page.html");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void testQueryInputAndSubmitButtonPresenceTestCase1() {

		WebElement queryInput = driver.findElement(By.id("search-input"));
		boolean queryInputIsPresent = queryInput.isDisplayed();
		System.out.println(queryInputIsPresent);
		if (queryInputIsPresent) {
			System.out.println("The query input is present on the page.");
		} else {
			System.out.println("The query input is not present on the page.");
		}

		WebElement submitButton = driver.findElement(By.id("search-button"));
		boolean submitButtonIsPresent = submitButton.isDisplayed();
		System.out.println(submitButtonIsPresent);
		if (queryInputIsPresent) {
			System.out.println("The submit button is present on the page.");
		} else {
			System.out.println("The submit button is not present on the page.");
		}

	}

	@Test
	public void testSearchWithEmptyQueryTestCase2() {

		WebElement queryInput = driver.findElement(By.id("search-input"));
		queryInput.clear();
		WebElement submitButton = driver.findElement(By.id("search-button"));
		submitButton.click();
		WebElement errorMessage = driver.findElement(By.id("error-empty-query"));
		String forbiddenErrorMessage = errorMessage.getText();
		Assert.assertEquals(forbiddenErrorMessage, "Provide some query");

	}

	@Test

	public void testSearchReturnsAtLeastOneIslandTestCase3() {

		WebElement queryInput = driver.findElement(By.id("search-input"));
		queryInput.sendKeys("isla");
		WebElement submitButton = driver.findElement(By.id("search-button"));
		submitButton.click();
		List<WebElement> listOfIslandData = driver.findElements(By.xpath("//ul[@id='search-results']//li"));
		for (WebElement data : listOfIslandData) {
			System.out.println(data.getText());
		}
	}

	@Test

	public void testNoResultsFeedbackTestCase4() {
		WebElement queryInput = driver.findElement(By.id("search-input"));
		queryInput.sendKeys("castle");
		WebElement submitButton = driver.findElement(By.id("search-button"));
		submitButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement noResultsMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-no-results")));
		String noResultMessage = noResultsMessage.getText();
		Assert.assertEquals(noResultMessage, "No results");
	}

	@Test
	public void testSearchReturnsCorrectResultForPortTestCase5() {

		WebElement queryInput = driver.findElement(By.id("search-input"));
		queryInput.sendKeys("port");
		WebElement submitButton = driver.findElement(By.id("search-button"));
		submitButton.click();
		WebElement portElement = driver.findElement(By.xpath("//ul[@id='search-results']//li[text()='Port Royal']"));
		String portData = portElement.getText();
		System.out.println(portData);
		Assert.assertEquals(portData, "Port Royal");

	}

	@AfterMethod
	public void tearDown()

	{
		driver.close();
	}
}
