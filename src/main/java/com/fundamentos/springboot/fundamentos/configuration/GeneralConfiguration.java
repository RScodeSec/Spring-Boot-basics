package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithPropertiesImplementation;
import com.fundamentos.springboot.fundamentos.pojo.UserPOJO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:conection.properties")
@EnableConfigurationProperties(UserPOJO.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.lastName}")
    private String lastName;

    /**
     * conection properties
     */
    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${driver}")
    private String driver;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;


    /*@Value("${value.random}")
    private int myValue;*/

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplementation(name, lastName);
    }
    /**
     * database
     */
    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(jdbcUrl);
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();

    }

}
