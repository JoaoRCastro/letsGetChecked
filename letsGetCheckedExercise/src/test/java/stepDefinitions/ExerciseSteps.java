package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.GoogleConsentPage;
import pageObjects.GoogleMapsPage;

import java.time.Duration;

public class ExerciseSteps {
    private static WebDriver driver;
    private static GoogleConsentPage googleConsentPage;
    private static GoogleMapsPage googleMapsPage;

    @BeforeAll
    public static void beforeAll() {
//        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        googleConsentPage = new GoogleConsentPage(driver);
        googleMapsPage = new GoogleMapsPage(driver);
    }

    @Given("I visit {string}")
    public void visitGoogleMaps(String website) {
        driver.get(website);

        googleConsentPage.acceptBtn().click();
    }

    @Then("The page {string} must be the current page")
    public void validateCurrentPage(String website) {
        Assert.assertTrue(driver.getCurrentUrl().contains(website));
    }

    @Given("Search {string} in the search element")
    public void typeCityInSearch(String city) {
        googleMapsPage.searchInput().sendKeys(city + Keys.RETURN);
    }

    @Then("The left panel headline text must be {string}")
    public void validateHeadlineText(String city) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(googleMapsPage.leftHeadLine(), city));
    }

    @Given("Click the directions icon")
    public void clickDirectionsIcon() {
        googleMapsPage.directionBtn().click();
    }

    @Then("Destination must be {string}")
    public void validateDestination(String city) {
        Assert.assertTrue(googleMapsPage.directionInput().getAttribute("aria-label").contains(city));
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }
}