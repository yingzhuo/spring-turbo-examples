package examples.versioned_controller.version;

import spring.turbo.module.webmvc.support.request.Versioned;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Versioned(value = "v1")
public @interface ApiV1 {
}
