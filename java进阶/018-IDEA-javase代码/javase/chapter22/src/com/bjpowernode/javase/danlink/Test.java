package com.bjpowernode.javase.danlink;

public class Test {
    public static void main(String[] args) {
        // 创建了一个集合对象
        Link link = new Link();

        // 往集合中添加元素
        link.add("abc");
        link.add("def");
        link.add("xyz");

        // 获取元素个数
        System.out.println(link.size());

    }
}
