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

        product1.setTitle("Рамен с курицей");
        product1.setDescription("Соевый бульон, пшеничная лапша, куриное филе, " +
                "мисо мотодаре, \nшиитаке, острая кукуруза, яйцо адзитама, зеленый лук, кунжут");
        product1.setPrice(690);
        product1.setNameMenuSection("Рамены");
        image1.setFilePath("images/Рамен_с_курицей.png");

        product2.setTitle("Рамен с морепродуктами");
        product2.setDescription("Креветочный бульон, пшеничная лапша, креветки, \n" +
                "кальмар, гребешок, сливки, устричный мотодаре, \nяйцо адзитама, зеленый лук, кунжут");
        product2.setPrice(790);
        product2.setNameMenuSection("Рамены");
        image2.setFilePath("images/Рамен_с_морепродуктами.png");

        product3.setTitle("Удон с креветками");
        product3.setDescription("Креветочный бульон, пшеничная лапша, креветки, \n" +
                "кальмар, гребешок, сливки, устричный мотодаре, \nяйцо адзитама, зеленый лук, кунжут");
        product3.setPrice(790);
        product3.setNameMenuSection("Лапша");
        image3.setFilePath("images/Рамен_с_морепродуктами.png");


        product4.setTitle("Мезмен бутанику");
        product4.setDescription("Креветочный бульон, пшеничная лапша, креветки, \n" +
                "кальмар, гребешок, сливки, устричный мотодаре, \nяйцо адзитама, зеленый лук, кунжут");
        product4.setPrice(690);
        product4.setNameMenuSection("Лапша");
        image4.setFilePath("images/Рамен_с_морепродуктами.png");

        product5.setTitle("Матча с муссом из манго");
        product5.setDescription("Матча, кокосовое молоко, мёд, пюре манго, кокосовые сливки");
        product5.setPrice(490);
        product5.setNameMenuSection("Матча");
        image5.setFilePath("images/Рамен_с_морепродуктами.png");

        product6.setTitle("Матча de Leche");
        product6.setDescription("Матча, кокосовое молоко, карамель, лёд");
        product6.setPrice(460);
        product6.setNameMenuSection("Матча");
        image6.setFilePath("images/Рамен_с_морепродуктами.png");

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
