package spring.turbo.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import spring.turbo.examples.valueobject.Cat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ExcelExportingController {

    private final List<Cat> cats = Arrays.asList(
            new Cat(1L, "米来", 8, new Date()),
            new Cat(2L, "贵霜", 6, new Date())
    );

    @GetMapping("/cats")
    public ModelAndView cat() {
        ModelAndView mv = new ModelAndView("cats-view");
        mv.addObject("cats", cats);
        return mv;
    }

}
