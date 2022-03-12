package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleConsentPage {
    private final WebDriver driver;

    public GoogleConsentPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement acceptBtn () {
        return this.driver.findElement(By.cssSelector("button[aria-label]"));
    }
}
