package spring.turbo.examples.controller;

import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.examples.domain.Cat;
import spring.turbo.util.ListFactories;
import spring.turbo.webmvc.api.Json;

@RestController
@RequestMapping("/cat")
class CatController {

    @GetMapping
    Json findAll() {
        val cats = ListFactories.nullSafeNewArrayList(
                new Cat(null, 7),
                new Cat("贵霜", null)
        );

        return Json.newInstance()
                .payload("cats", cats);
    }

}
