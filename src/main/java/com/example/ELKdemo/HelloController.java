package com.example.ELKdemo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {


    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/pulse")
    public String index2() {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet request = new HttpGet("http://localhost:8080/hello");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            System.out.println("8080 hello triggered");
            System.out.println(response.getStatusLine().toString());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

        HttpGet request2 = new HttpGet("http://localhost:8082/helloJSON");
        try (CloseableHttpResponse response = httpClient.execute(request2)) {
            System.out.println("8082 helloJSON triggered");
            System.out.println(response.getStatusLine().toString());
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return "Triggered";
    }

}