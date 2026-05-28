package org.example.builder.HTTPRequestBuilder.HttpClient;

import org.example.builder.HTTPRequestBuilder.HttpRequest;
import org.example.builder.HTTPRequestBuilder.HttpResponse;

public interface HttpClient {
    HttpResponse execute(HttpRequest request);
}
