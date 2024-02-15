package com.bjpowernode.javase.review;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
    1.1、每个集合对象的创建（new）
	1.2、向集合中添加元素
	1.3、从集合中取出某个元素
	1.4、遍历集合
	1.5、测试TreeSet集合中的元素是可排序的。
	1.6、测试TreeSet集合中存储的类型是自定义的。
	1.7、测试实现Comparable接口的方式
	1.8、测试实现Comparator接口的方式（最好测试以下匿名内部类的方式）
 */
public class TreeSetTest {
    public static void main(String[] args) {
        // 集合的创建（可以测试以下TreeSet集合中存储String、Integer的。这些类都是SUN写好的。）
        //TreeSet<Integer> ts = new TreeSet<>();

        // 编写比较器可以改变规则。
        TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // 自动拆箱
            }
        });

        // 添加元素
        ts.add(1);
        ts.add(100);
        ts.add(10);
        ts.add(10);
        ts.add(10);
        ts.add(10);
        ts.add(0);

        // 遍历（迭代器方式）
        Iterator<Integer> it = ts.iterator();
        while(it.hasNext()) {
            Integer i = it.next();
            System.out.println(i);
        }

        // 遍历（foreach）
        for(Integer x : ts){
            System.out.println(x);
        }

        // TreeSet集合中存储自定义类型
        TreeSet<A> atree = new TreeSet<>();

        atree.add(new A(100));
        atree.add(new A(200));
        atree.add(new A(500));
        atree.add(new A(300));
        atree.add(new A(400));
        atree.add(new A(1000));

        // 遍历
        for(A a : atree){
            System.out.println(a);
        }

        //TreeSet<B> btree = new TreeSet<>(new BComparator());
        // 匿名内部类方式。
        TreeSet<B> btree = new TreeSet<>(new Comparator<B>() {
            @Override
            public int compare(B o1, B o2) {
                return o1.i - o2.i;
            }
        });

        btree.add(new B(500));
        btree.add(new B(100));
        btree.add(new B(200));
        btree.add(new B(600));
        btree.add(new B(300));
        btree.add(new B(50));

        for(B b : btree){
            System.out.println(b);
        }
    }
}

// 第一种方式：实现Comparable接口
class A implements Comparable<A>{
    int i;

    public A(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "A{" +
                "i=" + i +
                '}';
    }

    @Override
    public int compareTo(A o) {
        //return this.i - o.i;
        return o.i - this.i;
    }
}

class B {
    int i;
    public B(int i){
        this.i = i;
    }

    @Override
    public String toString() {
        return "B{" +
                "i=" + i +
                '}';
    }
}

// 比较器
class BComparator implements Comparator<B> {

    @Override
    public int compare(B o1, B o2) {
        return o1.i - o2.i;
    }
}