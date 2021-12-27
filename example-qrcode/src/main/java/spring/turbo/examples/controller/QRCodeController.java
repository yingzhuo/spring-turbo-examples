package spring.turbo.examples.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.turbo.module.qrcode.QRCodeGenerator;
import spring.turbo.module.security.webmvc.entity.ImageResponseEntity;

@Controller
@AllArgsConstructor
class QRCodeController {

    private final QRCodeGenerator qrCodeGenerator;

    @GetMapping(path = "/qrcode")
    ImageResponseEntity qrcode() {
        return ImageResponseEntity.builder()
                .status(HttpStatus.OK)
                .image(qrCodeGenerator.generate("https://github.com/yingzhuo/spring-turbo"))
                .format("png")
                .build();
    }

}
