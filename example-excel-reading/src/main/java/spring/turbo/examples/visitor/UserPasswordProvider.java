package spring.turbo.examples.visitor;

import org.springframework.core.io.Resource;
import spring.turbo.module.excel.ProcessPayload;
import spring.turbo.module.excel.reader.ExcelDiscriminator;
import spring.turbo.module.excel.reader.PasswordProvider;

public class UserPasswordProvider implements PasswordProvider {

    @Override
    public String getPassword(ExcelDiscriminator discriminator, Resource resource, ProcessPayload payload) {
        return "133810";
    }

}
