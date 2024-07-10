package com.management.thithuchanhmodule3.service;

import com.management.thithuchanhmodule3.model.Product;
import com.management.thithuchanhmodule3.model.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> listProduct();

    void addProduct(Product product);

    List<ProductDTO> listProductchoice(String choice);
}
