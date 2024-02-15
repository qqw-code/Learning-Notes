package com.bjpowernode.javase.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
JDK之后引入了：自动类型推断机制。（又称为钻石表达式）
 */
public class GenericTest02 {
    public static void main(String[] args) {

        // ArrayList<这里的类型会自动推断>()，前提是JDK8之后才允许。
        // 自动类型推断，钻石表达式！
        List<Animal> myList = new ArrayList<>();

        myList.add(new Animal());
        myList.add(new Cat());
        myList.add(new Bird());

        // 遍历
        Iterator<Animal> it = myList.iterator();
        while(it.hasNext()){
            Animal a = it.next();
            a.move();
        }

        List<String> strList = new ArrayList<>();

        // 类型不匹配。
        //strList.add(new Cat());
        strList.add("http://www.126.com");
        strList.add("http://www.baidu.com");
        strList.add("http://www.bjpowernode.com");

        // 类型不匹配。
        //strList.add(123);

        //System.out.println(strList.size());

        // 遍历
        Iterator<String> it2 = strList.iterator();
        while(it2.hasNext()){
            // 如果没有使用泛型
            /*
            Object obj = it2.next();
            if(obj instanceof String){
                String ss = (String)obj;
                ss.substring(7);
            }
             */
            // 直接通过迭代器获取了String类型的数据
            String s = it2.next();
            // 直接调用String类的substring方法截取字符串。
            String newString = s.substring(7);
            System.out.println(newString);
        }
    }
}














