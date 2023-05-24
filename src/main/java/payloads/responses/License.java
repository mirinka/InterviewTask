package payloads.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class License {

    @JsonProperty
    private String key;
    @JsonProperty
    private String name;
    @JsonProperty
    private String url;
    @JsonProperty("spdx_id")
    private String spdxId;
    @JsonProperty("node_id")
    private String nodeId;
    @JsonProperty("html_url")
    private String htmlUrl;
}
