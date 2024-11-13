package tests;

import data.JsonDataReader;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPage;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ProductTest extends TestBase{

    ProductPage productPage;
    boolean isElementsDisplayed;
    LoginPage loginPage;
    LoginTest loginTest;

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
    }

    @Test(priority =1)
    public void verifyAllProductsDisplayedCorrectly() throws IOException, ParseException {
        productPage = new ProductPage(driver);
        isElementsDisplayed = productPage.elementsDisplayed();
        assertTrue(isElementsDisplayed);
    }

    @Test(priority =2)
    public void verifyFilterFromZToA(){
        productPage = new ProductPage(driver);
        productPage.filterProductsFromZtoA();
        Assert.assertEquals(productPage.productNameTxt.getText(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test(priority =3)
    public void verifyFilterFromAToZ(){
        productPage = new ProductPage(driver);
        productPage.filterProductsFromAtoZ();
        Assert.assertEquals(productPage.productNameTxt.getText(), "Sauce Labs Backpack");
    }

    @Test(priority =4)
    public void verifyFilterPriceFromHighToLow(){
        productPage = new ProductPage(driver);
        productPage.filterProductsFromHighToLowPrice();
        assertTrue(productPage.productPriceRTxt.getText().contains("49.99") );
    }

    @Test(priority =5)
    public void verifyFilterPriceFromLowToHigh(){
        productPage = new ProductPage(driver);
        productPage.filterProductsFromLowToHighPrice();
        assertTrue(productPage.productPriceRTxt.getText().contains("7.99"));
    }
}
