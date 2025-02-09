package com.example.buysell.config;

import com.example.buysell.models.Image;
import com.example.buysell.models.Product;
import com.example.buysell.repositories.ImageRepository;
import com.example.buysell.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class InitDatabase {
    private final Logger logger = LoggerFactory.getLogger(InitDatabase.class);

    @Bean
    CommandLineRunner init(ProductRepository productRepository, ImageRepository imageRepository) {
        Product product1 = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();
        Product product5 = new Product();
        Product product6 = new Product();
        Image image1 = new Image();
        Image image2 = new Image();
        Image image3 = new Image();
        Image image4 = new Image();
        Image image5 = new Image();
        Image image6 = new Image();

        product1.setId(1L);
        product2.setId(2L);
        product3.setId(3L);
        product4.setId(4L);
        product5.setId(5L);
        product6.setId(6L);
        image1.setId(1L);
        image2.setId(2L);
        image3.setId(3L);
        image4.setId(4L);
        image5.setId(5L);
        image6.setId(6L);
        image1.setProduct(product1);
        image2.setProduct(product2);
        image3.setProduct(product3);
        image4.setProduct(product4);
        image5.setProduct(product5);
        image6.setProduct(product6);
        image1.setName("file1");
        image2.setName("file2");
        image3.setName("file3");
        image4.setName("file4");
        image5.setName("file5");
        image6.setName("file6");

        product1.setTitle("Рамен с курицей");
        product1.setDescription("Соевый бульон, пшеничная лапша, куриное филе, " +
                "мисо мотодаре, \nшиитаке, острая кукуруза, яйцо адзитама, зеленый лук, кунжут");
        product1.setPrice(690);
        product1.setNameMenuSection("Рамены");
        File imageFile1 = new File("C:\\Users\\dutti\\buysell\\src\\main\\resources\\static\\images\\Рамен_с_курицей.png");
        try {
            byte[] imageBytes1 = ImageUtils.convertImageToBytes(imageFile1);
            image1.setBytes(imageBytes1);
            image1.setSize(image1.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product2.setTitle("Рамен с морепродуктами");
        product2.setDescription("Креветочный бульон, пшеничная лапша, креветки, \n" +
                "кальмар, гребешок, сливки, устричный мотодаре, \nяйцо адзитама, зеленый лук, кунжут");
        product2.setPrice(790);
        product2.setNameMenuSection("Рамены");
        File imageFile2 = new File("C:\\Users\\dutti\\buysell\\src\\main\\resources\\static\\images\\Рамен_с_морепродуктами.png");
        try {
            byte[] imageBytes2 = ImageUtils.convertImageToBytes(imageFile2);
            image2.setBytes(imageBytes2);
            image2.setSize(image2.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product3.setTitle("Удон с креветками");
        product3.setDescription("Креветочный бульон, пшеничная лапша, креветки, \n" +
                "кальмар, гребешок, сливки, устричный мотодаре, \nяйцо адзитама, зеленый лук, кунжут");
        product3.setPrice(790);
        product3.setNameMenuSection("Лапша");
        File imageFile3 = new File("C:\\Users\\dutti\\buysell\\src\\main\\resources\\static\\images\\Рамен_с_морепродуктами.png");
        try {
            byte[] imageBytes3 = ImageUtils.convertImageToBytes(imageFile3);
            image3.setBytes(imageBytes3);
            image3.setSize(image3.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product4.setTitle("Мезмен бутанику");
        product4.setDescription("Креветочный бульон, пшеничная лапша, креветки, \n" +
                "кальмар, гребешок, сливки, устричный мотодаре, \nяйцо адзитама, зеленый лук, кунжут");
        product4.setPrice(690);
        product4.setNameMenuSection("Лапша");
        File imageFile4 = new File("C:\\Users\\dutti\\buysell\\src\\main\\resources\\static\\images\\Рамен_с_морепродуктами.png");
        try {
            byte[] imageBytes4 = ImageUtils.convertImageToBytes(imageFile4);
            image4.setBytes(imageBytes4);
            image4.setSize(image4.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product5.setTitle("Матча с муссом из манго");
        product5.setDescription("Матча, кокосовое молоко, мёд, пюре манго, кокосовые сливки");
        product5.setPrice(490);
        product5.setNameMenuSection("Матча");
        File imageFile5 = new File("C:\\Users\\dutti\\buysell\\src\\main\\resources\\static\\images\\Рамен_с_морепродуктами.png");
        try {
            byte[] imageBytes5 = ImageUtils.convertImageToBytes(imageFile5);
            image5.setBytes(imageBytes5);
            image5.setSize(image5.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        product6.setTitle("Матча de Leche");
        product6.setDescription("Матча, кокосовое молоко, карамель, лёд");
        product6.setPrice(460);
        product6.setNameMenuSection("Матча");
        File imageFile6 = new File("C:\\Users\\dutti\\buysell\\src\\main\\resources\\static\\images\\Рамен_с_морепродуктами.png");
        try {
            byte[] imageBytes6 = ImageUtils.convertImageToBytes(imageFile6);
            image6.setBytes(imageBytes6);
            image6.setSize(image6.getBytes().length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return args -> {
            logger.info("Created new product: {}", productRepository.save(product1));
            logger.info("Created new image: {}", imageRepository.save(image1));
            logger.info("Created new product: {}", productRepository.save(product2));
            logger.info("Created new image: {}", imageRepository.save(image2));
            logger.info("Created new product: {}", productRepository.save(product3));
            logger.info("Created new image: {}", imageRepository.save(image3));
            logger.info("Created new product: {}", productRepository.save(product4));
            logger.info("Created new image: {}", imageRepository.save(image4));
            logger.info("Created new product: {}", productRepository.save(product5));
            logger.info("Created new image: {}", imageRepository.save(image5));
            logger.info("Created new product: {}", productRepository.save(product6));
            logger.info("Created new image: {}", imageRepository.save(image6));
        };
    }
}
