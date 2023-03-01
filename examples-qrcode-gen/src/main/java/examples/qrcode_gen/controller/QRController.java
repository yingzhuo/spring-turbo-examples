package examples.qrcode_gen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.turbo.module.misc.qrcode.QRCodeGenerator;
import spring.turbo.module.webmvc.entity.ImageResponseEntity;
import spring.turbo.util.ImageFormatPool;

@Controller
public class QRController {

    @Autowired
    private QRCodeGenerator generator;

    @GetMapping("/qrcode")
    public ImageResponseEntity qrcode2() {
        var content = "https://github.com/yingzhuo/spring-turbo";
        var img = generator.generate(content);
        return ImageResponseEntity.builder()
                .format(ImageFormatPool.PNG)
                .image(img)
                .build();
    }

}
