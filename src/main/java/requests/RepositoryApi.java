package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.DifferentDataTypeRepository;
import payloads.InvalidRepository;
import payloads.Repository;

import static io.restassured.RestAssured.given;
import static utils.configuration.Settings.REPOSITORY_OWNER;
import static utils.configuration.Settings.TOKEN;
import static utils.constants.Routing.*;

public class RepositoryApi {

    public static Response postRepositoryWithoutToken(Repository payload) {
        return given()
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    public static Response postRepository(Repository payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }
    public static Response postRepository(Repository payload) {
        return given()
                .header("Authorization", "Bearer " + TOKEN)
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    public static Response postRepository(DifferentDataTypeRepository payload) {
        return given()
                .header("Authorization", "Bearer " + TOKEN)
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    public static Response postInvalidRepository(InvalidRepository payload) {
        return given()
                .header("Authorization", "Bearer " + TOKEN)
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    public static Response deleteRepository(String repositoryName) {
        return given()
                .header("Authorization", "Bearer " + TOKEN)
                .basePath(DELETE_REPOSITORY + REPOSITORY_OWNER + "/" + repositoryName)
                .delete();
    }

    public static Response getRepository(String repositoryName) {
        return given()
                .header("Authorization", "Bearer " + TOKEN)
                .basePath(REPOSITORIES + REPOSITORY_OWNER + "/" + repositoryName)
                .when()
                .get();
    }
}
