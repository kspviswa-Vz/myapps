
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
    "instr-3gpp-mob"
})
public class Instructions implements Serializable
{

    @JsonProperty("instr-3gpp-mob")
    private String instr3gppMob;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5356817085114188977L;

    @JsonProperty("instr-3gpp-mob")
    public String getInstr3gppMob() {
        return instr3gppMob;
    }

    @JsonProperty("instr-3gpp-mob")
    public void setInstr3gppMob(String instr3gppMob) {
        this.instr3gppMob = instr3gppMob;
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
