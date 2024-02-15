package com.bjpowernode.javase.exception.homework;
/*
用户业务类，处理用户相关的业务：例如登录、注册等功能。
 */
public class UserService {

    /**
     * 用户注册
     * @param username 用户名
     * @param password 密码
     * @throws IllegalNameException 当用户名为null，或者用户名长度小于6，或者长度大于14，会出现该异常！
     */
    public void register(String username, String password) throws IllegalNameException {
        /*
        引用等于null的这个判断最好放到所有条件的最前面。
         */
        /*if(username == null || username.length() < 6 || username.length() > 14){
        }*/

        /*
        再分享一个经验：username == null 不如写成 null == username
        "abc".equals(username) 比 username.equals("abc") 好。
         */
        /*if(null == username || username.length() < 6 || username.length() > 14){
        }*/

        if(null == username || username.length() < 6 || username.length() > 14) {
            /*System.out.println("用户名不合法，长度必须在[6-14]之间");
            return;*/
            throw new IllegalNameException("用户名不合法，长度必须在[6-14]之间");
        }
        // 程序能够执行到此处说明，用户名合法
        System.out.println("注册成功，欢迎["+username+"]");
    }
}
