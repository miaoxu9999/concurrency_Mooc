package com.example.demo.example.immutable;

import com.example.demo.annotations.NotThreadSafe;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Map;

/**
 * @ClassName ImmutableExample1
 * @Description 测试 Collections.unmodifiableMap
 * 和final不同，内容不允许修改,引用可以修改
 * @Author miaoxu
 * @Date 2019/7/26 9:57
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class ImmutableExample2 {

    private static  Map<Integer, Integer> map = Maps.newHashMap();
    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 2);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map = Maps.newHashMap();
//        map.put(3, 3);
        log.info("{}", map.get(3));

    }
}
