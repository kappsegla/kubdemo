package com.example.kubdemo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Load {
    public static void main(String[] args) {

        Executor executor = Executors.newCachedThreadPool();

        executor.execute(Load::run);
        executor.execute(Load::run);
        executor.execute(Load::run);
        executor.execute(Load::run);
    }
    public static void run() {

        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                URI.create("http://localhost:8080/")).build();

        while (true) {
            try {
                var response = client.send(request, HttpResponse.BodyHandlers.ofString());
                System.out.println(response.body());
                Thread.sleep(1000);
            } catch (IOException e) {

            } catch (InterruptedException e) {

            }
        }
    }

}
