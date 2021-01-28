package com.example.springbootdynamicquartz.swagger;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.oas.annotations.EnableOpenApi;

@Configuration
@EnableOpenApi
//@ConditionalOnProperty(name = "spring.profile.active",havingValue = "dev")
public class SwaggerConfig {
}