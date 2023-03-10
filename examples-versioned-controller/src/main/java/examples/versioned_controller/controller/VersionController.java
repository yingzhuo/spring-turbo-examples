package examples.versioned_controller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.webmvc.support.request.API_v1;
import spring.turbo.module.webmvc.support.request.API_v2;

import java.util.Map;

@RestController
@RequestMapping("/{version:v[0-9]+}")
public class VersionController {

    @API_v1
    @GetMapping("/hello")
    public Map<String, String> v1() {
        return Map.of("version", "v1");
    }

    @API_v2
    @GetMapping("/hello")
    public Map<String, String> v2() {
        return Map.of("version", "v2");
    }

}
