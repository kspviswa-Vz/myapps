
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
    "DeviceId",
    "Payload"
})
public class FpcDTO implements Serializable
{

    @JsonProperty("DeviceId")
    private String deviceId;
    @JsonProperty("Payload")
    private Payload payload;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2768504853084904958L;

    @JsonProperty("DeviceId")
    public String getDeviceId() {
        return deviceId;
    }

    @JsonProperty("DeviceId")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    @JsonProperty("Payload")
    public Payload getPayload() {
        return payload;
    }

    @JsonProperty("Payload")
    public void setPayload(Payload payload) {
        this.payload = payload;
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
