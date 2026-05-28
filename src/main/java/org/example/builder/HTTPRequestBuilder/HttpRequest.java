package org.example.builder.HTTPRequestBuilder;

import org.example.builder.HTTPRequestBuilder.body.RequestBody;
import org.example.builder.HTTPRequestBuilder.enums.HTTPMethod;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class HttpRequest {
    private final HTTPMethod httpMethod;
    private final String url;
    private final Map<String, List<String >> headers;
    private final Map<String,String> queryParams;
    private final RequestBody body;
    private final Duration timeout;
    private HttpRequest(Builder b){
        this.httpMethod=b.httpMethod;
        this.url=b.url;
        Map<String, List<String>> copied = new HashMap<>();

        for(var entry : b.headers.entrySet()) {
            copied.put(
                    entry.getKey(),
                    List.copyOf(entry.getValue())
            );
        }

        this.headers = Map.copyOf(copied);
        this.queryParams=Collections.unmodifiableMap(new HashMap<>(b.queryParams));
        this.body=b.body;
        this.timeout=b.timeout;
    }


    public HTTPMethod getHttpMethod() {
        return httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParams() {
        return queryParams;
    }

    public RequestBody getBody() {
        return body;
    }

    public Duration getTimeout() {
        return timeout;
    }

    @Override
    public String toString() {
        return "HttpRequest{url='" + url + "', method='" + httpMethod.toString() +
                "', headers=" + headers + ", queryParams=" + queryParams +
                ", body='" + body + "', timeout=" + timeout + "}";
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder{
        private String url;
        private HTTPMethod httpMethod = HTTPMethod.GET;
        private Map<String, List<String>> headers = new HashMap<>();
        private Map<String, String> queryParams = new HashMap<>();
        private RequestBody body;
        private Duration timeout = Duration.ofMillis(3000);

        public Builder(){}

        public Builder method(HTTPMethod method){
            this.httpMethod=method;
            return this;
        }
        public Builder url(String url){
            this.url=url;
            return this;
        }
        public Builder addHeader(String key, String value){
            List<String>list=this.headers.get(key);
            if(list == null){
                list=new ArrayList<>();
                this.headers.put(key,list);
            }
            list.add(value);
            return this;
        }
        public Builder addHeader(String key, List<String> values){
            if (values != null) {
                List<String> list = this.headers.get(key);
                if (list == null) {
                    list = new ArrayList<>();
                    this.headers.put(key, list);
                }
                list.addAll(values);
            }
            return this;
        }
        public Builder addQueryParam(String key, String value){
            this.queryParams.put(key,value);
            return this;
        }
        public Builder body(RequestBody b){
            body=b;
            return this;
        }
        public Builder timeout(Duration t){
            timeout=t;
            return this;
        }
        public HttpRequest build(){
            validate();
            return new HttpRequest(this);
        }
        private void validate() {
            if(url == null || url.isBlank())
                throw new IllegalArgumentException("URL required");

            if(timeout.isNegative())
                throw new IllegalArgumentException("Invalid timeout");

            if(httpMethod == HTTPMethod.GET && body != null)
                throw new IllegalStateException("GET cannot have body");
        }
    }

    public String getEncodedUrl(){
        if(queryParams.isEmpty()){
            return url;
        }

        String queryString=queryParams.entrySet()
                .stream()
                .map(entry->encode(entry.getKey())+"="+encode(entry.getValue()))
                .collect(Collectors.joining("&"));

        return url+"?"+queryString;
    }
    private String encode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

}
