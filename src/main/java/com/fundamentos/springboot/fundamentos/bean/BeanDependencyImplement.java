package com.fundamentos.springboot.fundamentos.bean;

public class BeanDependencyImplement implements MyBeanwithDependency{
    private Myoperation myoperation;

    public BeanDependencyImplement(Myoperation myoperation) {
        this.myoperation = myoperation;
    }

    @Override
    public void printWithDependency() {
        System.out.println(myoperation.sum(22));
        System.out.println("hello fom implementation with dependency");
    }
}
