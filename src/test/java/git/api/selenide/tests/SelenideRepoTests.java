package git.api.selenide.tests;

import git.api.selenide.model.Repos;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class SelenideRepoTests {
    @Test
    public void getRepos(){
        List<Repos> repos = given()
                .baseUri("https://api.github.com")
                .basePath("/users/selenide/repos")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200)
                .extract().jsonPath().getList(".", Repos.class);
    }
}