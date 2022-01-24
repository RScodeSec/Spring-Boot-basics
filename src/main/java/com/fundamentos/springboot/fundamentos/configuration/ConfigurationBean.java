package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new Bean2Implements();
    }

    @Bean
    public Myoperation beanOperationSum(){
        return new OperationImplement();
    }

    @Bean
    public MyBeanwithDependency beanOperationWithDependency(Myoperation myoperation){
        return new BeanDependencyImplement(myoperation);
    }
}
