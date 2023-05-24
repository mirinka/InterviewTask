package requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.DifferentDataTypeRepository;
import payloads.InvalidRepository;
import payloads.Repository;

import static io.restassured.RestAssured.given;
import static utils.constants.Routing.*;

public class RepositoryApi {

    public static Response postRepository(Repository payload) {
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

    public static Response postRepository(DifferentDataTypeRepository payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    public static Response postInvalidRepository(InvalidRepository payload, String token) {
        return given()
                .header("Authorization", "Bearer " + token)
                .basePath(POST_REPOSITORY)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();
    }

    public static Response deleteRepository(String token, String owner, String repositoryName) {
        return given()
                .header("Authorization", "Bearer " + token)
                .basePath(DELETE_REPOSITORY + owner + "/" + repositoryName)
                .delete();
    }

    public static Response getRepository(String token, String owner, String repositoryName) {
        return given()
                .header("Authorization", "Bearer " + token)
                .basePath(REPOSITORIES + owner + "/" + repositoryName)
                .when()
                .get();
    }
}
