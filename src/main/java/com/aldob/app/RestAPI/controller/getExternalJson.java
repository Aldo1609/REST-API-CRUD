package com.aldob.app.RestAPI.controller;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/api")
public class getExternalJson {

    @GetMapping(value = "/comments")
    public String getComments(){

        int timeout = 5000;
        ClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        ((SimpleClientHttpRequestFactory) factory).setConnectTimeout(timeout);
        ((SimpleClientHttpRequestFactory) factory).setReadTimeout(timeout);
        RestTemplate restTemplate = new RestTemplate(factory);
        String urlExterna = "https://jsonplaceholder.typicode.com/comments";
        String result = restTemplate.getForObject(urlExterna, String.class);


        return result;
    }


}
