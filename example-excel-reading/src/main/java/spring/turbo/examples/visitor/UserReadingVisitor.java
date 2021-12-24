package spring.turbo.examples.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import spring.turbo.examples.valueobject.User;
import spring.turbo.module.excel.ExcelType;
import spring.turbo.module.excel.ProcessPayload;
import spring.turbo.module.excel.batch.Batch;
import spring.turbo.module.excel.reader.annotation.*;
import spring.turbo.module.excel.visitor.BatchVisitor;
import spring.turbo.module.excel.visitor.ProcessingContext;
import spring.turbo.util.StringPool;

import java.util.Locale;
import java.util.stream.Collectors;

@BatchProcessor(discriminatorValue = "USER", valueObjectType = User.class)
@Password("133810")
@IncludeSheetSet(sheetIndexes = 0)
@ExcludeRowSet(sheetIndex = 0, rowIndexes = {1})
@Header(sheetIndex = 0, rowIndex = 0)
@ColumnBasedCellParser(sheetIndex = 0, columnIndex = 1, type = MyCellParser.class)
@Type(ExcelType.XSSF)
@Filter(type = UserFilter.class)
public class UserReadingVisitor implements BatchVisitor<User> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public void onValidValueObject(ProcessingContext context, ProcessPayload payload, Batch<User> batch) {
        batch.forEach(System.out::println);
    }

    @Override
    public void onInvalidValueObject(ProcessingContext context, ProcessPayload payload, Object vo, BindingResult bindingResult) {
        String msg = bindingResult.getAllErrors()
                .stream()
                .limit(2)
                .map(e -> messageSource.getMessage(e, Locale.getDefault()))
                .sorted()
                .collect(Collectors.joining(StringPool.COMMA));

        System.out.println(msg);
    }

}
