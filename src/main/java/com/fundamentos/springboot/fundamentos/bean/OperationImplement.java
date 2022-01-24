package com.fundamentos.springboot.fundamentos.bean;

public class OperationImplement implements Myoperation{
    @Override
    public int sum(int number1) {
        return number1+2;
    }
}
