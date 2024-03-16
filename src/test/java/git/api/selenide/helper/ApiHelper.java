package git.api.selenide.helper;

import git.api.selenide.properties.PropsHelper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.anything;

public class ApiHelper {
    PropsHelper propsHelper = PropsHelper.getInstance();
    RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri(propsHelper.getProperty("baseGitHubUri"))
            .setContentType(ContentType.JSON)
            .build();
    ResponseSpecification responseCheck = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(anything())
            .build();

    public Response getResponse(String basePath) {
        return given().spec(requestSpec).get(basePath);
    }
    public void check(Response response){
        response.then().spec(responseCheck);
    }
}
