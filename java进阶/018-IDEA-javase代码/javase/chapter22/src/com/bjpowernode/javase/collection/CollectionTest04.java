package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Collection;

/*
深入Collection集合的contains方法：
    boolean contains(Object o)
        判断集合中是否包含某个对象o
        如果包含返回true， 如果不包含返回false。

    contains方法是用来判断集合中是否包含某个元素的方法，
    那么它在底层是怎么判断集合中是否包含某个元素的呢？
        调用了equals方法进行比对。
        equals方法返回true，就表示包含这个元素。
 */
public class CollectionTest04 {
    public static void main(String[] args) {
        // 创建集合对象
        Collection c = new ArrayList();

        // 向集合中存储元素
        String s1 = new String("abc"); // s1 = 0x1111
        c.add(s1); // 放进去了一个"abc"

        String s2 = new String("def"); // s2 = 0x2222
        c.add(s2);

        // 集合中元素的个数
        System.out.println("元素的个数是：" + c.size()); // 2

        // 新建的对象String
        String x = new String("abc"); // x = 0x5555
        // c集合中是否包含x？结果猜测一下是true还是false？
        System.out.println(c.contains(x)); //判断集合中是否存在"abc" true
    }
}
