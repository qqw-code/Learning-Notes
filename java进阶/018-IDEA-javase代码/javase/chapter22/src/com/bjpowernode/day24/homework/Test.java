package com.bjpowernode.day24.homework;

public class Test {
    public static void main(String[] args) {
        // 构建一个军队
        Army army = new Army(4); // 军队只有4个武器。
        // 创建武器对象
        Fighter fighter = new Fighter();
        Fighter fighter2 = new Fighter();
        Tank tank = new Tank();
        WuZiFeiJi wuZiFeiJi = new WuZiFeiJi();
        GaoShePao gaoShePao = new GaoShePao();

        // 添加武器
        try {
            army.addWeapon(fighter);
            army.addWeapon(tank);
            army.addWeapon(wuZiFeiJi);
            army.addWeapon(gaoShePao);
            army.addWeapon(fighter2);
        } catch (AddWeaponException e) {
            System.out.println(e.getMessage());
        }

        // 让所有可移动的移动
        army.moveAll();

        // 让所有可攻击的攻击
        army.attackAll();

        // 这是new一个异常对象。没有手动抛异常，它就是一个普通的java类。
        // 就像User类一样。没有区别。
        /*AddWeaponException e = new AddWeaponException("武器数量已达到上限！");
        System.out.println(e.getMessage());*/
    }
}
