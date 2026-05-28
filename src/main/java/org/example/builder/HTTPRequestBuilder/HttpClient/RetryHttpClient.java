package org.example.builder.HTTPRequestBuilder.HttpClient;

import org.example.builder.HTTPRequestBuilder.HttpRequest;
import org.example.builder.HTTPRequestBuilder.HttpResponse;

public class RetryHttpClient implements HttpClient{
    @Override
    public HttpResponse execute(HttpRequest request) {
        System.out.println("----------Executing Retry Request----------");
        System.out.println("Final Url: "+request.getEncodedUrl());
        System.out.println();
        System.out.println("URL: "+request.getUrl());
        System.out.println("Method: "+request.getHttpMethod().toString());
        System.out.println("Body:: ContentType: "+request.getBody().contentType()+" Content: "+request.getBody().content().toString());
        System.out.println("Timeout: "+request.getTimeout());
        System.out.println("Headers: "+request.getHeaders());
        System.out.println("QueryParams: "+request.getQueryParams());

        //actual network logic + retry logic...

        return new HttpResponse(200,"Success");
    }
}
