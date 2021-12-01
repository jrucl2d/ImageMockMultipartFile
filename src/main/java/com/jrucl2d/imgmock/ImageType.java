package com.jrucl2d.imgmock;

public enum ImageType {
    JPG("jpeg")
    , JPEG("jpeg")
    , PNG("png")
    , GIF("gif")
    , BMP("bmp");

    private final String value;
    ImageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
