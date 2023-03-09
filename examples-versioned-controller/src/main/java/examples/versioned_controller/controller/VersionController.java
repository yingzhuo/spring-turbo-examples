package examples.versioned_controller.controller;

import examples.versioned_controller.version.ApiV1;
import examples.versioned_controller.version.ApiV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/{version:v[0-9]+}")
public class VersionController {

    @ApiV1
    @GetMapping("/hello")
    public Map<String, String> v1() {
        return Map.of("version", "v1");
    }

    @ApiV2
    @GetMapping("/hello")
    public Map<String, String> v2() {
        return Map.of("version", "v2");
    }

}
