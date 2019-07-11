package com.example.demo.example.publish;

import com.example.demo.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @ClassName UnsafePublish
 * @Description 不安全发布对象的例子
 * @Author miaoxu
 * @Date 2019/7/11 22:43
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] stares = {"a", "b", "c"};

    public String[] getStares() {
        return stares;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStares()));

        unsafePublish.getStares()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStares()));
    }
}
