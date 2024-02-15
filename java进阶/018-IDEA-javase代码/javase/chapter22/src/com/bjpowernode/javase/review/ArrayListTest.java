package com.bjpowernode.javase.review;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
    1.1、每个集合对象的创建（new）
	1.2、向集合中添加元素
	1.3、从集合中取出某个元素
	1.4、遍历集合
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // 创建集合对象
        //ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
        // 添加元素
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        // 从集合中取出某个元素
        // List集合有下标
        String firstElt = list.get(0);
        System.out.println(firstElt);
        // 遍历（下标方式）
        for(int i = 0; i < list.size(); i++){
            String elt = list.get(i);
            System.out.println(elt);
        }
        // 遍历（迭代器方式，这个是通用的，所有Collection都能用）
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // while循环修改为for循环
        /*for(Iterator<String> it2 = list.iterator(); it2.hasNext(); ){
            System.out.println("====>" + it2.next());
        }*/

        // 遍历（foreach方式）
        for(String s : list){
            System.out.println(s);
        }
    }
}
