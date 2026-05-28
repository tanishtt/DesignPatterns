package org.example.builder.HTTPRequestBuilder.body;

public class JsonBody implements RequestBody {
    private final String json;

    public JsonBody(String json) {
        this.json = json;
    }

    @Override
    public String contentType() {
        return "application/json";
    }

    @Override
    public byte[] content() {
        return json.getBytes();
    }
}
