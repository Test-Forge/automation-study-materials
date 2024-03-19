package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {
    private WebDriver driver;
    private By addedProductTitle = By.cssSelector(".inventory_item_name");

    @FindBy(className = "cart_item")
    private List<WebElement> addedProducts;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getAddedProductTitleByIndex(int index) {
        return addedProducts.get(index).findElement(addedProductTitle).getText();
    }
}
