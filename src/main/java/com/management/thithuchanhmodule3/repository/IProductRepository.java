package com.management.thithuchanhmodule3.repository;

import com.management.thithuchanhmodule3.model.Product;
import com.management.thithuchanhmodule3.model.ProductDTO;

import java.util.List;

public interface IProductRepository {
    List<ProductDTO> listProduct();

    void addProduct(Product product);

    List<ProductDTO> listProductChoice(String choice);
}
