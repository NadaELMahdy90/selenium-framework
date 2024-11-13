package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class CartPage extends PageBase{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBtn;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addToCartSecondBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    public WebElement removeFirstProductBtn;

    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    public WebElement removeSecProductBtn;

    @FindBy(className = "shopping_cart_link")
    public WebElement cartIcon;

    @FindBy(className = "inventory_item_name")
    public WebElement cartProductName;

    @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
    public WebElement carSectProductName;

    @FindBys(@FindBy(className="cart_item"))
    public List<WebElement> allAddedElements;

    @FindBys(@FindBy(className="removed_cart_item"))
    public List<WebElement> allRemovedElements;

    public void AddSingleProductToCart(){
        clickButton(addToCartBtn);
    }

    public void AddMultipleProductsToCart(){
        clickButton(addToCartSecondBtn);
    }

    public void removeProduct(){
        clickButton(removeFirstProductBtn);
    }

    public void removeProducts(){
        clickButton(removeSecProductBtn);
    }

    public void checkTheCart(){
        clickButton(cartIcon);
    }
}
