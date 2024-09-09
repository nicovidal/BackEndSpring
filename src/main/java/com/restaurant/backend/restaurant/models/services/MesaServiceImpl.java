/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurant.backend.restaurant.models.services;
import com.restaurant.backend.restaurant.models.entity.Mesa;

import com.restaurant.backend.restaurant.models.dao.IMesaDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesaServiceImpl implements IMesaService {
    
    @Autowired
    private IMesaDao mesaDao;
    
    @Override
    public List<Mesa>findAll(){
        return (List<Mesa>) mesaDao.findAll();
  
    }
       
    @Override
    public Mesa findById(Long id) {
        return mesaDao.findById(id).orElse(null);
    }
    
    
}
