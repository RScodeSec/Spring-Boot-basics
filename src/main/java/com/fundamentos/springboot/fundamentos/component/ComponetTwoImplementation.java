package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponetTwoImplementation implements ComponentDependency {
    @Override
    public void greet() {
        System.out.println("hello miss of implement two");
    }
}
