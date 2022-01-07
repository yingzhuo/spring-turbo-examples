package spring.turbo.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import spring.turbo.examples.valueobject.Cat;
import spring.turbo.module.excel.writer.AnnotationDrivenExcelView;

@Configuration
class ApplicationBootMvc {

    @Bean(name = "cats-view")
    AnnotationDrivenExcelView<Cat> catView(ApplicationContext applicationContext) {
        final AnnotationDrivenExcelView<Cat> view = new AnnotationDrivenExcelView<>(applicationContext, Cat.class, "cats");
//        view.configApplicationContext(applicationContext); // optional
        return view;
    }

    @Autowired
    void config(BeanNameViewResolver viewResolver) {
        viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
