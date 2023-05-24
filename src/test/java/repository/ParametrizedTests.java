package repository;

import config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import requests.RepositoryApi;

import static utils.configuration.Settings.TOKEN;
import static verifications.StatusCodeVerifications.verifyResponseCodeEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParametrizedTests extends BaseTest {

    /*
    Note:
    This is just an example, test scenarios are already covered.
    */
    @ParameterizedTest(name = "Run: {index} Values: {arguments}")
    @CsvFileSource(resources = "/dataseed.csv", numLinesToSkip = 1)
    public void verifyStatusCodesAccordingToNameAndDescription(String repositoryName, String repositoryDescription, int statusCode) {
        // arrange
        repository = repositoryTestData.getRepositoryWithSpecificNameAndDescription(repositoryName, repositoryDescription);

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verifyResponseCodeEquals(statusCode, response.statusCode());

        addRepositoryForDeletion(repository);
    }
}
