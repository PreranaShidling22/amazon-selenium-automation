package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AmazonPage {

    WebDriver driver;
    WebDriverWait wait;

    public AmazonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    By searchBox = By.id("twotabsearchtextbox");
    By searchButton = By.id("nav-search-submit-button");
    By searchResults = By.cssSelector("div[data-component-type='s-search-result']");
    By addToCartButton = By.xpath("//span[@id='nav-cart-count']");

    public void openHomePage() {
        driver.get("https://www.amazon.in");
    }

    public void searchProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox))
                .sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void clickFirstSearchResult() {
        List<WebElement> results = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(searchResults)
        );
        results.get(0).click();
    }

    public boolean isProductPageLoaded() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(addToCartButton)
        ).isDisplayed();
    }
}
