package com.bjpowernode.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask; // JUC包下的，属于java的并发包，老JDK中没有这个包。新特性。

/*
实现线程的第三种方式：
    实现Callable接口
    这种方式的优点：可以获取到线程的执行结果。
    这种方式的缺点：效率比较低，在获取t线程执行结果的时候，当前线程受阻塞，效率较低。
 */
public class ThreadTest15 {
    public static void main(String[] args) throws Exception {
            FutureTask task =  new FutureTask(new Callable() {
                @Override
                public Object call() throws Exception {
                    System.out.println("call method begin");
                    Thread.sleep(1000*10);
                    System.out.println("call method end");

                    return 300;
                }
            });

            Thread t = new Thread(task);
            t.start();
            Object obj=task.get();
            System.out.println(obj);
        System.out.println("main thread end");
    }
}
