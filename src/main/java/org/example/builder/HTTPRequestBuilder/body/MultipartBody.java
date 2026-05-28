package org.example.builder.HTTPRequestBuilder.body;

import java.util.Map;

public class MultipartBody implements RequestBody {

    private final Map<String, Object> parts;

    public MultipartBody(Map<String, Object> parts) {
        this.parts = parts;
    }

    @Override
    public String contentType() {
        return "multipart/form-data";
    }

    @Override
    public byte[] content() {
        return new byte[0];
    }
}
