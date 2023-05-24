package payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
public class DifferentDataTypeRepository {

    @JsonProperty
    private int name;
    @JsonProperty
    private boolean description;

    public DifferentDataTypeRepository(int name, boolean description) {
        this.name = name;
        this.description = description;
    }

    public int getName() {
        return name;
    }
    public boolean getDescription() {
        return description;
    }
}
