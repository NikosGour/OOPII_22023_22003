
package gr.dit.hua.it22023.it22003.Models.OpenData.wikipedia;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "warnings"
})
public class Extracts {

    @JsonProperty("warnings")
    private String warnings;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Extracts() {
    }

    /**
     * 
     * @param warnings
     */
    public Extracts(String warnings) {
        super();
        this.warnings = warnings;
    }

    @JsonProperty("warnings")
    public String getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("warnings", warnings).append("additionalProperties", additionalProperties).toString();
    }

}
