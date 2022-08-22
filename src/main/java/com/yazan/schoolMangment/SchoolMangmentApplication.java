package com.yazan.schoolMangment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@EnableEncryptableProperties
public class SchoolMangmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolMangmentApplication.class, args);
	}

}
