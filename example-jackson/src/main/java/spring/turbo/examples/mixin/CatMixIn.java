package spring.turbo.examples.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import spring.turbo.module.jackson.serializer.DefaultStringValueSerializer;
import spring.turbo.module.jackson.serializer.predefined.NullDefaults;

@JsonIgnoreProperties({"dob"})
public interface CatMixIn {

    @JsonSerialize(nullsUsing = DefaultStringValueSerializer.class)
    public String getName();

    @JsonSerialize(nullsUsing = NullDefaults.Double.Zero.class)
    public Integer getAge();

}
