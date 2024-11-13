package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    WebElement checkOutBtn;

    @FindBy(className = "h3")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")
    public WebElement invalidCheckoutDataErrorMsg;

    @FindBy(id = "continue")
    public WebElement continueBtn;

    @FindBy(id = "first-name")
    public WebElement firstNameTxtBox;

    @FindBy(id = "last-name")
    public WebElement secNameTxtBox;

    @FindBy(id = "postal-code")
    public WebElement zipCodeTxtBox;

    @FindBy(className = "summary_info_label")
    public WebElement paymentInfoLabel;

    public void checkOutWithoutProducts(){
        clickButton(checkOutBtn);
    }

    public void continueCheckOut(){
        clickButton(continueBtn);
    }

    public void addCheckOutData(String firstName,String secName,String zipCode){
        addTextToElements(firstNameTxtBox,firstName);
        addTextToElements(secNameTxtBox,secName);
        addTextToElements(zipCodeTxtBox,zipCode);
        clickButton(continueBtn);
    }
}
