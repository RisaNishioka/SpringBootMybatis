package com.trainingself;


import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleSpringBootStarter {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SimpleSpringBootStarter.class, args);

//        try (InputStream in = Main.class.getResourceAsStream("/mybatis-config.xml")) {
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//            try (SqlSession session = factory.openSession()) {
//
//            }
//        }
	}
}
