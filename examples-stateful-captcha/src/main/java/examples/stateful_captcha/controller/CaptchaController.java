package examples.stateful_captcha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.module.misc.captcha.CaptchaService;
import spring.turbo.module.webmvc.entity.ImageResponseEntity;
import spring.turbo.util.ImageFormatPool;

@RestController
public class CaptchaController {

    @Autowired
    private CaptchaService captchaService;

    @GetMapping("/captcha")
    public ImageResponseEntity captcha() {
        final var captcha = this.captchaService.get();

        return ImageResponseEntity.builder()
                .status(HttpStatus.OK)
                .format(ImageFormatPool.PNG)
                .image(captcha.getImage())
                .build();
    }

}
