package cn.sspu.moch.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IndexController {

    public IndexController() {

    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){
        return "index";
    }
}
