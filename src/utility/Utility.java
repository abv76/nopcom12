package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class Utility {


    public WebDriver driver;


    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();


    }


    // public int getIntFromElement(By by){
    // return driver.findElement(by).
    // }

    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);

    }

    public void selectByValueFromDropDown(By by, String value) {

        Select select = new Select(driver.findElement(by));
        select.selectByValue(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String value) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(value);
    }

    public void selectByIndexFromDropDown(By by, int value) {
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(value);

    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(by);
        actions.moveToElement(target).build().perform();

    }

    public void clear(By by) {
        driver.findElement(by).clear();

    }

   public Random randomGenerator = new Random();
   public int randomInt = randomGenerator.nextInt(1000);

    public String getUrl() {
        String actualUrl = driver.getCurrentUrl();
        return actualUrl;
    }

    public <BY, attribute> String getAttributefromelement(By by, String value){
        return driver.findElement(by).getAttribute("value");

}
}