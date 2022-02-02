package spring.turbo.examples.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"secret"})
public interface AbstractDomainMixIn {
}
