package com.example.demo.example.immutable;

import com.example.demo.annotations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @ClassName ImmutableExample1
 * @Description 测试final修饰的数值型变量，引用型变量
 * @Author miaoxu
 * @Date 2019/7/26 9:57
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private static final Integer a = 1;
    private static final String b = "2";
    private static final Map<Integer, Integer> map = Maps.newHashMap();
    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 2);
    }

    public static void main(String[] args) {
//        a = 1;
//        b = "2" 不可修改
//        map = Maps.newHashMap();
        map.put(3, 3); // 引用不可修改，内容可以
        log.info("{}", map.get(3));

    }
}
