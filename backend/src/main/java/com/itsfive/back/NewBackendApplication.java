package com.itsfive.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itsfive.back.property.FileStorageProperties;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = { 
		NewBackendApplication.class,
		Jsr310JpaConverters.class 
})
@EnableConfigurationProperties({
    FileStorageProperties.class
})
public class NewBackendApplication {
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(NewBackendApplication.class, args);
	}

}
