package com.df.crud.controller;

import com.df.crud.model.ProductoDTO;
import com.df.crud.repository.ProductoRepository;
import com.df.crud.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoControllers {

    @Autowired
    ProductoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<List<ProductoDTO>> listarProductos() {
        return new ResponseEntity<>(productoService.findByAll(),
                HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ProductoDTO> crearProducto(
            @RequestBody ProductoDTO p) {
        return new ResponseEntity<>(productoService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable String id, @RequestBody ProductoDTO p) {
        ProductoDTO productoEncontrado = productoService.findById(id);
        if (productoEncontrado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                productoEncontrado.set_id(p.get_id());
                productoEncontrado.setNombre(p.getNombre());
                productoEncontrado.setPrecio(p.getPrecio());
                productoEncontrado.setFecha_expiracion(p.getFecha_expiracion());
                return new ResponseEntity<>(productoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<ProductoDTO> eliminarProducto(@PathVariable String id) {
        productoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
