package com.rentease.service.impl;

import com.rentease.entity.ProductEntity;
import com.rentease.model.ProductDTO;
import com.rentease.repository.ProductRepository;
import com.rentease.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductEntity saveProduct(ProductDTO productDTO){
        ProductEntity proEntity=new ProductEntity();
        proEntity.setName(productDTO.getName());
        proEntity.setDescription(productDTO.getDescription());
        proEntity.setCategory(productDTO.getCategory());
        proEntity.setRentPerDay(productDTO.getRentPerDay());
        proEntity.setAvailabilityStatus(productDTO.getAvailabilityStatus());

        proEntity=productRepository.save(proEntity);
        return proEntity;
    }

    @Override
    public List<ProductEntity> getAllProduct() {
        return productRepository.findAll();
    }
    @Override
    public ProductEntity getProductById(Long id){
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductEntity UpdateProduct(ProductDTO productDTO) {
        ProductEntity exisitingProduct = productRepository.findById(productDTO.getId()).orElse(null);
        if (exisitingProduct != null) {
            exisitingProduct.setName(productDTO.getName());
            exisitingProduct.setDescription(productDTO.getDescription());
            exisitingProduct.setCategory(productDTO.getCategory());
            exisitingProduct.setRentPerDay(productDTO.getRentPerDay());
            exisitingProduct.setAvailabilityStatus(productDTO.getAvailabilityStatus());

            exisitingProduct = productRepository.save(exisitingProduct);
        }
            return exisitingProduct;

        }

    @Override
    public ProductEntity deleteProductId(Long id) {
        ProductEntity product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.deleteById(id);
        }
        return product;
    }
}


