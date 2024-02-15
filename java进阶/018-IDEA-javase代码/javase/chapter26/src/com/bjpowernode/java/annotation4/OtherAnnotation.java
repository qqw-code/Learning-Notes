package com.bjpowernode.java.annotation4;

public @interface OtherAnnotation {
    /*
    年龄属性
     */
    int age();

    /*
    邮箱地址属性，支持多个
     */
    String[] email();

    /**
     * 季节数组，Season是枚举类型
     * @return
     */
    Season[] seasonArray();
}
