package repository;

import config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import requests.RepositoryApi;

import static utils.configuration.Settings.*;
import static verifications.StatusCodeVerifications.verify401ResponseCode;
import static verifications.StatusCodeVerifications.verify404ResponseCode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecurityTests extends BaseTest {

    @Test
    public void createRepositoryWithoutToken() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository);

        // assert
        verify401ResponseCode(response);
    }

    @Test
    public void createRepositoryWithInvalidToken() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, INVALID_TOKEN);

        // assert
        verify401ResponseCode(response);
    }

    @Test
    public void createRepositoryWithExpiredToken() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, EXPIRED_TOKEN);

        // assert
        verify401ResponseCode(response);
    }

    @Test
    public void createRepositoryWithInsufficientPermissionsToken() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, INSUFFICIENT_PERMISSIONS_TOKEN);

        // assert
        verify404ResponseCode(response);
    }
}
