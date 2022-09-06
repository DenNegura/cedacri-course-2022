package com.springboot.spboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Dependency Injection (Внедрение зависимостей)

@SpringBootApplication
public class SpbootApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);

		Database databaseFirst = context.getBean("database", Database.class);
		System.out.println(databaseFirst);

		Database databaseSecond = context.getBean("database", Database.class);
		System.out.println(databaseSecond);

		context.close();
	}

}
