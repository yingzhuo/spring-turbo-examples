package spring.turbo.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.turbo.module.captcha.google.GoogleCaptchaService;
import spring.turbo.module.captcha.google.word.MathWordFactory;

@Configuration
class ApplicationBootConfBean {

    @Bean
    public GoogleCaptchaService googleCaptchaService() {
        final GoogleCaptchaService bean = new GoogleCaptchaService();
        bean.setWordFactory(new MathWordFactory());
        return bean;
    }

}
