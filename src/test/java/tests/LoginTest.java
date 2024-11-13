package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.io.IOException;
import java.time.Duration;

public class LoginTest extends TestBase{


    LoginPage loginPage;

    @BeforeClass
    public void initJsonReader()  {
        dataReader = new JsonDataReader();
    }

    @Test
    public void login() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("login");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        loginPage.logout();
    }

    @Test(priority =1)
    public void loginWithStandardUserAndValidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithStandardUserAndValidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        loginPage.logout();
    }

    @Test(priority =2)
    public void loginWithStandardUserAndInvalidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithStandardUserAndInvalidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(loginPage.errorMsg.getText(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test(priority =3)
    public void loginWithInvalidStandardUserAndValidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithInvalidStandardUserAndValidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(loginPage.errorMsg.getText(),"Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();
    }

    @Test(priority =4)
    public void loginWithProblemUserAndValidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithProblemUserAndValidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        loginPage.logout();
    }

    @Test(priority =5)
    public void loginWithPerformanceUserAndValidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithPerformanceUserAndValidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        loginPage.logout();
    }

    @Test(priority =6)
    public void loginWithVisualUserAndValidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithVisualUserAndValidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        loginPage.logout();
    }

    @Test(priority =7)
    public void loginWithLockedUserAndValidPass() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("loginWithLockedUserAndValidPass");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(loginPage.errorMsg.getText(),"Epic sadface: Sorry, this user has been locked out.");
        driver.navigate().refresh();
    }

    @Test(priority =8)
    public void verifyLogOut() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("verifyLogOut");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        loginPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
    }
}
