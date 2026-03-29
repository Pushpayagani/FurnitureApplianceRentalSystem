package com.rentease.service;

import com.rentease.entity.ProductEntity;
import com.rentease.model.ProductDTO;
import com.rentease.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    ProductEntity saveProduct(ProductDTO productDTO);
    List<ProductEntity> getAllProduct();

    ProductEntity getProductById(Long id);

    ProductEntity UpdateProduct(ProductDTO productDTO);

    ProductEntity deleteProductId(Long id);


}
