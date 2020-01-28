package com.sujan.break_o_last.responses;

public class ImageResponse {
    String filename;

    public ImageResponse(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
