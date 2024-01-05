package com.org.clockshop.service;

import com.org.clockshop.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAll();

    public Product getByProductId(int id);
}
