package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/7/11 9:05
 * @Version 1.0
 **/
@Controller
@Slf4j
public class TestController {

//    @GetMapping
//    public void getList(@RequestParam  HttpServletRequest httpServletRequest,@RequestParam Htt)
//        @Bean(name = "people")
//    public People people()
//        {
//            return new People();
//        }


    @RequestMapping("/test")
    @ResponseBody
    public String test()
    {
        return "test";
    }
}
