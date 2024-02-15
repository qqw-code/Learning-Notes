package com.bjpowernode.javase.collection;

/*
自定义泛型可以吗？可以
    自定义泛型的时候，<> 尖括号中的是一个标识符，随便写。
    java源代码中经常出现的是：
        <E>和<T>
    E是Element单词首字母。
    T是Type单词首字母。
 */
public class GenericTest03<标识符随便写> {

    public void doSome(标识符随便写 o){
        System.out.println(o);
    }

    public static void main(String[] args) {

        // new对象的时候指定了泛型是：String类型
        GenericTest03<String> gt = new GenericTest03<>();

        // 类型不匹配
        //gt.doSome(100);

        gt.doSome("abc");

        // =============================================================
        GenericTest03<Integer> gt2 = new GenericTest03<>();
        gt2.doSome(100);

        // 类型不匹配
        //gt2.doSome("abc");

        MyIterator<String> mi = new MyIterator<>();
        String s1 = mi.get();

        MyIterator<Animal> mi2 = new MyIterator<>();
        Animal a = mi2.get();

        // 不用泛型就是Object类型。
        /*GenericTest03 gt3 = new GenericTest03();
        gt3.doSome(new Object());*/
    }
}

class MyIterator<T> {
    public T get(){
        return null;
    }
}