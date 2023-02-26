package com.df.crud.repository;

import com.df.crud.model.ProductoDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<ProductoDTO,String> {

}
