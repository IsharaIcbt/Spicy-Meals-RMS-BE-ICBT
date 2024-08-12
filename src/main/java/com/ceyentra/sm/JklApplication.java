package com.ceyentra.sm;

import com.ceyentra.sm.config.EnvConfigLoader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
public class JklApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JklApplication.class);
	}

	public static void main(String[] args) throws IOException {

		// Load .env file
		EnvConfigLoader.loadEnv();
		SpringApplication.run(JklApplication.class, args);
	}

}
