package spring.turbo.examples.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cat extends AbstractDomain {

    private String name;
    private Integer age;

}
