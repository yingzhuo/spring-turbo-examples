package spring.turbo.examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import spring.turbo.examples.valueobject.Cat;
import spring.turbo.module.excel.writer.AnnotationDrivenExcelView;
import spring.turbo.module.excel.writer.WorkbookMetadata;

@Configuration
class ApplicationBootMvc {

    @Bean(name = "cats-view")
    AnnotationDrivenExcelView catView(ApplicationContext applicationContext) {
        return new AnnotationDrivenExcelView(
                applicationContext,
                WorkbookMetadata.builder()
                        .workbook("小猫咪.xlsx")
                        .sheet(Cat.class, 1, "咪咪", "cats")
                        .sheet(Cat.class, 0, "小猫咪", "cats")
                        .build()
        );
    }

    @Autowired
    void config(BeanNameViewResolver viewResolver) {
        viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}
