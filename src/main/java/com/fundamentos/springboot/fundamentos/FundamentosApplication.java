package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.BeanImplements;
import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanwithDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPOJO;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;

	private MyBeanwithDependency myBeanwithDependency;

	private MyBeanWithProperties myBeanWithProperties;

	private UserPOJO userPOJO;
	private UserRepository userRepository;


	FundamentosApplication(@Qualifier("componetTwoImplementation") ComponentDependency componentDependency, MyBean bean,
						   MyBeanwithDependency myBeanwithDependency, MyBeanWithProperties myBeanWithProperties,
						   UserPOJO userPOJO, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = bean;
		this.myBeanwithDependency = myBeanwithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPOJO = userPOJO;
		this.userRepository = userRepository;

	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);

	}

	@Override
	public void run(String... args) {
		//previousClasses();
		saveUserInDatabase();
		getInformationJpaFromUser();
	}

	private void getInformationJpaFromUser(){
		System.out.println(userRepository.findUserEmail("len@gmail.com")
				.orElseThrow(()->new RuntimeException("not found user")));


		userRepository.findAndSort("Roger", Sort.by("id").descending())
				.stream()
				.forEach(user -> System.out.println("the users: "+user));

		userRepository.findByName("Roger")
				.stream()
				.forEach(user-> System.out.println("find by qery method "+user.toString()));

		userRepository.findByNameLike("%e%")
				.stream()
				.forEach(user -> System.out.println("With operator like "+user));

		System.out.println("::::::::::::::::::::");

		System.out.println(userRepository.getAllByBirthDateAndEmail(LocalDate.of(2022,01,23),"len@gmail.com")
				.orElseThrow(()->new RuntimeException("not found user")));

	}

	private void saveUserInDatabase(){
		User user1 = new User("Roger","aso@gmail.com", LocalDate.of(2022,01,24));
		User user2 = new User("Kem","len@gmail.com", LocalDate.of(2022,01,23));
		List<User>userList = Arrays.asList(user1,user2);
		userList.stream().forEach(userRepository::save);

	}

	private void previousClasses(){
		componentDependency.greet();
		myBean.print();
		myBeanwithDependency.printWithDependency();
		System.out.println(myBeanWithProperties.function());
		userPOJO.setAge(23);
		System.out.println(userPOJO.getAge());

	}
}
