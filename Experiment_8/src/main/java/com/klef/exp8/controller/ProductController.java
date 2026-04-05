package com.klef.exp8.controller;

import com.klef.exp8.model.Product;
import com.klef.exp8.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repo;

    // Add Product
    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    // Get products by category
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return repo.findByCategory(category);
    }

    // Filter products by price range
    @GetMapping("/filter")
    public List<Product> filterProducts(@RequestParam double min, @RequestParam double max) {
        return repo.findByPriceBetween(min, max);
    }

    // Sort products by price
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repo.sortByPrice();
    }

    // Get expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return repo.findExpensiveProducts(price);
    }
}