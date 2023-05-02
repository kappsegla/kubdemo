package com.example.kubdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

@RestController
public class KubeController {

    private ClientConfig config;

    public KubeController(ClientConfig config) {
        this.config = config;
    }

    @GetMapping("/")
    public String index() throws UnknownHostException {

        var i = Math.random();
        for (int j = 0; j < 10000000; j++) {
            i+= Math.sqrt(i);
        }
        String hostname = InetAddress.getLocalHost().getHostName();
        return config.getMessage() + " " + hostname + " " + i;
    }

    @GetMapping("/showheaders")
    public String showHeaders(@RequestHeader Map<String, String> headers){
        StringBuilder builder = new StringBuilder();
        headers.forEach((key, value) -> {
            builder.append(String.format("Header '%s' = %s", key, value));
            builder.append("\n");
        });
        return builder.toString();
    }
}
