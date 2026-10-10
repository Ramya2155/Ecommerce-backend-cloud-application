package com.example.Ecommerce.Project.controller;

import com.example.Ecommerce.Project.dto.ProductReviewDto;
import com.example.Ecommerce.Project.entity.ProductReview;
import com.example.Ecommerce.Project.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products/reviews")
public class ProductReviewController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody @Valid ProductReviewDto reviewDto) {
        productService.addReview(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review added");
    }
}