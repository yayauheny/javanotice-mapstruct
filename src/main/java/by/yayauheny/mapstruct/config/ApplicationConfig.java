package by.yayauheny.mapstruct.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ApplicationConfig {

    @Bean
    public Random randomGenerator() {
        return new Random(System.currentTimeMillis() / 72);
    }
}
