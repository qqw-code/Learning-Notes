package com.bjpowernode.javase.exception.homework;

public class Test {
    public static void main(String[] args) {
        // 创建UserService对象
        UserService userService = new UserService();
        // 用户名和密码就不再从控制台接收了
        try {
            userService.register("jack", "123");
        } catch (IllegalNameException e) {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
