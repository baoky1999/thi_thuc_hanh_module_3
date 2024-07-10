package com.management.thithuchanhmodule3.service.iml;

import com.management.thithuchanhmodule3.model.Product;
import com.management.thithuchanhmodule3.model.ProductDTO;
import com.management.thithuchanhmodule3.repository.IProductRepository;
import com.management.thithuchanhmodule3.repository.iml.ProductRepository;
import com.management.thithuchanhmodule3.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {

    IProductRepository productRepository = new ProductRepository();
    @Override
    public List<ProductDTO> listProduct() {
        return productRepository.listProduct();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public List<ProductDTO> listProductchoice(String choice) {
        return productRepository.listProductChoice(choice);
    }
}
