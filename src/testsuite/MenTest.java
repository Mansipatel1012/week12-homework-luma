package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart() throws InterruptedException {
        Thread.sleep(2000);
        // Mouse Hover on men Menu
        mouseHoverToElement(By.xpath("//span[contains(text(),'Men')]"));
        //Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']/span[2]"));
        //Click on pants
        mouseHoverAndClick(By.xpath("//a[@id='ui-id-23']/span"));
        //Mouse Hover on product name ‘Cronus Yoga Pant’.
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        //size 32
        mouseHoverAndClick(By.id("option-label-size-143-item-175"));
        // black colour
        mouseHoverToElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        mouseHoverAndClick(By.id("option-label-color-93-item-49"));
        Thread.sleep(2000);
        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        mouseHoverAndClick(By.xpath("//div[@class='actions-primary']/form//button/span"));
        //Verify the text‘You added Cronus Yoga Pant to your shopping cart.’
        verifyText("You added Cronus Yoga Pant to your shopping cart.", By.xpath("//div[@role='alert']/div/div"), "You added Cronus Yoga Pant to your shopping cart.");
        Thread.sleep(2000);
        //Click on ‘shopping cart’ Link into message
        mouseHoverAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        //Verify the text ‘Shopping Cart.’
        verifyText("Shopping Cart", By.xpath("//span[@class='base']"), "shopping cart");
        //Verify the product name ‘Cronus Yoga Pant’
        verifyText("Cronus Yoga Pant", By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"), "Cronus Yoga Pant");
        //Verify the product size 32
        verifyText("32", By.xpath("//dd[contains(text(),'32')]"), "size");
        //Verify the product colour ‘Black’
        verifyText("Black", By.xpath("//dd[contains(text(),'Black')]"), "colour");
    }


    @After
    public void tearDown() {
        closeBrowser();
    }

}