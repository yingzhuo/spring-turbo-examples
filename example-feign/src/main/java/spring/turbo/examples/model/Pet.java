package spring.turbo.examples.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Pet implements Serializable {

    private String name;
    private int age;

}
