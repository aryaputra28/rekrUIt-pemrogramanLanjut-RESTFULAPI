package com.advprog2021.b15.rekrUIt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    private String helloWorld() {
        return "Hello World!";
    }

}
