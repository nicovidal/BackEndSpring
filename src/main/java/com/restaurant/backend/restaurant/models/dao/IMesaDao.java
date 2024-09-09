package com.restaurant.backend.restaurant.models.dao;

import com.restaurant.backend.restaurant.models.entity.Mesa;
import org.springframework.data.repository.CrudRepository;

public interface IMesaDao extends CrudRepository<Mesa, Long>{
    
}
