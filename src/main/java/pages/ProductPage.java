package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends PageBase{

    Select objSelect;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_list")
    WebElement productsGrid;

    @FindBy(className = "inventory_item_name")
    public WebElement productNameTxt;

    @FindBy(className = "inventory_item_price")
    public WebElement productPriceRTxt;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addToCartBtn;

    @FindBy(className = "product_sort_container")
    WebElement filterDDL;

    public boolean elementsDisplayed(){
        return(elementDisplayed(productsGrid)&&elementDisplayed(productNameTxt)&&
                elementDisplayed(productPriceRTxt)&&elementDisplayed(addToCartBtn));

    }

    public void filterProductsFromZtoA(){
        objSelect = new Select(filterDDL);
        objSelect.selectByVisibleText("Name (Z to A)");
    }

    public void filterProductsFromAtoZ(){
        objSelect = new Select(filterDDL);
        objSelect.selectByVisibleText("Name (A to Z)");
    }

    public void filterProductsFromHighToLowPrice(){
        objSelect = new Select(filterDDL);
        objSelect.selectByVisibleText("Price (high to low)");
    }

    public void filterProductsFromLowToHighPrice(){
        objSelect = new Select(filterDDL);
        objSelect.selectByVisibleText("Price (low to high)");
    }
}
