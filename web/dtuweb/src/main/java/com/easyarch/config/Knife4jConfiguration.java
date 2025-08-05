package com.easyarch.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI().info(
                new Info()
                        .title("DTU配置平台")
                        .version("1.0")
                        .description("DTU配置平台API"));
    }


    @Bean
    public GroupedOpenApi loginAPI() {

        return GroupedOpenApi.builder().group("DTU配置平台").
                pathsToMatch(
                        "/api/dtu/**"
                ).
                build();
    }



}