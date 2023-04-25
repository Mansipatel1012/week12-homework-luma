package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        mouseHoverAndClick(By.id("ui-id-11"));
        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Product Name ");
        //Verify the products name display in alphabetical order
        // Get the names of all the products
        List<WebElement> productNames = BaseTest.driver.findElements(By.cssSelector(".product-name a"));
        List<String> actualProductNames = new java.util.ArrayList<String>();
        for (WebElement productName : productNames) {
            actualProductNames.add(productName.getText());
        }
        // Verify that the product names are in alphabetical order
        List<String> expectedProductNames = new java.util.ArrayList<String>(actualProductNames);
        java.util.Collections.sort(expectedProductNames);
        Assert.assertEquals(actualProductNames, expectedProductNames);

    }
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on Women Menu
        mouseHoverToElement(By.xpath("//span[normalize-space()='Women']"));
        //Mouse Hover on Tops
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']"));
        //Click on Jackets
        mouseHoverAndClick(By.id("ui-id-11"));
        //Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Price ");
        //Verify the products price display in Low to High
        List<WebElement> productPrice = driver.findElements(By.xpath("//div[@class='price-box price-final_price']/span"));
        List<String> actualProductPrice = new ArrayList<String>();
        for (WebElement productName : productPrice) {
           actualProductPrice.add(productName.getText());
        }
        // Verify that the product names are in alphabetical order
        List<String> expectedProductNames = new ArrayList<String>(actualProductPrice);
        java.util.Collections.sort(expectedProductNames);
        Assert.assertEquals(actualProductPrice, expectedProductNames);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}


