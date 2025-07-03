import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTest {

    @Test
    public void checkGetUsers() {
        given()
                .baseUri("https://reqres.in/api")
                .header("x-api-key", "reqres-free-v1")
                .when()
                .queryParam("page", 1)
                .queryParam("per_page", 3)
                .get("/users")
                .then()
                .assertThat()
                .statusCode(200)
                .body("page", Matchers.equalTo(1))
                .body("per_page", Matchers.equalTo(3))
                .body("data.size()", Matchers.equalTo(3))
                .body("data[0].first_name", Matchers.equalTo("George"))
                .body("data[0].last_name", Matchers.equalTo("Bluth"));
    }
}
