package repository;

import config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import payloads.Repository;
import requests.RepositoryApi;

import static utils.configuration.Settings.TOKEN;
import static verifications.RepositoryVerifications.*;
import static verifications.StatusCodeVerifications.verify201or422StatusCode;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SpamTests extends BaseTest {

    /*
    Note:
    Sometimes when running the tests a couple of times, GitHub considers you try to spam and fails on purpose.
    Either the test succeeds, or it fails with 422.
    All the test scenarios listed here have this behavior.
    */
    @Test
    public void createRepositoryWithSpecialSymbols() {
        // arrange
        repository = repositoryTestData.getRepositoryWithSpecialSymbols();

        // act
        Response response = RepositoryApi.postRepository(repository);

        // assert
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // verify response fields
            verifyNameAndDescription(repository, response);

            addRepositoryForDeletion(repository);
        }
    }

    @Test
    public void createRepositoryWithScriptAlertForName() {
        // arrange
        repository = repositoryTestData.getRepositoryWithScriptName();
        Repository expectedRepository = repositoryTestData.getRepositoryWithStrippedScriptName();

        // act
        Response response = RepositoryApi.postRepository(repository);
        String actualRepositoryName = response.jsonPath().get("name");

        // assert
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // verify response fields
            verifyNameIsNot(repository.getName(), actualRepositoryName);
            verifyName(expectedRepository.getName(), actualRepositoryName);

            addRepositoryForDeletion(expectedRepository);
        }
    }

    @Test
    public void createRepositoryWithVeryLongName() {
        // arrange
        repository = repositoryTestData.getRepositoryWithLongName();

        // act
        Response response = RepositoryApi.postRepository(repository);

        // assert
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // verify response fields
            verifyNameAndDescription(repository, response);

            addRepositoryForDeletion(repository);
        }
    }

    @Test
    public void createRepositoryWithGermanSymbols() {
        // arrange
        repository = repositoryTestData.getRepositoryWithGermanSymbols();
        Repository expectedRepository = repositoryTestData.getRepositoryWithSpecificNameAndDescription("-", repository.getDescription());

        // act
        Response response = RepositoryApi.postRepository(repository);

        // asserts
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // when passing special german symbols, then - is saved
            verifyNameAndDescription(expectedRepository, response);

            addRepositoryForDeletion(expectedRepository);
        }
    }

    @Test
    public void createRepositoryWithArabicSymbols() {
        // arrange
        repository = repositoryTestData.getRepositoryWithArabicSymbols();

        // act
        Response response = RepositoryApi.postRepository(repository);

        // asserts
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // verify response fields
            verifyNameAndDescription(repository, response);

            addRepositoryForDeletion(repository);
        }
    }

    @Test
    public void createRepositoryWithChineseSymbols() {
        // arrange
        repository = repositoryTestData.getRepositoryWithChineseSymbols();

        // act
        Response response = RepositoryApi.postRepository(repository);

        // asserts
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // verify response fields
            verifyNameAndDescription(repository, response);

            addRepositoryForDeletion(repository);
        }
    }

    @Test
    public void createRepositoryWithEmojiSymbols() {
        // arrange
        repository = repositoryTestData.getRepositoryWithEmojiSymbols();

        // act
        Response response = RepositoryApi.postRepository(repository);

        // asserts
        verify201or422StatusCode(response);
        if (response.statusCode() == 201) {
            // verify response fields
            verifyNameAndNullDescription(repository, response);

            addRepositoryForDeletion(repository);
        }
    }
}
