package com.example.demo.example.immutable;

import com.example.demo.annotations.NotThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @ClassName ImmutableExample1
 * @Description google guava 包中的 ImmutableList中内容不可变
 * 内容和引用都不可变(必须是声明为Immutablexxx)
 * @Author miaoxu
 * @Date 2019/7/26 9:57
 * @Version 1.0
 **/
@Slf4j
@NotThreadSafe
public class ImmutableExample3 {

    private static  final ImmutableList<Integer> list= ImmutableList.of(1, 2,3);

    private static  Set<Integer> set = ImmutableSet.copyOf(list);

    private static final ImmutableMap<Integer, Integer> map1 = ImmutableMap.of(1, 2, 3,4);

    private static final ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder().put(1, 2).put(3, 4).build();


    public static void main(String[] args) {
//        list.add(2);
//        list = ImmutableList.copyOf(1, 2);
        set = new HashSet<>();
        System.out.println(set.size());
//        map1.put(3, 3);
        log.info("{}", map1.get(3));

    }
}
