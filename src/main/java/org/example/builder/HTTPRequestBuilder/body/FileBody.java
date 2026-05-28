package org.example.builder.HTTPRequestBuilder.body;

public class FileBody implements RequestBody{
    private final byte[] data;
    private final String mimeType;

    public FileBody(byte[] data, String mimeType) {
        this.data = data;
        this.mimeType = mimeType;
    }

    @Override
    public String contentType() {
        return mimeType;
    }

    @Override
    public byte[] content() {
        return data;
    }
}
