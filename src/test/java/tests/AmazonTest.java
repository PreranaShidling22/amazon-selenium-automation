package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AmazonPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AmazonTest {

    WebDriver driver;
    AmazonPage amazon;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        amazon = new AmazonPage(driver);
    }

    @Test
    public void validateAmazonProductWorkflow() throws IOException {

        amazon.openHomePage();
        amazon.searchProduct("laptop");
        amazon.clickFirstSearchResult();

        Assert.assertTrue(
                amazon.isProductPageLoaded(),
                "Product page did not load successfully"
        );

        takeScreenshot("screenshots/product_page.png");
    }

    public void takeScreenshot(String path) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.createDirectories(new File("screenshots").toPath());
        Files.copy(
                src.toPath(),
                new File(path).toPath(),
                StandardCopyOption.REPLACE_EXISTING
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
