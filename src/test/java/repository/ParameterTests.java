package repository;

import config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import payloads.DifferentDataTypeRepository;
import payloads.InvalidRepository;
import payloads.Repository;
import requests.RepositoryApi;

import static utils.configuration.Settings.TOKEN;
import static utils.constants.SpecialStrings.*;
import static verifications.RepositoryVerifications.*;
import static verifications.StatusCodeVerifications.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ParameterTests extends BaseTest {

    @Test
    public void verifyCreateRepositoryStatusCode() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify201ResponseCode(response);

        addRepositoryForDeletion(repository);
    }

    @Test
    public void verifyResponseFieldsWithPojo() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verifyNameAndDescription(repository, response);

        addRepositoryForDeletion(repository);
    }

    // the purpose of this test is to demonstrate retrieving response values with JsonPath
    @Test
    public void verifyResponseFieldsWithJsonPath() {
        // arrange
        repository = repositoryTestData.getRepository();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        String actualName = response.jsonPath().get("name");
        String actualDescription = response.jsonPath().get("description");
        verifyNameAndDescription(repository, actualName, actualDescription);

        addRepositoryForDeletion(repository);
    }

    @Test
    public void createRepositoryWithEmptyName() {
        // arrange
        repository = repositoryTestData.getRepositoryWithEmptyName();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify422ResponseCode(response);
    }

    @Test
    public void createRepositoryWithEmptyDescription() {
        // arrange
        repository = repositoryTestData.getRepositoryWithEmptyDescription();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify201ResponseCode(response);
        // description is null when empty string is passed
        verifyNameAndNullDescription(repository, response);

        addRepositoryForDeletion(repository);
    }

    @Test
    public void createRepositoryWithEmptyNameAndDescription() {
        // arrange
        repository = repositoryTestData.getRepositoryWithEmptyNameAndDescription();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify422ResponseCode(response);
    }

    @Test
    public void createRepositoryWithNullValues() {
        // arrange
        repository = repositoryTestData.getRepositoryWithNullValues();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify422ResponseCode(response);
    }

    @Test
    public void createRepositoryWithDuplicateName() {
        // arrange
        String repositoryName = repositoryTestData.getRepositoryName();
        Repository firstRepository = repositoryTestData.getRepositoryWithSpecificName(repositoryName);
        Repository secondRepository = repositoryTestData.getRepositoryWithSpecificName(repositoryName);
        RepositoryApi.postRepository(firstRepository, TOKEN);

        // act
        Response responseSecondRepository = RepositoryApi.postRepository(secondRepository, TOKEN);

        // assert
        verify422ResponseCode(responseSecondRepository);

        addRepositoryForDeletion(firstRepository);
    }

    @Test
    public void createRepositoryWithDuplicateDescription() {
        // arrange
        String repositoryDescription = repositoryTestData.getRepositoryDescription();
        Repository firstRepository = repositoryTestData.getRepositoryWithSpecificDescription(repositoryDescription);
        Repository secondRepository = repositoryTestData.getRepositoryWithSpecificDescription(repositoryDescription);
        RepositoryApi.postRepository(firstRepository, TOKEN);

        // act
        Response responseSecondRepository = RepositoryApi.postRepository(secondRepository, TOKEN);

        // assert
        verify201ResponseCode(responseSecondRepository);

        addRepositoryForDeletion(firstRepository);
        addRepositoryForDeletion(secondRepository);
    }

    @Test
    public void createRepositoryWithSpacesInName() {
        // arrange
        Repository repository = repositoryTestData.getRepositoryWithSpacesInName();
        Repository expectedRepository = repositoryTestData.getRepositoryWithSpecificNameAndDescription(STRIPPED_SPACES_STRING, repository.getDescription());

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify201ResponseCode(response);
        verifyNameAndDescription(expectedRepository, response);

        addRepositoryForDeletion(expectedRepository);
    }

    @Test
    public void createRepositoryWithIntAndBooleanDataTypes() {
        // arrange
        DifferentDataTypeRepository repository = repositoryTestData.getRepositoryWithNumericAndBoolean();
        Repository expectedRepository = repositoryTestData.getRepositoryWithSpecificNameAndNoDescription(String.valueOf(repository.getName()));

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify201ResponseCode(response);
        // description is null when boolean is passed
        verifyNameAndNullDescription(expectedRepository, response);

        addRepositoryForDeletion(expectedRepository);
    }

    @Test
    public void createRepositoryWithIncorrectObject() {
        // arrange
        InvalidRepository repository = repositoryTestData.getInvalidRepository();

        // act
        Response response = RepositoryApi.postInvalidRepository(repository, TOKEN);

        // assert
        verify422ResponseCode(response);
    }

    @Test
    public void createRepositoryWithOnlyOneSymbolNameAndDescription() {
        // arrange
        repository = repositoryTestData.getRepositoryWithOneSymbol();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // assert
        verify201ResponseCode(response);
        verifyNameAndDescription(repository, response);

        addRepositoryForDeletion(repository);
    }

    @Test
    public void createRepositoryWithVeryLongDescription() {
        // arrange
        repository = repositoryTestData.getRepositoryWithLongDescription();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // asserts
        verify201ResponseCode(response);
        verifyNameAndDescription(repository, response);

        addRepositoryForDeletion(repository);
    }

    @Test
    public void createRepositoryWithCapitalLettersOnly() {
        // arrange
        repository = repositoryTestData.getRepositoryWithCapitalLettersOnly();

        // act
        Response response = RepositoryApi.postRepository(repository, TOKEN);

        // asserts
        verify201ResponseCode(response);
        verifyNameAndDescription(repository, response);

        addRepositoryForDeletion(repository);
    }
}
