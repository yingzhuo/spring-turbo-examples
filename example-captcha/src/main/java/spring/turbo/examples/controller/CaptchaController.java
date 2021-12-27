package spring.turbo.examples.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.turbo.module.captcha.Captcha;
import spring.turbo.module.captcha.CaptchaFormat;
import spring.turbo.module.captcha.CaptchaService;
import spring.turbo.module.captcha.support.AccessKeyGenerator;
import spring.turbo.module.security.webmvc.entity.ImageResponseEntity;

@Slf4j
@Controller
class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @Autowired
    private AccessKeyGenerator accessKeyGenerator;

    @GetMapping(path = "/captcha")
    ImageResponseEntity captcha() {
        final String accessKey = accessKeyGenerator.generate();
        final Captcha captcha = captchaService.create();

        log.debug("access-key: {}", accessKey);
        log.debug("captcha-word: {}", captcha.getWord());

        return ImageResponseEntity.builder()
                .status(HttpStatus.OK)
                .image(captcha.getImage())
                .format(CaptchaFormat.PNG)
                .build();
    }

}
