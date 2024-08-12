package com.ceyentra.sm.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EnvConfigLoader {
    public static void loadEnv() throws IOException {
        Resource resource = new ClassPathResource(".env");
        Dotenv dotenv = Dotenv.configure().directory(resource.getURI().getPath()).load();

        System.setProperty("ACCESS_KEY", dotenv.get("ACCESS_KEY"));
        System.setProperty("SECRET_KEY", dotenv.get("SECRET_KEY"));
        System.setProperty("REGION", dotenv.get("REGION"));
        System.setProperty("BUCKET_NAME", dotenv.get("BUCKET_NAME"));
        System.setProperty("BUCKET_URL", dotenv.get("BUCKET_URL"));
        System.setProperty("DOMAIN", dotenv.get("DOMAIN"));
    }
}
