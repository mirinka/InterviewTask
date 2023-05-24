package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import payloads.Repository;
import requests.RepositoryApi;
import test_data.RepositoryTestData;

import java.util.ArrayList;
import java.util.List;

import static utils.constants.Routing.BASE_URI;

public class BaseTest {

    protected Repository repository;
    protected RepositoryTestData repositoryTestData = new RepositoryTestData();
    protected List<Repository> repositoriesToDelete = new ArrayList<>();

    public void addRepositoryForDeletion(Repository repository) {
        repositoriesToDelete.add(repository);
    }

    @BeforeAll
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addHeader("accept", "application/vnd.github+json")
                .setBaseUri(BASE_URI)
                .build();
    }

    @AfterAll
    public void cleanUp() {
        for (Repository repository : repositoriesToDelete) {
            RepositoryApi.deleteRepository(repository.getName());
        }
    }
}
