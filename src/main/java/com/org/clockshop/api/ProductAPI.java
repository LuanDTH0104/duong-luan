package com.org.clockshop.api;

import com.org.clockshop.model.Product;
import com.org.clockshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductAPI {

    @Autowired
    private ProductService productService;

    @GetMapping(value = {"","/"})
    public List<Product> getAll(){
        return  productService.getAll();
    }
}
