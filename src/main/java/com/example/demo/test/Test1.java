package com.example.demo.test;

import com.example.demo.test.People;
import com.example.demo.test.PeopleImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName Test1
 * @Description TODO
 * @Author miaoxu
 * @Date 2019/7/11 9:17
 * @Version 1.0
 **/
@Configuration
public class Test1
{

    @Bean
    public People people()
    {
        return new PeopleImpl();
    }

}
