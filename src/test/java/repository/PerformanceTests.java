package repository;

import config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import requests.RepositoryApi;

import static utils.configuration.Settings.TOKEN;
import static verifications.ResponseTimeVerifications.verifyResponseTimeLessThan;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PerformanceTests extends BaseTest {

    @Test
    public void verifyResponseTimeLessThan2Seconds() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verifyResponseTimeLessThan(response, 2000l);

        addRepositoryForDeletion(repository);
    }
}
