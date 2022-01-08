package spring.turbo.examples.valueobject;

import lombok.*;
import spring.turbo.bean.valueobject.Alias;
import spring.turbo.module.excel.writer.annotation.InlineHeader;
import spring.turbo.module.excel.writer.annotation.Offset;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Offset(-1)
@InlineHeader("名字 年龄    数据日期,      售价,   ")
public class Cat implements Serializable {

    private Long id;

    @Alias(value = "名字")
    private String name;

    @Alias(from = "年龄")
    private int age;

    @Alias(from = "数据日期")
    private Date dataDate;

    @Alias(from = "售价")
    private BigDecimal price;

}
