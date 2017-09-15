
package generated;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "listeners",
    "mbid",
    "url",
    "streamable",
    "image"
})
public class Artist {

    @JsonProperty("name")
    public String name;
    @JsonProperty("listeners")
    public String listeners;
    @JsonProperty("mbid")
    public String mbid;
    @JsonProperty("url")
    public String url;
    @JsonProperty("streamable")
    public String streamable;
    @JsonProperty("image")
    public List<Image> image = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
