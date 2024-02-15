package com.baidu;

public class Test01 {
    public static void main(String[] args) {
        MyMath mm = new MyMath();
        // IDEA工具中纠正错误的快捷键：alt + 回车
        /*mm.mySum(new Compute(){
            public int sum(int a, int b) {
                return a + b;
            }
        }, 100, 200);*/

        mm.mySum(new ComputeImpl(), 200, 300);
    }
}
