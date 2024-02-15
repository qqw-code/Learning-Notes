package com.bjpowernode.java.annotation4;


public class OtherAnnotationTest {

    // 数组是大括号
    @OtherAnnotation(age = 25, email = {"zhangsan@123.com", "zhangsan@sohu.com"}, seasonArray = Season.WINTER)
    public void doSome(){

    }

    // 如果数组中只有1个元素：大括号可以省略。
    @OtherAnnotation(age = 25, email = "zhangsan@123.com", seasonArray = {Season.SPRING, Season.SUMMER})
    public void doOther(){

    }

}
