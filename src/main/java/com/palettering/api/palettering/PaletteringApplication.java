package com.palettering.api.palettering;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PaletteringApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaletteringApplication.class, args);
    }

}
