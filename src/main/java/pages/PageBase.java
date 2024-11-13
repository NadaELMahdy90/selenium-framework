package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    protected static void clickButton(WebElement webElement){
        webElement.click();
    }

    protected static void addTextToElements(WebElement webElement,String value){
        webElement.sendKeys(value);
    }

    protected static boolean elementDisplayed(WebElement webElement){
        return webElement.isDisplayed();
    }

}
