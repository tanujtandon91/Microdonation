package com.microdonation.microdonation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
        MicrodonationApplication.class,
        Jsr310JpaConverters.class
})
@EnableSwagger2
public class MicrodonationApplication {
    @PostConstruct
    void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    public static void main(String[] args) {
        SpringApplication.run(MicrodonationApplication.class, args);
    }

}
