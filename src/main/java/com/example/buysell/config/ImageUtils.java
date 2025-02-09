package com.example.buysell.config;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
@Component
public class ImageUtils {
    public static byte[] convertImageToBytes(File file) throws IOException {
        byte[] bytes;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            bytes = new byte[(int) file.length()];
            fileInputStream.read(bytes);
        }
        return bytes;
    }
}

