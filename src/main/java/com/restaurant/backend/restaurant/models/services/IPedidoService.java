
package com.restaurant.backend.restaurant.models.services;

import com.restaurant.backend.restaurant.models.entity.Pedido;
import java.util.List;

public interface IPedidoService {
    
    public List<Pedido>findAll();
    
}
