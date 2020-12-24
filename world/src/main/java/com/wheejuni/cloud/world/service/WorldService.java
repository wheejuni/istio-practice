package com.wheejuni.cloud.world.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class WorldService {

    private final RestTemplate helloApiCaller;

    public WorldService(RestTemplate helloApiCaller) {
        this.helloApiCaller = helloApiCaller;
    }

    public String getHelloWorldString() {
        return helloApiCaller.getForObject("/v1/hello", String.class) + " world";
    }
}
