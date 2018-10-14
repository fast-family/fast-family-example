package com.fast.family.security.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 张顺
 * @version 1.0
 * @created 2018/10/14-16:02
 */
@Controller
public class MobileController {


    @GetMapping("/")
    @ResponseBody
    public String helloword(){
        return "手机验证通过";
    }


}
