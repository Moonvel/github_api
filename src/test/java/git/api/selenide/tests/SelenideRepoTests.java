package git.api.selenide.tests;

import git.api.selenide.model.Repos;
import git.api.selenide.steps.ApiSteps;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class SelenideRepoTests {
    ApiSteps apiSteps = new ApiSteps();
    private static List<Repos> repos;

    private static Stream<Arguments> reposProvider() {
        return repos.stream().map(Arguments::of);
    }

    @Test
    @DisplayName("Тест получения репозиториев GitHub")
    @Description("Делает api-запрос, получает и формируетс список репозиториев, проверки: код 200 и тело не пустое")
    public void getReposTest() {
        repos = apiSteps.getRepos("selenide");
    }

    @ParameterizedTest(name = "Проверка корректоности имени репозитория репозитория")
    @MethodSource("reposProvider")
    @Description("Делает api-запрос, получает full_name репозитория и сравнивает его с full_name из ранее сформированного списка, проверки: код 200 и тело не пустое")
    public void getRepoTest(Repos repoFromProvider) {
        String repoName = repoFromProvider.getFull_name();
        assertThat(apiSteps.getRepo(repoName).getFull_name(), equalTo(repoName));
        //apiSteps.getRepo(repoName).equals(repoFromProvider.getFull_name());
    }
}



//     private static Stream<String> reposNameProvider(){
//       return repos.stream().map(Repos::getFull_name);
//    }
//   @ParameterizedTest(name = "Проверка корректоности имени репозитория репозитория: {0}")
//   @MethodSource("reposNameProvider")
//   @Description("Делает api-запрос, получает full_name репозитория и сравнивает его с full_name из ранее сформированного списка, проверка код 200 и тело не пустое")
//   public void getRepoTest(String repoFullName) {
//       apiSteps.getRepo(repoFullName).equals(repoFullName);
//   }



