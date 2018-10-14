package com.fast.family.security.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/10/14-13:15
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @PostMapping("/index")
    @ResponseBody
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


}
