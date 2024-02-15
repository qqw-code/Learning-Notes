package com.bjpowernode.javase.collection;


import java.util.HashSet;
import java.util.Set;

public class MyClass {

    // 声明一个静态内部类
    private static class InnerClass {

        // 静态方法
        public static void m1(){
            System.out.println("静态内部类的m1方法执行");
        }

        // 实例方法
        public void m2(){
            System.out.println("静态内部类中的实例方法执行！");
        }

    }

    public static void main(String[] args) {

        // 类名叫做：MyClass.InnerClass
        MyClass.InnerClass.m1();

        // 创建静态内部类对象
        MyClass.InnerClass mi =  new MyClass.InnerClass();
        mi.m2();

        // 给一个Set集合
        // 该Set集合中存储的对象是：MyClass.InnerClass类型
        Set<MyClass.InnerClass> set = new HashSet<>();

        // 这个Set集合中存储的是字符串对象。
        Set<String> set2 = new HashSet<>();

        Set<MyMap.MyEntry<Integer, String>> set3 = new HashSet<>();
    }
}


class MyMap {
    public static class MyEntry<K,V> {

    }
}
