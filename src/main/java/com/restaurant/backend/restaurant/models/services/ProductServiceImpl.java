
package com.restaurant.backend.restaurant.models.services;

import com.restaurant.backend.restaurant.models.dao.IProductDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurant.backend.restaurant.models.entity.Product;



@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return (List<Product>) productDao.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id).orElse(null);
    }
}
