package spring.turbo.examples.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.queryselector.Selector;
import spring.turbo.module.queryselector.SelectorSet;
import spring.turbo.webmvc.api.Json;

@RestController
@AllArgsConstructor
class QuerySelectorController {

    @PostMapping("/test")
    Json post(@RequestBody JsonRequest request) {
        for (Selector selector : request.getSelectors()) {
            System.out.println(selector.getName());
        }
        return Json.newInstance();
    }

    @Data
    private static class JsonRequest {
        private SelectorSet selectors;
    }

}
