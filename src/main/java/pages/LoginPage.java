package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    WebElement userNameTxtBox;

    @FindBy(id = "password")
    WebElement passwordTxtBox;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(css = "h3")
    public WebElement errorMsg;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement optionsIcon;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutBtn;

    public void login(String userName,String password){
        addTextToElements(userNameTxtBox,userName);
        addTextToElements(passwordTxtBox,password);
        clickButton(loginBtn);
    }

    public void logout(){
        clickButton(optionsIcon);
        clickButton(logoutBtn);
    }


}
