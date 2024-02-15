package com.bjpowernode.java.annotation3;

// 报错了。因为属性名是name，不能省略。
//@OtherAnnotation("test")
public class OtherAnnotationTest {

    // 正确的。
    @OtherAnnotation(name = "test")
    public void doSome(){

    }
}
