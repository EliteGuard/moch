package cn.sspu.moch.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class IndexRestController {

    public IndexRestController() {

    }

    @RequestMapping({"/api"})
    public String getIndexPage(){

        return "Welcome to API";
    }
}
