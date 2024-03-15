package git.api.selenide.tests;

import git.api.selenide.model.Repos;
import git.api.selenide.steps.ApiSteps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class SelenideRepoTests {
    ApiSteps apiSteps = new ApiSteps();
    @Test
    public void getReposTest() {
        Repos[] repos = apiSteps.getRepos();
    }
}

