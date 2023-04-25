package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        Thread.sleep(2000);
        //Mouse Hover on Gear Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Gear')]"));
        //Click on Bags
        mouseHoverAndClick(By.xpath("//span[contains(text(),'Bags')]"));
        //Click on Product Name ‘Overnight Duffle’
        clikOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));
        //Verify the text ‘Overnight Duffle’
        verifyText("Overnight Duffle", By.xpath("//span[contains(text(),'Overnight Duffle')]"), "Overnight Duffle");
        //change qty 3
        clearTextFromField(By.xpath("//input[@id='qty']"));
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");
        //Click on ‘Add to Cart’ Button.
        clikOnElement(By.xpath("//button[@id='product-addtocart-button']"));
        //Verify the text ‘You added Overnight Duffle to your shopping cart.’
        verifyText("You added Overnight Duffle to your shopping cart.", By.xpath("//div[@role='alert']/div/div"), "Message");
        Thread.sleep(2000);
        //Click on ‘shopping cart’ Link into message
        clikOnElement(By.xpath("//div[@role='alert']/div/div/a"));
        // Verify the product name Overnight Duffle
        verifyText("Overnight Duffle", By.cssSelector("td[class='col item'] div[class='product-item-details'] a"),"Overnight Duffle");
        Thread.sleep(2000);
        //Verify the Qty is ‘3’
        String expectedTotal = "3";
        String actualTotal = getTextFromElement(By.xpath("//span[@class='counter-number']"));
        Assert.assertEquals(expectedTotal, actualTotal);
        //Verify the product price ‘$135.00’
        verifyText("$135.00", By.xpath("//td[@class='col subtotal']//span[@class='cart-price']"), "$135.00");
        Thread.sleep(2000);
        //Change Qty to ‘5’
        clearTextFromField(By.xpath("//input[@id='cart-103429-qty']"));
        sendTextToElement(By.xpath("//input[@id='cart-103429-qty']"),"5");
        //Click on ‘Update Shopping Cart’ button
        clikOnElement(By.xpath("//span[contains(text(),'Update Shopping Cart')]"));
        //Verify the product price ‘$225.00’
        verifyText("$225.00",By.xpath("//td[@class='col subtotal']//span[@data-label='Excl. Tax']"),"$225");

    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
