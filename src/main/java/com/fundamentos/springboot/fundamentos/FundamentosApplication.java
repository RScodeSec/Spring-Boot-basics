package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.BeanImplements;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanwithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanwithDependency myBeanwithDependency;

	FundamentosApplication(@Qualifier("componetTwoImplementation") ComponentDependency componentDependency, MyBean bean,
						   MyBeanwithDependency myBeanwithDependency){
		this.componentDependency = componentDependency;
		this.myBean = bean;
		this.myBeanwithDependency = myBeanwithDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);

	}

	@Override
	public void run(String... args) {
		componentDependency.greet();
		myBean.print();
		myBeanwithDependency.printWithDependency();

	}
}
