package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Repository {

    @JsonProperty
    private String name;
    @JsonProperty
    private String description;

    public Repository(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Repository(String name) {
        this.name = name;
        this.description = "";
    }
}
