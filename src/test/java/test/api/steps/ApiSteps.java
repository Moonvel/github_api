package test.api.steps;

import test.api.helper.ApiHelper;
import test.api.model.Repos;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;


public class ApiSteps {
    ApiHelper apiHelper = new ApiHelper();
    @Step("Получен список реозиториев GitHub")
    public List<Repos> getRepos(String ownerName) {
        String basePath = String.format("/users/%s/repos", ownerName);
        Response response = apiHelper.getResponse(basePath);
        apiHelper.check(response);
        return List.of(response.as(Repos[].class));
    }
    @Step("Получен репозиторий GitHub: {0}")
    public Repos getRepo(String fullName){
        String basePath = String.format("repos/%s",fullName);
        Response response = apiHelper.getResponse(basePath);
        apiHelper.check(response);
        return response.as(Repos.class);
    }

}

//https://api.github.com/repos/{owner}/{repo}