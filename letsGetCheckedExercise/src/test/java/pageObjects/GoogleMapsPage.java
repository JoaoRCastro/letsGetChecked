package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleMapsPage {
    private final WebDriver driver;

    public GoogleMapsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement searchInput() {
        return this.driver.findElement(By.id("searchboxinput"));
    }

    public WebElement firstSuggestion() {
        return this.driver.findElements(By.className("sbsb_c")).get(0);
    }

    public WebElement leftHeadLine() {
        return this.driver.findElement(By.cssSelector("h1 > span:nth-child(1)"));
    }

    public WebElement directionBtn() {
        return this.driver.findElements(By.cssSelector("button[aria-label][data-value]")).get(0);
    }

    public WebElement directionInput() {
        return this.driver.findElement(By.cssSelector("div#directions-searchbox-1 input"));
    }
}
