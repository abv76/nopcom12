package homePage;

import browserTesting.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TopMenuTest extends BaseTest {

    String baseUrl = "https://demo.nopcommerce.com";

    @Before

    public void setUp() {


        openBrowser(baseUrl);
    }


    public void selectMenu(String menu) throws InterruptedException {

        clickOnElement(By.linkText("Computers"));
        Thread.sleep(1000);
       clickOnElement(By.linkText("Electronics"));
       Thread.sleep(1000);
       clickOnElement(By.linkText("Apparel"));
        Thread.sleep(1000);
        clickOnElement(By.linkText("Digital downloads"));
       Thread.sleep(1000);

        clickOnElement(By.linkText("Books"));
        Thread.sleep(1000);
       clickOnElement(By.linkText("Jewelry"));
        Thread.sleep(1000);
        clickOnElement(By.linkText("Gift Cards"));


    }


    @Test
    public void verifyPageNavigationSuccessfully() throws InterruptedException {

        selectMenu("Computers");
        String expectedMessage = "Computers";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.partialLinkText("Compute"));
        Assert.assertEquals("User not redirected to page", expectedMessage, actualMessage);
    }

    @Test

    public void verifyElectronicsPageNavigation() throws InterruptedException {

        selectMenu("Electronics");
        String expectedMessage1 = "Electronics";
        Thread.sleep(1000);
        String actualMessage1 = getTextFromElement(By.partialLinkText("Electroni"));
        assertEquals("User not redirected to page", expectedMessage1, actualMessage1);
    }


    @Test
    public void verifyApparelPageNavigation() throws InterruptedException {

        selectMenu("Apparel");
        String expectedMessage2 = "Apparel";
        Thread.sleep(1000);
        String actualMessage2 = getTextFromElement(By.partialLinkText("Appar"));
        assertEquals("User not redirected to page", expectedMessage2, actualMessage2);
    }


    @Test

    public void verifyDigitalDownloadslPageNavigation() throws InterruptedException {

        selectMenu("Digital downloads");
        String expectedMessage3 = "Digital downloads";
        Thread.sleep(1000);
        String actualMessage3 = getTextFromElement(By.partialLinkText("Digital downloa"));
        assertEquals("User not redirected to page", expectedMessage3, actualMessage3);
    }

    @Test
    public void verifyBooksPageNavigation() throws InterruptedException {

        selectMenu("Books");
        String expectedMessage4 = "Books";
        Thread.sleep(1000);
        String actualMessage4 = getTextFromElement(By.partialLinkText("Books"));
        assertEquals("User not redirected to page", expectedMessage4, actualMessage4);
    }

    @Test
    public void verifyJewelryPageNavigation() throws InterruptedException {
        selectMenu("Jewelry");
        String expectedMessage5 = "Jewelry";
        Thread.sleep(1000);
        String actualMessage5 = getTextFromElement(By.partialLinkText("Jewel"));
        assertEquals("User not redirected to page", expectedMessage5, actualMessage5);
    }

    @Test
    public void verifyGiftCardsPageNavigation() throws InterruptedException {


        selectMenu("Gift Cards");
        String expectedMessage6 = "Gift Cards";
        Thread.sleep(1000);
        String actualMessage6 = getTextFromElement(By.partialLinkText("Gift Car"));
        assertEquals("User not redirected to page", expectedMessage6, actualMessage6);


    }


   // @After
   // public void tearDown() {
       // closeBrowser();
    //}
}



