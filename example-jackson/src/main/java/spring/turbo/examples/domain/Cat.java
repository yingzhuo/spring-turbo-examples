package spring.turbo.examples.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cat implements Serializable {

    private String name;
    private Integer age;

}
