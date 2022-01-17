package spring.turbo.examples.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import spring.turbo.bean.valueobject.Batch;
import spring.turbo.bean.valueobject.BindingResultUtils;
import spring.turbo.bean.valueobject.ProcessPayload;
import spring.turbo.examples.valueobject.User;
import spring.turbo.module.excel.reader.annotation.*;
import spring.turbo.module.excel.visitor.BatchVisitor;
import spring.turbo.module.excel.visitor.ProcessingContext;

@BatchProcessor(discriminatorValue = "USER", valueObjectType = User.class)
@Password("133810")
@IncludeSheetSet(sheetIndexes = 0)
@ExcludeRowSet(sheetIndex = 0, rowIndexes = {1})
@Header(sheetIndex = 0, rowIndex = 0)
public class UserReadingVisitor implements BatchVisitor<User> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onValidValueObject(ProcessingContext context, ProcessPayload payload, Batch<User> batch) {
        batch.forEach(System.out::println);
    }

    @Override
    public void onInvalidValueObject(ProcessingContext context, ProcessPayload payload, Object vo, BindingResult bindingResult) {
        System.out.println(BindingResultUtils.getJoinedDefaultErrorMessages(bindingResult));
    }

}
