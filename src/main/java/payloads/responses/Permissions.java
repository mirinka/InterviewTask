package payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {

    @JsonProperty
    private boolean admin;
    @JsonProperty
    private boolean push;
    @JsonProperty
    private boolean pull;
    @JsonProperty
    private boolean maintain;
    @JsonProperty
    private boolean triage;
}
