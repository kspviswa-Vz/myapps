
package com.vz.onosproject.DTO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dpn-id",
    "direction",
    "dpn-parameters"
})
public class Dpn implements Serializable
{

    @JsonProperty("dpn-id")
    private String dpnId;
    @JsonProperty("direction")
    private String direction;
    @JsonProperty("dpn-parameters")
    private DpnParameters__ dpnParameters;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 9195371302223161495L;

    @JsonProperty("dpn-id")
    public String getDpnId() {
        return dpnId;
    }

    @JsonProperty("dpn-id")
    public void setDpnId(String dpnId) {
        this.dpnId = dpnId;
    }

    @JsonProperty("direction")
    public String getDirection() {
        return direction;
    }

    @JsonProperty("direction")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @JsonProperty("dpn-parameters")
    public DpnParameters__ getDpnParameters() {
        return dpnParameters;
    }

    @JsonProperty("dpn-parameters")
    public void setDpnParameters(DpnParameters__ dpnParameters) {
        this.dpnParameters = dpnParameters;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
