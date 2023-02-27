package examples.stateless_captcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.misc.captcha.CaptchaService;
import spring.turbo.module.misc.captcha.EncodedCaptcha;
import spring.turbo.module.misc.captcha.support.AccessKeyGenerator;
import spring.turbo.webmvc.api.Json;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private AccessKeyGenerator accessKeyGenerator;

    @GetMapping("/captcha")
    public Json captcha() {
        final var captcha = this.captchaService.create();
        final var encodedCaptcha = EncodedCaptcha.of(captcha);

        return Json.newInstance()
                .payload("encoded-captcha", encodedCaptcha.getEncodedImage())
                .payload("word", encodedCaptcha.getWord());
    }

}
