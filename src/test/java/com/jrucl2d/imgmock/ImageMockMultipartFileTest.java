package com.jrucl2d.imgmock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

class ImageMockMultipartFileTest {
    @Test
    void name() {
        // given
        MockMultipartFile file = ImageMockMultipartFile.builder()
            .size(1000)
            .build();

        // when

        // then
        long size = file.getSize();
        Assertions.assertEquals(size, 100);
    }
}