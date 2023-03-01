package examples.qrcode_gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.turbo.io.ImageUtils;
import spring.turbo.module.misc.qrcode.QRCodeGenerator;
import spring.turbo.util.ImageFormatPool;

@RestController
public class Base64QRController {

    @Autowired
    private QRCodeGenerator generator;

    @GetMapping("/base64-qrcode")
    public String qrcode1() {
        var content = "https://github.com/yingzhuo/spring-turbo";
        var img = generator.generate(content);
        return ImageUtils.encodeToBase64(img, ImageFormatPool.PNG);
    }

}
