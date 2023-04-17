package com.example.kubdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class KubeController {

    @GetMapping("/")
    public String index() throws UnknownHostException {

        var i = Math.random();
        for (int j = 0; j < 10000000; j++) {
            i+= Math.sqrt(i);
        }
        String hostname = InetAddress.getLocalHost().getHostName();
        return "Hello World v2 from " + hostname + " " + i;
    }
}
