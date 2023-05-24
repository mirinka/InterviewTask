package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvalidRepository {

    @JsonProperty
    private String nonExistingField;

    public InvalidRepository() {
        nonExistingField = "this is non existing field";
    }
}
