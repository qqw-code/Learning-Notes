package com.bjpowernode.javase.collection;

import java.util.HashSet;
import java.util.Set;

/*
HashSet集合：
    无序不可重复。
 */
public class HashSetTest01 {
    public static void main(String[] args) {
        // 演示一下HashSet集合特点
        Set<String> strs = new HashSet<>();

        // 添加元素
        strs.add("hello3");
        strs.add("hello4");
        strs.add("hello1");
        strs.add("hello2");
        strs.add("hello3");
        strs.add("hello3");
        strs.add("hello3");
        strs.add("hello3");

        // 遍历
        /*
        hello1
        hello4
        hello2
        hello3
        1、存储时顺序和取出的顺序不同。
        2、不可重复。
        3、放到HashSet集合中的元素实际上是放到HashMap集合的key部分了。
         */
        for(String s : strs){
            System.out.println(s);
        }
    }
}
