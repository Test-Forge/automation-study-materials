package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends PageFactory {
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By productTitle = By.cssSelector(".inventory_item_name");

    @FindBy(className = "inventory_item")
    private List<WebElement> products;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartIcon;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductTitleByIndex(int index) {
        return products.get(index).findElement(productTitle).getText();
    }

    public void clickAddToCartByIndex(int index) {
        products.get(index).findElement(addToCartButton).click();
    }

    public void clickOnShoppingCartIcon() {
        shoppingCartIcon.click();
    }
}
