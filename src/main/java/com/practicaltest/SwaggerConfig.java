package com.practicaltest;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private Contact contact() {
        return new Contact(
                "Caio Oliveira",
                "http://www.github.com/caio01",
                "caioinacio00@gmail.com");
    }
    private ApiInfoBuilder infoApi() {

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Shipping Price API");
        apiInfoBuilder.description("Practical Test - Springboot Rest API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.license("Licença - Gratuito para Uso nâo comercial");
        apiInfoBuilder.licenseUrl("https://github.com/caio01/ShippingPriceAPI/blob/master/LICENSE");
        apiInfoBuilder.contact(this.contact());

        return apiInfoBuilder;

    }
    @Bean
    public Docket detailApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.practicaltest.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.infoApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;
    }
}