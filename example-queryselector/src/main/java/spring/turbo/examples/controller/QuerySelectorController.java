package spring.turbo.examples.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.queryselector.Selector;
import spring.turbo.module.queryselector.SelectorSet;
import spring.turbo.module.queryselector.resolver.SelectorSetResolver;
import spring.turbo.webmvc.api.Json;

@RestController
@AllArgsConstructor
class QuerySelectorController {

    private final SelectorSetResolver selectorSetResolver;

    @PostMapping("/test")
    Json post(@RequestParam("selectors") SelectorSet selectors) {
        for (Selector selector : selectors) {
            System.out.println(selector.getName());
        }
        return Json.newInstance();
    }

}
