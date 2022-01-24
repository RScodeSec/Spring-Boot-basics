package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithPropertiesImplementation;
import com.fundamentos.springboot.fundamentos.pojo.UserPOJO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UserPOJO.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    /*@Value("${value.random}")
    private int myValue;*/

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplementation(name, lastName);
    }
}
