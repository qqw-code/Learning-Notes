package com.bjpowernode.javase.review;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/*
    1.1、每个集合对象的创建（new）
	1.2、向集合中添加元素
	1.3、从集合中取出某个元素
	1.4、遍历集合
	1.5、测试HashSet集合的特点：无序不可重复。
 */
public class HashSetTest {
    public static void main(String[] args) {
        // 创建集合对象
        HashSet<String> set = new HashSet<>();

        // 添加元素
        set.add("abc");
        set.add("def");
        set.add("king");

        // set集合中的元素不能通过下标取了。没有下标
        // 遍历集合（迭代器）
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // 遍历集合（foreach）
        for(String s : set){
            System.out.println(s);
        }

        set.add("king");
        set.add("king");
        set.add("king");
        System.out.println(set.size()); //3 （后面3个king都没有加进去。）

        set.add("1");
        set.add("10");
        set.add("2");

        for(String s : set){
            System.out.println("--->" + s);
        }

        // 创建Set集合，存储Student数据
        Set<Student> students = new HashSet<>();

        Student s1 = new Student(111, "zhangsan");
        Student s2 = new Student(222, "lisi");
        Student s3 = new Student(111, "zhangsan");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println(students.size()); // 2

        // 遍历
        for(Student stu : students){
            System.out.println(stu);
        }

    }
}

class Student {
    int no;
    String name;

    public Student() {
    }

    public Student(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return no == student.no &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }
}
