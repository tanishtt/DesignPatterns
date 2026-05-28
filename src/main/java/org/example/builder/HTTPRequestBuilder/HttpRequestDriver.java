package org.example.builder.HTTPRequestBuilder;

import org.example.builder.HTTPRequestBuilder.HttpClient.HttpClient;
import org.example.builder.HTTPRequestBuilder.HttpClient.RetryHttpClient;
import org.example.builder.HTTPRequestBuilder.body.JsonBody;
import org.example.builder.HTTPRequestBuilder.enums.HTTPMethod;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HttpRequestDriver {
    public static void main(String[] args) {
        HttpRequest httpRequest=HttpRequest.builder()
                .method(HTTPMethod.POST)
                .url("https://api.payment.com/v1/pay")
                .addHeader("Authorization", "Bearer token")
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", List.of("text/html", "application/xml"))
                .addHeader("Set-Cookie","user=JohnDoe; Max-Age=3600; Secure")
                .addHeader("Set-Cookie","session_id=abc123xyz; HttpOnly; Secure")
                .addQueryParam("merchantId", "M123")
                .addQueryParam("merchantName", "Tanish Mohanta")
                .body(new JsonBody("{\"name\":\"Tanish\"}"))
                .timeout(Duration.ofMillis(5000))
                .build();

        HttpClient httpClient= new RetryHttpClient();
        httpClient.execute(httpRequest);

    }
}
