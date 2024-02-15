package com.bjpowernode.day24.homework;

/**
 * 坦克是一个武器，可移动，可攻击。
 */
public class Tank extends Weapon implements Moveable,Shootable{

    @Override
    public void move() {
        System.out.println("坦克移动");
    }

    @Override
    public void shoot() {
        System.out.println("坦克开炮");
    }
}
