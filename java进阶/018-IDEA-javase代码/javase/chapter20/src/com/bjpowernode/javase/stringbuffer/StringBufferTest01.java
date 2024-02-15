package com.bjpowernode.javase.stringbuffer;

/**
 * 思考：我们在实际的开发中，如果需要进行字符串的频繁拼接，会有什么问题？
 *      因为java中的字符串是不可变的，每一次拼接都会产生新字符串。
 *      这样会占用大量的方法区内存。造成内存空间的浪费。
 *          String s = "abc";
 *          s += "hello";
 *          就以上两行代码，就导致在方法区字符串常量池当中创建了3个对象：
 *              "abc"
 *              "hello"
 *              "abchello"
 */
public class StringBufferTest01 {
    public static void main(String[] args) {
        String s = "";
        // 这样做会给java的方法区字符串常量池带来很大的压力。
        for(int i = 0; i < 100; i++){
            //s += i;
            s = s + i;
            System.out.println(s);
        }
    }
}
