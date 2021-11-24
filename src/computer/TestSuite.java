package computer;

import homePage.TopMenuTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class TestSuite extends TopMenuTest {

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //1.1 Click on Computer Menu.
        clickOnElement(By.linkText("Computers"));
        Thread.sleep(2000);
        //1.2 Click on Desktop
        clickOnElement(By.linkText("Desktops"));

        //1.3 Select Sort By position "Name: Z to A"
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 2);
        //1.4 Verify the Product will arrange in Descending order.

        String expectedMessage = "Name: Z to A";
        Thread.sleep(3000);
        String actualMessage = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));

        Assert.assertEquals("Not arranged in Z to A order", expectedMessage, actualMessage);
        System.out.println("pass");

    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu

        clickOnElement(By.linkText("Computers"));
        Thread.sleep(1000);

        //2.2 Click on Desktop

        clickOnElement(By.linkText("Desktops"));
        //2.3   Select Sort By position "Name: A to Z"
        selectByIndexFromDropDown(By.xpath("//select[@id='products-orderby']"), 1);
        //2.4 Click on"Add to cart
        Thread.sleep(2000);
        clickOnElement(By.xpath("//div[@class='item-box'][1]//button[text()='Add to cart']"));
        //2.5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
        Thread.sleep(1000);
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Build your own computer')]"));

        Assert.assertEquals("User not redirected to page", expectedMessage, actualMessage);

        //2.6Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_1']"), 1);

        //2.7.Select "8GB [+$60.00]" using Select class.
        selectByIndexFromDropDown(By.xpath("//select[@id='product_attribute_2']"), 3);
        //2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//dd[@id='product_attribute_input_3']//label[text()='400 GB [+$100.00]']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_4_9']"));
        //	2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(500);
        clickOnElement(By.xpath("//input[@id='product_attribute_5_10']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//input[@name='product_attribute_5' and @id='product_attribute_5_12']"));

        //2.11 2.11 Verify the price "$1,475.00"
        String expectedMessage1 = "$1,475.00";
        Thread.sleep(1000);
        String actualMessage1 = getTextFromElement(By.xpath("//span[@class='price-value-1' and @id='price-value-1']"));

        Assert.assertEquals("Not Correct amount", expectedMessage1, actualMessage1);
        //2.12 Click on "ADD TO CARD" Button.

        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1' or @class='button-1 add-to-cart-button']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar After that close the bar clicking on the cross button.

        String expectedMessage2 = "The product has been added to your shopping cart";
        Thread.sleep(1000);
        String actualMessage2 = getTextFromElement(By.xpath("//p[text()='The product has been added to your ']"));

        Assert.assertEquals("Product is not added to the shooping Cart", expectedMessage2, actualMessage2);
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        String expectedMessage3 = "Shopping cart";
        Thread.sleep(1000);
        String actualMessage3 = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("Not navigated to shopping cart page", expectedMessage3, actualMessage3);

        // 2.16 Change the Qty to "2" and Click on "Update shopping cart"

        Thread.sleep(1000);
        clear(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"), "2");
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[contains(text(),'Update shopping cart')]"));

        //2.17 Verify the Total""$2,950.00"

        String expectedMessage4 = "$2,950.00";
        Thread.sleep(1000);
        String actualMessage4 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Total amount is not verified", expectedMessage4, actualMessage4);
        System.out.println("pass Total");

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.id("checkout"));

        //2.20 Verify the Text “Welcome, Please Sign In!”

        String expectedMessage5 = "Welcome, Please Sign In!";
        Thread.sleep(2000);
        String actualMessage5 = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals("Total amount is not verified", expectedMessage5, actualMessage5);

        //2.21Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"John");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Dave");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"john.dave12@gmail.com");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"),"233");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"London");
        Thread.sleep(2000);
        sendTextToElement(By.xpath("//input[@name='BillingNewAddress.Address1']"),"Flat 2,632 Kingsbury road");
        Thread.sleep(1000);
        sendTextToElement(By.xpath(" //input[@id='BillingNewAddress_ZipPostalCode']"),"NW9 9HN");
        Thread.sleep(500);
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07722405000");
        Thread.sleep(1000);
        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 new-address-next-step-button']"));
        Thread.sleep(1000);
        //2.24 Click on Radio Button “Next Day Air($0.00)”

        clickOnElement(By.xpath("//label[contains(text(),'Next Day Air ($0.00)')]"));
        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));
        //2.27 Select “Master card” From Select credit card dropdown
        selectByIndexFromDropDown(By.xpath("//select[@id='CreditCardType']"),1);
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Mr. John Dave");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5414043294528749");
        Thread.sleep(3000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireMonth']"),"12");
        Thread.sleep(2000);
        selectByValueFromDropDown(By.xpath("//select[@id='ExpireYear']"),"2027");
        sendTextToElement(By.xpath("//input[@id='CardCode']"),"149");
        //2.29 Click on “CONTINUE”

        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        //2.30 Verify “Payment Method” is “Credit Card”
       Thread.sleep(1000);
        String expectedMessage6 = "Credit Card";
        Thread.sleep(2000);

        String actualMessage6 = getTextFromElement(By.xpath("//span[contains(text(),'Credit Card')]"));
        Assert.assertEquals("Payment method is not verified", expectedMessage6, actualMessage6);

        //2.32 Verify “Shipping Method” is “Next Day Air”

        Thread.sleep(3000);
        String expectedMessage7 = "Next Day Air";
        Thread.sleep(3000);

        String actualMessage7 = getTextFromElement(By.xpath("//span[contains(text(),'Next Day Air') and @class='value']"));
        Assert.assertEquals("Delivery method not selected", expectedMessage7, actualMessage7);


        //2.33 Verify Total is “$2,950.00”
        String expectedMessage8 = "$2,950.00";
        Thread.sleep(1000);
        String actualMessage8 = getTextFromElement(By.xpath("//tbody/tr[4]/td[2]/span[1]/strong"));
        Assert.assertEquals("Total amount is not verified", expectedMessage8, actualMessage8);
        System.out.println("pass Total4");

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));
        //2.35 Verify the Text “Thank You”
        String expectedMessage9 ="Thank you";
        Thread.sleep(2000);
        String actualMessage9 = getTextFromElement(By.xpath("//h1[contains(text(),'Thank you')]"));
        Assert.assertEquals("Total amount is not verified", expectedMessage9, actualMessage9);
        System.out.println("pass Total5");

        //2.36 Verify the message “Your order has been successfully processed!”

        String expectedMessage10 ="Your order has been successfully processed!";
        Thread.sleep(2000);
        String actualMessage10 = getTextFromElement(By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"));
        Assert.assertEquals("Order not placed successfully", expectedMessage10, actualMessage10);
        System.out.println("pass Total6");
         Thread.sleep(1000);
        //2.37 Click on “CONTINUE”
       clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

       //2.37 Verify the text “Welcome to our store”
        String expectedMessage11 ="Welcome to our store";
        Thread.sleep(2000);
        String actualMessage11 = getTextFromElement(By.xpath("//h2[contains(text(),'Welcome to our store')]"));
        Assert.assertEquals("Successfully Not purchased product", expectedMessage11, actualMessage11);



    }
}



