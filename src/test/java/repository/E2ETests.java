package repository;

import config.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import requests.RepositoryApi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static utils.configuration.Settings.REPOSITORY_OWNER;
import static utils.configuration.Settings.TOKEN;
import static verifications.StatusCodeVerifications.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class E2ETests extends BaseTest {

    /*
    create repository, then delete it
    after that try to retrieve the deleted repository and verify it does not exist
     */
    @Test
    public void createAndDeleteRepository() {
        // create repository
        repository = repositoryTestData.getRepository();
        RepositoryApi.postRepository(repository, TOKEN);

        // delete repository
        Response deleteResponse = RepositoryApi.deleteRepository(TOKEN, REPOSITORY_OWNER, repository.getName());
        verify204ResponseCode(deleteResponse);

        // try to retrieve deleted repository
        Response getResponse = RepositoryApi.getRepository(TOKEN, REPOSITORY_OWNER, repository.getName());
        verify404ResponseCode(getResponse);
    }

    /*
    create repository, then retrieve this repository and verify that the fields are persisted correct
    might be possible that status code and response of create repository are correct, but data is not stored correct in database
     */
    @Test
    public void createAndRetrieveRepository() {
        // create repository
        repository = repositoryTestData.getRepository();
        RepositoryApi.postRepository(repository, TOKEN);

        // retrieve created repository
        Response getResponse = RepositoryApi.getRepository(TOKEN, REPOSITORY_OWNER, repository.getName());
        verify200ResponseCode(getResponse);

        // verify fields are stored correct
        String actualName = getResponse.jsonPath().get("name");
        String actualDescription = getResponse.jsonPath().get("description");
        assertEquals(repository.getName(), actualName, "Repository name is not saved correct!");
        assertEquals(repository.getDescription(), actualDescription, "Repository description is not saved correct!");

        addRepositoryForDeletion(repository);
    }
}
