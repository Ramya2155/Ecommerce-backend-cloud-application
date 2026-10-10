package com.example.Ecommerce.Project.seed;

import com.example.Ecommerce.Project.entity.Product;
import com.example.Ecommerce.Project.entity.ProductImage;
import com.example.Ecommerce.Project.repository.ProductRepository;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            List<Product> demoProducts = List.of(
                    new Product(null, "Apple iPhone 15", 799.0, "SmartPhone with A16 chip", "phones", 4.8, "Amazon", 5, List.of("products/Apple_iphone_15.webp")),
                    new Product(null, "Samsung Galaxy S23", 749.0, "Flagship Android with Snapdragon 8 Gen 2", "phones", 4.7, "BestBuy", 8, List.of("products/Samsung_Galaxy_S23.webp")),
                    new Product(null, "Google Pixel 8", 699.0, "AI-powered smartphone with Tensor G3", "phones", 4.6, "Google Store", 10, List.of("products/Google_Pixel_8.webp")),
                    new Product(null, "OnePlus 11", 649.0, "Fast performance with OxygenOS", "phones", 4.5, "Amazon", 6, List.of("products/OnePlus_11.jpg")),
                    new Product(null, "Sony WH-1000XM5", 399.0, "Noise-cancelling wireless headphones", "audio", 4.9, "Sony Store", 12, List.of("products/Sony_WH1000XM5.webp")),
                    new Product(null, "Apple MacBook Air M2", 1199.0, "Lightweight laptop with M2 chip", "laptops", 4.8, "Apple Store", 4, List.of("products/Apple MacBook_Air_M2.jpg")),
                    new Product(null, "Dell XPS 13", 1099.0, "Premium ultrabook with InfinityEdge display", "laptops", 4.7, "Dell Store", 7, List.of("products/Dell_XPS_13.jpg")),
                    new Product(null, "HP Spectre x360", 1249.0, "Convertible laptop with OLED screen", "laptops", 4.6, "HP Store", 3, List.of("products/HP_Spectre_x360.webp")),
                    new Product(null, "iPad Pro 12.9", 999.0, "Tablet with M2 chip and ProMotion display", "tablets", 4.8, "Apple Store", 9, List.of("products/iPad_Pro_12.9.jpg")),
                    new Product(null, "Amazon Kindle Paperwhite", 149.0, "E-reader with adjustable warm light", "tablets", 4.7, "Amazon", 15, List.of("products/Amazon_Kindle_Paperwhite.webp")),
                    new Product(null, "Logitech MX Master 3S", 99.0, "Ergonomic wireless mouse", "accessories", 4.8, "Logitech Store", 20, List.of("products/Logitech_MX_Master_3S.webp")),
                    new Product(null, "Razer BlackWidow V4", 179.0, "Mechanical gaming keyboard", "accessories", 4.6, "Razer Store", 11, List.of("products/Razer_BlackWidow_V4.jpg")),
                    new Product(null, "Canon EOS R10", 999.0, "Mirrorless camera with 24MP sensor", "cameras", 4.7, "Canon Store", 5, List.of("products/Canon_EOS_R10.webp")),
                    new Product(null, "Nintendo Switch OLED", 349.0, "Hybrid gaming console with OLED display", "gaming", 4.8, "Nintendo Store", 14, List.of("products/Nintendo_Switch_OLED.webp")),
                    new Product(null, "Bose SoundLink Flex", 149.0, "Portable Bluetooth speaker", "audio", 4.7, "Bose Store", 18, List.of("products/Bose_SoundLink_Flex.jpg"))
            );
            productRepository.saveAll(demoProducts);
            System.out.println("✅ Seeded demo products.");
        } else {
            System.out.println("✔️ Products already exist. Skipping seed.");
        }

    }
}


