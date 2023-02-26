/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.df.crud.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author 59398
 */
public interface GenericService <T, ID extends Serializable>{

    public T save(T entity);

    public T findById(ID id);

    public List<T> findByAll();

    public void delete(ID id);


}
