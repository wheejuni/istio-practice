package com.wheejuni.cloud.helloworld.application;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloWorldService {

    @Value("{worldapi.uri}")
    private String uri;

    public String getHelloWorldString() {
        if(StringUtils.hasText(uri)) {
            RestTemplate restTemplate = new RestTemplateBuilder().rootUri(uri).build();

            return restTemplate.getForEntity("", String.class).getBody();
        }
    }

}
