package com.bryanmugalu.microservices.product.service;

import com.bryanmugalu.microservices.product.dto.ProductRequest;
import com.bryanmugalu.microservices.product.dto.ProductResponse;
import com.bryanmugalu.microservices.product.model.Product;
import com.bryanmugalu.microservices.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        log.info("Creating product: {}", productRequest);
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
       Product response = productRepository.save(product);
        log.info("Created product: {} successfully", product);
        return new ProductResponse(response.getId(), response.getName(), response.getDescription(), response.getPrice());
    }

    public List<ProductResponse> getAllProducts() {
        log.info("Fetching all products");
        return productRepository
                .findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
