package examples.versioned_controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.webmvc.requestcondition.Versioned;

import java.util.Map;

@RestController
@RequestMapping("/{version:v[0-9]+}")
public class VersionController {

    @Versioned(value = "v1")
    @GetMapping("/hello")
    public Map<String, String> v1() {
        return Map.of("version", "v1");
    }

    @Versioned(value = "v2")
    @GetMapping("/hello")
    public Map<String, String> v2() {
        return Map.of("version", "v2");
    }

}
