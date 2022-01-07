package spring.turbo.examples.valueobject;

import lombok.*;
import spring.turbo.bean.valueobject.Alias;
import spring.turbo.module.excel.writer.annotation.Filename;
import spring.turbo.module.excel.writer.annotation.GlobalDatePattern;
import spring.turbo.module.excel.writer.annotation.Header;
import spring.turbo.module.excel.writer.annotation.HeaderStyle;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Filename("小猫咪.xlsx")
@Header({"名字", "年龄", "数据日期"})
@GlobalDatePattern("yyyy-MM-dd")
@HeaderStyle(type = MyHeaderStyleProvider.class)
public class Cat implements Serializable {

    private Long id;

    @Alias(value = "名字")
    private String name;

    @Alias(from = "年龄")
    private int age;

    @Alias(from = "数据日期")
    private Date dataDate;

}
