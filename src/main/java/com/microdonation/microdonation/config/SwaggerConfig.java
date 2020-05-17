package com.microdonation.microdonation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@PropertySource("classpath:swagger.properties")
@Configuration
@ComponentScan(basePackages = {"com.microdonation.microdonation"})
public class SwaggerConfig {

    public static final Contact DEFAULT_CONTACT = new Contact("Mihir Barve", "", "mihir.barve@live.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("microdonation",
            "Service for Microdonation",
            "v1",
            "2 years",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<>());

    private static final Set<String> DEFAULT_PRODUCES_CONSUMES = new HashSet<>(Arrays.asList("application/json"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.microdonation.microdonation.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_CONSUMES)
                .consumes(DEFAULT_PRODUCES_CONSUMES);
    }
}
