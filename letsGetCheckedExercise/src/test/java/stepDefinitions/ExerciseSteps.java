package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.GoogleConsentPage;
import pageObjects.GoogleMapsPage;

public class ExerciseSteps {
    private WebDriver driver;
    private GoogleConsentPage googleConsentPage;
    private GoogleMapsPage googleMapsPage;

    @Given("I open Google Chrome")
    public void openGoogleChrome() {
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        this.driver = new ChromeDriver();

        this.googleConsentPage = new GoogleConsentPage(this.driver);
        this.googleMapsPage = new GoogleMapsPage(this.driver);
    }

    @When("I visit \"([^\"]*)\"")
    public void visitGoogleMaps(String website) {
        this.driver.get(website);

        this.googleConsentPage.acceptBtn().click();
    }

    @Then("The page \"([^\"]*)\" must be the current page")
    public void validateCurrentPage(String website) {
        Assert.assertTrue(this.driver.getCurrentUrl().contains(website));
    }

    @Given("Type \"([^\"]*)\" in the search element")
    public void typeCityInSearch(String city) {
        this.googleMapsPage.searchInput().sendKeys(city);
    }

    @And("Select the first element in the suggestions")
    public void selectFirstSuggestion() {
        this.googleMapsPage.firstSuggestion().click();
    }

    @Then("The left panel headline text must be \"([^\"]*)\"")
    public void validateHeadlineText(String city) {
        assert this.googleMapsPage.leftHeadLine().getText().equals(city);
    }

    @Given("Click the directions icon")
    public void clickDirectionsIcon() {
        this.googleMapsPage.directionBtn().click();
    }

    @Then("Destination must be \"([^\"]*)\"")
    public void validateDestination(String city) {
        assert this.googleMapsPage.directionInput().getText().equals(city);
    }

    @And("I close browser")
    public void closeBrowser() {
        driver.quit();
    }
}