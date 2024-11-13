package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static org.testng.Assert.*;

public class CartTest extends TestBase{

    CartPage cartPage;
    LoginTest loginTest;
    LoginPage loginPage;
    List<WebElement> webElements = new ArrayList<>();

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

    @Test(priority =1)
    public void verifyAddProductToCart() throws IOException, ParseException {
        cartPage = new CartPage(driver);
        cartPage.AddSingleProductToCart();
        cartPage.checkTheCart();
        Assert.assertEquals(cartPage.cartProductName.getText(), "Sauce Labs Backpack");
        cartPage.removeProduct();
        loginPage.logout();
        System.out.println("verifyAddProductToCart");
    }

    @Test(priority =2)
    public void verifyAddMultipleProductsToCart() throws IOException, ParseException {
        cartPage = new CartPage(driver);
        cartPage.AddSingleProductToCart();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        cartPage.AddMultipleProductsToCart();
        cartPage.checkTheCart();
        Assert.assertEquals(cartPage.carSectProductName.getText(), "Sauce Labs Bolt T-Shirt");
        cartPage.removeProduct();
        cartPage.removeProducts();
        loginPage.logout();
        System.out.println("verifyAddMultipleProductsToCart");
    }

    @Test(priority =3)
    public void removeOneProductFromCart() throws IOException, ParseException {
        cartPage = new CartPage(driver);
        cartPage.AddSingleProductToCart();
        cartPage.AddMultipleProductsToCart();
        cartPage.checkTheCart();
        cartPage.removeProduct();
        webElements = cartPage.allAddedElements;
        assertEquals(webElements.size(), 1);
        cartPage.removeProducts();
        loginPage.logout();
    }

    @Test(priority =4)
    public void removeAllProductsFromCart() throws IOException, ParseException {
        cartPage = new CartPage(driver);
        cartPage.AddSingleProductToCart();
        cartPage.AddMultipleProductsToCart();
        cartPage.checkTheCart();
        cartPage.removeProduct();
        cartPage.removeProducts();
        webElements = cartPage.allRemovedElements;
        assertEquals(webElements.size(), 2);
        loginPage.logout();
    }

}
