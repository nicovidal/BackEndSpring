
package com.restaurant.backend.restaurant.models.services;

import com.restaurant.backend.restaurant.models.dao.IPedidoDao;
import java.util.List;
import com.restaurant.backend.restaurant.models.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl implements IPedidoService{
    
    @Autowired
    private IPedidoDao pedidoDao;
            
    @Override
    public List<Pedido> findAll(){
        return (List<Pedido>)pedidoDao.findAll();
    }
    
}
