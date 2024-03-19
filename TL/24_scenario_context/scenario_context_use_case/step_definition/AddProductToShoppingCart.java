package step_definition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import org.openqa.selenium.WebDriver;
import page_objects.LoginPage;
import page_objects.ProductsPage;
import page_objects.ShoppingCartPage;
import scenario_context.ScenarioContext;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AddProductToShoppingCart {
    ScenarioContext scenarioContext = ScenarioContext.getInstance();
    WebDriver driver = (WebDriver) scenarioContext.getContext(Context.WEB_DRIVER);
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;

    @Given("^user navigates to shopping cart web site \"(.*)\"$")
    public void navigateToShoppingCart(String webAddress) {
        driver.get(webAddress);
    }

    @And("^user logs in with credentials \"(.*)\" and \"(.*)\"$")
    public void logInWithCredentials(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("^user adds product from the list by index (\\d+)$")
    public void addProduct(int index) {
        productsPage = new ProductsPage(driver);
        scenarioContext.setContext(Context.PRODUCT_TITLE, productsPage.getProductTitleByIndex(0));
        productsPage.clickAddToCartByIndex(0);
    }

    @And("^user navigates to Shopping cart page$")
    public void navigateToShoppingCart() {
        productsPage.clickOnShoppingCartIcon();
    }

    @Then("^added product is displayed in the list by index (\\d+)$")
    public void validateTitleForAddedProduct(int index) {
        shoppingCartPage = new ShoppingCartPage(driver);
        String expectedProduct = (String) scenarioContext.getContext(Context.PRODUCT_TITLE);
        String actualProduct = shoppingCartPage.getAddedProductTitleByIndex(0);
        assertEquals("Added product should match with item from Shopping cart", expectedProduct, actualProduct);
    }
}
