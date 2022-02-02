package spring.turbo.examples.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDomain implements Serializable {

    private String secret;

}
