package git.api.selenide.tests;

import git.api.selenide.model.Repos;
import git.api.selenide.steps.ApiSteps;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


public class SelenideRepoTests {
    ApiSteps apiSteps = new ApiSteps();
    private static List<Repos> repos;

    private static Stream<Arguments> reposProvider(){
        return repos.stream().map(Arguments::of);
    }
    @Test
    public void getReposTest() {
        repos = apiSteps.getRepos("selenide");
    }
    @ParameterizedTest
    @MethodSource("reposProvider")
    public void getRepoTest(Repos repo) {
        Repos repository = apiSteps.getRepo(repo.getFull_name());
    }
}




