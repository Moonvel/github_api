package git.api.selenide.steps;

import git.api.selenide.helper.ApiHelper;
import git.api.selenide.model.Repos;
import io.restassured.response.Response;




public class ApiSteps {
    ApiHelper apiHelper = new ApiHelper();
    public Repos[] getRepos() {
        Response response = apiHelper.getResponse();
        apiHelper.check(response);
        return response.as(Repos[].class);
    }
}
