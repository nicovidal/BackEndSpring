package com.restaurant.backend.restaurant.models.dao;

import com.restaurant.backend.restaurant.models.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductDao extends CrudRepository<Product, Integer> {
}

