package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class ExerciseSteps {
    WebDriver driver;

    @Given("I open Google Chrome")
    public void openGoogleChrome() {
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @When("I visit \"([^\"]*)\"")
    public void visitGoogleMaps(String website) {
        driver.get(website);

        WebElement consentAcceptBtn = driver.findElement(By.cssSelector("button[aria-label]"));
        consentAcceptBtn.click();
    }

    @Then("The page \"([^\"]*)\" must be the current page")
    public void validateCurrentPage(String website) {
        Assert.assertTrue(driver.getCurrentUrl().contains(website));
    }

    @Given("Type \"([^\"]*)\" in the search element")
    public void typeCityInSearch(String city) {
        WebElement searchInput = driver.findElement(By.id("searchboxinput"));

        searchInput.sendKeys(city);
    }

    @And("Select the first element in the suggestions")
    public void selectFirstSuggestion() {
        List<WebElement> suggestions = driver.findElements(By.className("sbsb_c"));

        suggestions.get(0).click();
    }

    @Then("The left panel headline text must be \"([^\"]*)\"")
    public void validateHeadlineText(String city) {
        WebElement leftHeadline = driver.findElement(By.cssSelector("h1 > span:nth-child(1)"));

        assert leftHeadline.getText().equals(city);
    }

    @Given("Click the directions icon")
    public void clickDirectionsIcon() {
        List<WebElement> actionBtns = driver.findElements(By.cssSelector("button[aria-label][data-value]"));
        WebElement directionBtn = actionBtns.get(0);

        directionBtn.click();
    }

    @Then("Destination must be \"([^\"]*)\"")
    public void validateDestination(String city) {
        WebElement directionInput = driver.findElement(By.cssSelector("div#directions-searchbox-1 input"));

        assert directionInput.getText().equals(city);
    }

    @And("I close browser")
    public void closeBrowser() {
        driver.quit();
    }
}