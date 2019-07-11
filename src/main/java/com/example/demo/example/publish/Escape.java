package com.example.demo.example.publish;

import com.example.demo.annotations.NotRecommend;
import com.example.demo.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName Escape
 * @Description 对象发布逸出的例子
 * @Author miaoxu
 * @Date 2019/7/11 22:46
 * @Version 1.0
 **/
@Slf4j
@NotRecommend
@NotThreadSafe
public class Escape {
    private int thisCanbeEscape = 0;

    public Escape()
    {
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass()
        {
            log.info("{}", Escape.this.thisCanbeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
