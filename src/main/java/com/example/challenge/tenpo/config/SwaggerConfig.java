package com.example.challenge.tenpo.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
    public static final String BASE_PACKAGE = "com.example.challenge.tenpo.web.controller";
    private static final List<String> DEFAULT_PRODUCES_CONSUMES = Arrays.asList("application/json");
    public static final String AUTHORIZATION_HEADER = "Authorization";
    // https://stackoverflow.com/questions/27427414/java-regex-matches-anything-except-three-specific-string
    public static final String DEFAULT_INCLUDE_PATTERN = "/(?!auth).*";

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2) //
                .apiInfo(apiInfo()) //
                .tags( //
                        new Tag("Security", "Security endpoints", 0), //
                        new Tag("Test", "Test endpoints", 1) //
                ) //
                .produces(new HashSet<>(DEFAULT_PRODUCES_CONSUMES)) //
                .consumes(new HashSet<>(DEFAULT_PRODUCES_CONSUMES)) //
                .useDefaultResponseMessages(false) //
                .securitySchemes(Arrays.asList(apiKey())) //
                .select() //
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE)) //
                .paths(PathSelectors.any()) //
                .build();
    }

    private ApiInfo apiInfo() {
        var contact = new Contact("Manuel Eguiluz", "https://meguiluzortiz.github.io/", "eguiluz.manuel@gmail.com");
        var builder = new ApiInfoBuilder() //
                .title("Api Documentation") //
                .description("Test API Documentation") //
                .version("1.0") //
                .termsOfServiceUrl("urn:tos") //
                .contact(contact) //
                .license("Apache 2.0") //
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0") //
                .extensions(new ArrayList<>());

        return builder.build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }

}
