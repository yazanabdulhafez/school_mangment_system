package com.yazan.schoolMangment;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SchoolMangmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolMangmentApplication.class, args);
	}

}
