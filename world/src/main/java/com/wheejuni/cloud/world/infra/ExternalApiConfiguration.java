package com.wheejuni.cloud.world.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
public class ExternalApiConfiguration {

    @Bean
    public RestTemplate helloRestTemplate(Environment environment) {
        RestTemplateBuilder builder = new RestTemplateBuilder();

        return builder
            .defaultHeader("Content-Type", "application/json")
            .rootUri(createBaseUri(environment))
            .build();
    }

    private String createBaseUri(Environment environment) {
        return ProfileUriMatch.getByActiveProfile(environment).getEndpointUri();
    }

    @AllArgsConstructor
    @Getter
    enum ProfileUriMatch {

        LOCAL("http://localhost:8080"),
        ISTIO("");

        private String endpointUri;

        public static ProfileUriMatch getByActiveProfile(Environment environment) {
            return Arrays.asList(environment.getActiveProfiles()).contains("local") ?
                LOCAL : ISTIO;
        }
    }
}
