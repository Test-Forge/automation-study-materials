import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegressionTest {
    private static final String BASE_URL = "https://api.example.com/";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

    private Response getUsers(String endpoint) {
        return RestAssured
                .given()
                .get(endpoint);
    }

    private Response createUser(String endpoint, String payload) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(payload)
                .post(endpoint);
    }

    private Response updateUser(String endpoint, String payload) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(payload)
                .put(endpoint);
    }

    private Response deleteUser(String endpoint) {
        return RestAssured
                .given()
                .delete(endpoint);
    }

    private <T> T getContent(Response response, Class<T> responseType) {
        return response.as(responseType);
    }

    @Test
    public void checkListOfUsers() {
        Response response = getUsers("api/users?page=2");
        ListOfUsersDTO content = getContent(response, ListOfUsersDTO.class);
        Assert.assertEquals(content.getPage(), 2);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(content.getData().get(0).getFirstName(), "Michael");
    }

    @Test
    public void createNewUser() {
        String payload = "{ \"Name\":\"Ion\", \"Job\":\"dev\" }";
        Response response = createUser("api/users", payload);
        CreateUserDTO content = getContent(response, CreateUserDTO.class);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(content.getName(), "Ion");
        Assert.assertEquals(content.getJob(), "dev");
    }

    @Test
    public void updateUserById() {
        String payload = "{ \"Name\":\"John\", \"Job\":\"QA\" }";
        Response response = updateUser("api/users/7", payload);
        CreateUserDTO content = getContent(response, CreateUserDTO.class);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(content.getName(), "John");
        Assert.assertEquals(content.getJob(), "QA");
    }

    @Test
    public void deleteUserById() {
        Response response = deleteUser("api/users/7");
        Assert.assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void registerUserSuccessfully() {
        String payload = "{ \"Email\":\"Ion\", \"Password\":\"dev\" }";
        Response response = createUser("api/register", payload);
        RegisterUserDTO content = getContent(response, RegisterUserDTO.class);
        Assert.assertEquals(response.getStatusCode(), 201);
        Assert.assertEquals(content.getEmail(), "Ion");
        Assert.assertEquals(content.getPassword(), "dev");
    }
}