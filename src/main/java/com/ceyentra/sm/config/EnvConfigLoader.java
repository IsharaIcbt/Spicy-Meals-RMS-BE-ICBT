package com.ceyentra.sm.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class EnvConfigLoader {
    public static void loadEnv() throws IOException {
        // Load .env file from the classpath
        Resource resource = new ClassPathResource(".env");
        File file = resource.getFile(); // Get the file from the resource
        Dotenv dotenv = Dotenv.configure().directory(file.getParent()).load(); // Use the parent directory
        System.setProperty("ACCESS_KEY", dotenv.get("ACCESS_KEY"));
        System.setProperty("SECRET_KEY", dotenv.get("SECRET_KEY"));
        System.setProperty("REGION", dotenv.get("REGION"));
        System.setProperty("BUCKET_NAME", dotenv.get("BUCKET_NAME"));
        System.setProperty("BUCKET_URL", dotenv.get("BUCKET_URL"));
        System.setProperty("DOMAIN", dotenv.get("DOMAIN"));
    }
}
