package verifications;

import io.restassured.response.Response;
import payloads.Repository;
import payloads.responses.RepositoryResponse;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryVerifications {

    public static void verifyNameAndDescription(Repository expectedRepository, Response response) {
        RepositoryResponse actualRepository = response.as(RepositoryResponse.class);

        assertEquals(expectedRepository.getName(), actualRepository.getName(), "Repository name is not correct!");
        assertEquals(expectedRepository.getDescription(), actualRepository.getDescription(), "Repository description is not correct!");
    }

    public static void verifyNameAndDescription(Repository expectedRepository, String actualName, String actualDescription) {
        assertEquals(expectedRepository.getName(), actualName, "Repository name is not correct!");
        assertEquals(expectedRepository.getDescription(), actualDescription, "Repository description is not correct!");
    }

    public static void verifyNameAndDescription(String expectedName, String expectedDescription, Response response) {
        RepositoryResponse actualRepository = response.as(RepositoryResponse.class);

        assertEquals(expectedName, actualRepository.getName(), "Repository name is not correct!");
        assertEquals(expectedDescription, actualRepository.getDescription(), "Repository description is not correct!");
    }

    public static void verifyNameAndNullDescription(Repository expectedRepository, Response response) {
        RepositoryResponse actualRepository = response.as(RepositoryResponse.class);

        assertEquals(expectedRepository.getName(), actualRepository.getName(), "Repository name is not correct!");
        assertNull(actualRepository.getDescription(), "Repository description should be null!");
    }

    public static void verifyName(String expectedName, String actualName) {
        assertEquals(expectedName, actualName, "Repository name should be the same");
    }

    public static void verifyNameIsNot(String expectedName, String actualName) {
        assertNotEquals(expectedName, actualName, "Repository name should not be the same");
    }
}
