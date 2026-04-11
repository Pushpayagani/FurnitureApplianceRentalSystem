package com.rentease.controller;


import com.rentease.entity.ProductEntity;
import com.rentease.model.ProductDTO;
import com.rentease.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping("/saveProduct")
  public ProductEntity onboardingProduct(@RequestBody ProductDTO productDTO){
        ProductEntity data=productService.saveProduct(productDTO);
  return data;
  }

    @GetMapping("/getProduct")
    public List<ProductEntity> getProduct(){
      List<ProductEntity> productEntityList=productService.getAllProduct();
        return productEntityList;
    }
    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @PutMapping("/updateProduct")
    public ProductEntity updateProduct(@RequestBody ProductDTO productDTO){
        return productService.UpdateProduct(productDTO);
    }
    @DeleteMapping("/{id}")
    public String deleteProductId(@PathVariable Long id){
        productService.deleteProductId(id);
        return "product deleted Successfully";
    }
    @GetMapping("/search")
    public List<ProductEntity> searchProducts(@RequestParam String keyword){
        return productService.searchProducts(keyword);
    }
    @GetMapping
    public List<ProductEntity> getProducts(
            @RequestParam(required = false) String category) {

        if (category != null) {
            return productService.getProductsByCategory(category);
        } else {
            return productService.getAllProduct();
        }
    }
}
