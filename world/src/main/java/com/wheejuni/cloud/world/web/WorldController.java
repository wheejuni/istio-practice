package com.wheejuni.cloud.world.web;

import com.wheejuni.cloud.world.service.WorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    @Autowired
    private WorldService worldService;

    @GetMapping("/v1/world")
    public String getHelloWorld() {
        return worldService.getHelloWorldString();
    }
}
