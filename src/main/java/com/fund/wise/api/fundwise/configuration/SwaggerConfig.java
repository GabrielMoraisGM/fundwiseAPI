package com.fund.wise.api.fundwise.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("fundwise-public")
                .pathsToMatch("/api/ativo/**", "/api/operacao/**")
                .build();
    }
}
