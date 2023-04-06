package examples.random_avatar_gen.controller;

import com.github.yingzhuo.avatargenerator.Avatar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.turbo.module.webmvc.support.response.ImageResponseEntity;
import spring.turbo.util.ImageFormatPool;

@Controller
public class AvatarController {

    @Autowired
    private Avatar avatar;

    @GetMapping("/avatar")
    public ImageResponseEntity avatar() {
        var img = avatar.create(123456L);
        return ImageResponseEntity.builder()
                .format(ImageFormatPool.PNG)
                .image(img)
                .build();
    }

}
