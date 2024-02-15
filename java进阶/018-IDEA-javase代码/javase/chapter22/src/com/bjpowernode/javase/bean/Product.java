package com.bjpowernode.javase.bean;

import java.util.Objects;

public class Product {
    private int no;
    private String name;

    public Product() {
    }

    public Product(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 重写hashCode+equals
    // 假设业务要求：商品编号相同，并且商品名字相同，表示同一个商品。
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return no == product.no &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, name);
    }
}
