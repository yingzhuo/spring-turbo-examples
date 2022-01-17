package spring.turbo.examples.controller;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import spring.turbo.examples.valueobject.Cat;
import spring.turbo.io.PathUtils;
import spring.turbo.module.excel.writer.WorkbookBuilder;
import spring.turbo.module.excel.writer.WorkbookIO;
import spring.turbo.module.security.webmvc.entity.AttachmentResponseEntity;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@AllArgsConstructor
class ExcelExportingController {

    private static final List<Cat> CATS = Arrays.asList(
            new Cat(1L, "米来", 8, new Date(), BigDecimal.TEN),
            new Cat(2L, "贵霜", 6, null, BigDecimal.ZERO)
    );

    private final ApplicationContext applicationContext;

    @GetMapping("/cats")
    public ResponseEntity<byte[]> cat() {
        final Workbook workbook = WorkbookBuilder.newInstance()
                .applicationContext(applicationContext)
                .sheet(Cat.class, 0, "猫儿", CATS)
                .build();

        // 生成Excel临时文件
        final Path tempFile = WorkbookIO.writeToTempFile(workbook, null, null);

        // 下载文件
        try {
            return AttachmentResponseEntity.builder()
                    .attachmentName("小猫咪.xlsx")
                    .mediaType(MediaType.APPLICATION_OCTET_STREAM)
                    .content(tempFile)
                    .build();
        } finally {
            // 从服务器上删除临时文件
            PathUtils.deleteQuietly(tempFile);
        }
    }

}
