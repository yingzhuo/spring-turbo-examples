package spring.turbo.examples.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import spring.turbo.module.jackson.serializer.predefined.Converters;

@JsonIgnoreProperties({"deprecated"})
public interface JsonMixIn {

    @JsonSerialize(using = Converters.String.ToLong.class)
    public String getCode();

    @JsonProperty("error")
    public String getErrorMessage();

    @JsonProperty("data")
    public Object getPayload();

}
