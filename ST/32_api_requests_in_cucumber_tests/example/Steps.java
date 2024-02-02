package org.example;

import java.util.List;
import java.util.Map;

import io.restassured.RestAssured;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class Steps extends AbstractSteps {

    private static String token;
    private static Response response;
    private static Response authResponse;
    private static String jsonString;
    private static StringitemId;
    private static String userTOKEN;

    @Given("I am an authorized user")
    public void iAmAnAuthorizedUser() {

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();

        request.header("Content-Type", "application/json");

        authResponse = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}")
                .post("/Account/v1/GenerateToken");

        String jsonString = authResponse.asString();
        // testContent creation sample
        testContext().setResponse(authResponse);
        token = JsonPath.from(testContext().getResponse().asString()).get("token");
    }

    @When("I enter the following credentials")
    public void iEnterTheFollowingCredentials(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String username = row.get("username");
            String password = row.get("password");
            // Perform login with the provided credentials
        }
    }

    @Given("A list of items are available")
    public void listOfItemsAreAvailable() {

        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();
        response = request.get("/ListItems/v1/Item");

        jsonString = response.asString();
        List<Map<String, String>> items = JsonPath.from(jsonString).get("items");
        Assert.assertTrue(items.size() > 0);
        itemId = items.get(0).get("isbn");
    }

    @When("I add an item to my list")
    public void addItemInList() {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"userId\": \"" + USER_ID + "\", " +
                        "\"collectionOfIsbns\": [ { \"isbn\": \"" + itemId + "\" } ]}")
                .post("/ListItems/v1/Item");
    }

    @Then("The item is added")
    public voiditemIsAdded() {
        Assert.assertEquals(201, response.getStatusCode(), 201);
    }

    @When("I remove an item from my list")
    public void removeItemFromList() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.body("{ \"isbn\": \"" + itemId + "\", \"userId\": \"" + USER_ID + "\"}")
                .delete("/ItemStore/v1/Item");
    }

    @Then("The item is removed")
    public void ItemIsRemoved() {
        RestAssured.baseURI = baseUrl;
        RequestSpecification request = RestAssured.given();

        request.header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json");

        response = request.get("/Account/v1/User/" + USER_ID);
        Assert.assertEquals(response.getStatusCode(), 200);
        jsonString = response.asString();
        List<Map<String, String>> itemsOfUser = JsonPath.from(jsonString).get("books");
        Assert.assertEquals(0, itemsOfUser.size());
    }
}