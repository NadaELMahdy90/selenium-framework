package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductPage;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckOutTest extends TestBase{

    CheckOutPage checkOutPage;
    LoginTest loginTest;
    CartPage cartPage;
    LoginPage loginPage;

//    @Test
//    public void checkOutWithoutProducts(){
//        checkOutPage = new CheckOutPage(driver);
//        cartPage = new CartPage(driver);
//        cartPage.checkTheCart();
//        checkOutPage.checkOutWithoutProducts();
//        assertTrue(checkOutPage.errorMessage.isDisplayed());
//    }
    @BeforeClass
    public void initJsonReader()  {
        dataReader = new JsonDataReader();
    }

    @BeforeMethod
    public void login() throws IOException, ParseException {
        loginPage = new LoginPage(driver);
        dataReader.JsonReader("login");
        loginPage.login(dataReader.map.get("userName"),dataReader.map.get("password"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void verifyInvalidCheckOutInfo() throws IOException, ParseException {
        checkOutPage = new CheckOutPage(driver);
        cartPage = new CartPage(driver);
        cartPage.checkTheCart();
        checkOutPage.checkOutWithoutProducts();
        checkOutPage.continueCheckOut();
        assertTrue(checkOutPage.invalidCheckoutDataErrorMsg.isDisplayed());
        loginPage.logout();
    }

    @Test
    public void verifyValidCheckOut() throws IOException, ParseException {
        checkOutPage = new CheckOutPage(driver);
        cartPage = new CartPage(driver);
        cartPage.checkTheCart();
        checkOutPage.checkOutWithoutProducts();
        checkOutPage.addCheckOutData("test","test","123");
        assertTrue(checkOutPage.paymentInfoLabel.isDisplayed());
    }
}
