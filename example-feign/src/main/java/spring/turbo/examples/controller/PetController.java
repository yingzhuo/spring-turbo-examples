package spring.turbo.examples.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.examples.model.Pet;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
class PetController {

    @GetMapping
    List<Pet> getAll() {
        return Arrays.asList(
                new Pet("米来", 8),
                new Pet("贵霜", 7)
        );
    }

}
