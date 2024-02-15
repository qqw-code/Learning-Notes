package com.bjpowernode.java.annotation3;

/*
如果一个注解的属性的名字是value，并且只有一个属性的话，在使用的时候，该属性名可以省略。
 */
public class MyAnnotationTest {

    // 报错原因：没有指定属性的值。
    /*@MyAnnotation
    public void doSome(){

    }*/

    @MyAnnotation(value = "hehe")
    public void doSome(){

    }

    @MyAnnotation("haha")
    public void doOther(){

    }
}
