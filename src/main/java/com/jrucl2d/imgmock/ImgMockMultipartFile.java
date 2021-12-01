package com.jrucl2d.imgmock;

import org.springframework.mock.web.MockMultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImgMockMultipartFile extends MockMultipartFile {
    private final int width;
    private final int height;
    private final String imageType;

    private ImgMockMultipartFile(
        String name
        , String originalFilename
        , String contentType
        , byte[] content
        , int width
        , int height
        , String imageType
    ) {
        super(name, originalFilename, contentType, content);
        this.width = width;
        this.height = height;
        this.imageType = imageType;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, imageType, os);
        return new ByteArrayInputStream(os.toByteArray());
    }

    private static class Builder {
        private static final int MEGABYTE = 1_048_576;

        private String name = "test.png";
        private String originalFilename = "original_test.png";
        private int size = 10;
        private int width = 120;
        private int height = 120;
        private String imageType = "png";

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder originalFilename(String originalFilename) {
            this.originalFilename = originalFilename;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder sizeInMegaByte(int size) {
            this.size = size * MEGABYTE;
            return this;
        }

        public Builder width(int width) {
            this.width = width;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder imageType(ImageType imageType) {
            this.imageType = imageType.getValue();
            return this;
        }

        public ImgMockMultipartFile build() {
            byte[] content = new byte[size];
            return new ImgMockMultipartFile(
                name
                , originalFilename
                , "image/" + imageType
                , content
                , width
                , height
                , imageType);
        }
    }
}


