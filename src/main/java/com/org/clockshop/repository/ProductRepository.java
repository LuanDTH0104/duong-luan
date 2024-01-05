package com.org.clockshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.clockshop.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product getByProductId(int productId);
}
