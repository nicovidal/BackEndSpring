
package com.restaurant.backend.restaurant.models.services;

import com.restaurant.backend.restaurant.models.entity.Mesa;
import java.util.List;


public interface IMesaService {
    
    List<Mesa> findAll();
    Mesa findById(Long id);
    
}
