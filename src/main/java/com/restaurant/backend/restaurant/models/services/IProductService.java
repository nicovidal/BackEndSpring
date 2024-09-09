package com.restaurant.backend.restaurant.models.services;

import com.restaurant.backend.restaurant.models.entity.Product;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(Integer id);
}