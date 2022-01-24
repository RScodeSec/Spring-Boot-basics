package com.fundamentos.springboot.fundamentos.bean;

public class BeanImplements implements MyBean{

    @Override
    public void print() {
        System.out.println("hello of my own implementation");
    }
}
