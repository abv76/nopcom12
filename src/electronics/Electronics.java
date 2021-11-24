package electronics;

import homePage.TopMenuTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Electronics extends TopMenuTest {


    @Test

    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() throws InterruptedException {

        //1.1 Mouse Hover on “Electronics” Tab
        Thread.sleep(1000);
        mouseHover(By.linkText("Electronics"));
        Thread.sleep(1000);

        //  1.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));
        Thread.sleep(2000);

        //1.3 Verify the text “Cell phones”
        String expectedText = "Cell phones";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("User not  Navigated to Cell Phone tab page ", expectedText, actualText);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics” Tab TO 2.4
        this.verifyUserShouldNavigateToCellPhonesPageSuccessfully();

        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[contains(text(),'Nokia Lumia 1020')]"));

        //2.6Verify the text “Nokia Lumia 1020”
        Thread.sleep(1000);
        String expectedText1 = "Nokia Lumia 1020";
        Thread.sleep(2000);
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"));
        Assert.assertEquals("User not  Navigated to Cell Phone tab page ", expectedText1, actualText1);

        //2.7Verify the price “$349.00”
        Thread.sleep(1000);
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[contains(text(),'$349.00')]"));
        Assert.assertEquals("Price is not verified ", expectedPrice, actualPrice);

        //2.8 Change quantity to 2
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='product_enteredQuantity_20'and @name='addtocart_20.EnteredQuantity']"));
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20'and @name='addtocart_20.EnteredQuantity']"), "2");

        //2.9 Click on “ADD TO CART” tab
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20' and @class='button-1 add-to-cart-button']"));

        ////body/div[@id='bar-notification']/div[1]/p[1]

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        Thread.sleep(1000);
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = getTextFromElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"));
        Assert.assertEquals("User not sucessfully purchases the product ", expectedMessage, actualMessage);
        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        Thread.sleep(1000);
        String expectedMessageCart = "Shopping cart";
        String actualMessageCart = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("User not successfully navigate to Shopping cart page", expectedMessageCart, actualMessageCart);

        //2.13 Verify the quantity is 2

        Thread.sleep(2000);
        String expectedquantity="2";
        String actualquantity = getAttributefromelement(By.xpath("//tbody/tr[1]/td[5]/input[1]"),"value");
        Assert.assertEquals("not purchased",expectedquantity,actualquantity);



        //2.14 Verify the Total $698.00

        Thread.sleep(2000);
        String expectedPrice1 = "$698.00";
        String actualPrice1 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]"));
        Assert.assertEquals("Total not verified", expectedPrice1, actualPrice1);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”

        String expectedWelcomeMessage = "Welcome, Please Sign In!";
        Thread.sleep(2000);
        String actualwelcomeMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Welcome message not displayed", expectedWelcomeMessage, actualwelcomeMessage);

        //2.18 2.18 Click on “REGISTER” tab

        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));
        //2.19 Verify the text “Register”


        String expectedverificationMessage = "Register";
        Thread.sleep(2000);
        String actualVerificationMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Register')]"));
        Assert.assertEquals(" User not registered successfully", expectedverificationMessage, actualVerificationMessage);

        //2.20 Fill the mandatory fields
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Samira");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Dave");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Email']"), "Samira.dave" +randomInt+ "@gmail.com");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='Password']"), "abc9876");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "abc9876");

        //2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        String expectedregistrationMessage = "Your registration completed";
        Thread.sleep(2000);
        String actualregistrationMessage = getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals("Registered successfully", expectedregistrationMessage, actualregistrationMessage);

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


        // 2.24 Verify the text “Shopping card”
        String expectecartdMessage = "Shopping cart";
        Thread.sleep(1000);
        String actualcartMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Not navigated to shopping cart page", expectecartdMessage, actualcartMessage);
        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='BillingNewAddress_FirstName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "John");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='BillingNewAddress_LastName']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"), "Dave");
        Thread.sleep(1000);
        clear(By.xpath("//input[@id='BillingNewAddress_Email']"));
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"), "john.dave" + randomInt + "@gmail.com");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "233");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.Address1']"), "Flat 2,632 Kingsbury road");
        Thread.sleep(1000);
        sendTextToElement(By.xpath(" //input[@id='BillingNewAddress_ZipPostalCode']"), "NW9 9HN");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "07722405000");
        Thread.sleep(1000);
        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));
        Thread.sleep(1000);
        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//input[@id='shippingoption_2' and @name='shippingoption']"));
        //2.30 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.31 Select Radio Button “Credit Card”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
        // 2.32 Select “Visa” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"), 0);
        //2.33 Fill all the details

        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mr. John Dave");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "4556388272906495");
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "9");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "512");

        //2.34 Click on “CONTINUE”

        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.35 Verify “Payment Method” is “Credit Card”
        Thread.sleep(1000);
        String expectedpaymentMessage = "Credit Card";
        Thread.sleep(2000);

        String actualpaymentMessage = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment method is not verified", expectedpaymentMessage, actualpaymentMessage);

        //2.36 Verify “Shipping Method” is “2nd Day Air”

        Thread.sleep(1000);
        String expectedshippingMessage = "2nd Day Air";
        Thread.sleep(2000);

        String actualshippingMessage = getTextFromElement(By.xpath("//span[contains(text(),'2nd Day Air') and @class='value']"));
        Assert.assertEquals("Shipping method is not correct", expectedshippingMessage, actualshippingMessage);

        //2.37 Verify Total is “$698.00”
        Thread.sleep(1000);
        String expectedtotalMessage = "$698.00";
        Thread.sleep(1000);
        String actualtotalMessage = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Total amount is not verified", expectedtotalMessage, actualtotalMessage);
        System.out.println("pass Total4");
        Thread.sleep(1000);
        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.39 Verify the Text “Thank You”

        String expectedMessage9 = "Thank you";
        Thread.sleep(2000);
        String actualMessage9 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Total amount is not verified", expectedMessage9, actualMessage9);
        System.out.println("pass Total5");

        //2.40 Verify the message “Your order has been successfully processed!”

        String expectedMessage10 = "Your order has been successfully processed!";
        Thread.sleep(2000);
        String actualMessage10 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Order not placed successfully", expectedMessage10, actualMessage10);
        System.out.println("pass Total6");
        Thread.sleep(1000);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        String expectedMessage11 = "Welcome to our store";
        Thread.sleep(2000);
        String actualMessage11 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Successfully Not purchased product", expectedMessage11, actualMessage11);

        //2.43 Click on “Logout” link
        Thread.sleep(1000);
        clickOnElement(By.linkText("Log out"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”

        String expectedUrl="https://demo.nopcommerce.com/";
            Thread.sleep(1000);
        String actualUrl = getUrl();
        Assert.assertEquals("Url is NotMatch",expectedUrl,actualUrl);



    }


}



