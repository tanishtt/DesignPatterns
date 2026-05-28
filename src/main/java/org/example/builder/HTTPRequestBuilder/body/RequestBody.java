package org.example.builder.HTTPRequestBuilder.body;

public interface RequestBody {
    String contentType();
    byte[] content();
}
