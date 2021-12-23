package spring.turbo.examples.visitor;

import org.apache.poi.ss.usermodel.Cell;
import org.springframework.stereotype.Component;
import spring.turbo.module.excel.cellparser.DefaultCellParser;

@Component
public class MyCellParser extends DefaultCellParser {

    @Override
    public String convert(Cell cell) {
        return super.convert(cell);
    }

}
