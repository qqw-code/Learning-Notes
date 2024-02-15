package com.bjpowernode.java.service;

/**
 * 用户业务类
 */
public class UserService {

    /**
     * 登录方法
     * @param name 用户名
     * @param password 密码
     * @return true表示登录成功，false表示登录失败！
     */
    public boolean login(String name,String password){
        if("admin".equals(name) && "123".equals(password)){
            return true;
        }
        return false;
    }

    // 可能还有一个同名login方法
    // java中怎么区分一个方法，依靠方法名和参数列表。
    public void login(int i){

    }

    /**
     * 退出系统的方法
     */
    public void logout(){
        System.out.println("系统已经安全退出！");
    }
}
