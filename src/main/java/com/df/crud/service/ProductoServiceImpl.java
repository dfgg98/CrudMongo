package com.df.crud.service;

import com.df.crud.model.ProductoDTO;
import com.df.crud.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl extends  GenericServiceImpl<ProductoDTO,String> implements  ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    @Override
    public CrudRepository<ProductoDTO,String> getDao() {
        return productoRepository;
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
