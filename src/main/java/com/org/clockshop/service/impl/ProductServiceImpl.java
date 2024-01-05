package com.org.clockshop.service.impl;

import com.org.clockshop.model.Product;
import com.org.clockshop.repository.ProductRepository;
import com.org.clockshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getByProductId(int id) {
        return productRepository.getByProductId(id);
    }
}
