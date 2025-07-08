package com.tusistema.auth_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tusistema.auth_service.models.Producto;
import com.tusistema.auth_service.repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // public Producto guardarProducto(Producto producto) {
    // return productoRepository.save(producto);
    // }

    public Producto guardarProducto(Producto producto) {

        Producto product;

        if (producto.getIdProducto() != null) {
            product = productoRepository.findById(producto.getIdProducto())
                    .orElseThrow(
                            () -> new RuntimeException("Producto no encontrado con ID: " + producto.getIdProducto()));
        } else {
            product = new Producto();
        }

        product.setNombre(producto.getNombre());
        product.setPrecio(producto.getPrecio());
        product.setStock(producto.getStock());
        product.setCategoria(producto.getCategoria());

        return productoRepository.save(product);
    }

    public void eliminarProducto(Long idProducto) {
        productoRepository.deleteById(idProducto);
    }

    // Método para obtener los productos por categoría
    public List<Producto> listarProductosPorCategoria(Long idCategoria) {
        return productoRepository.findByCategoria_IdCategoria(idCategoria);
    }

    // public Producto obtenerProductoPorId(Long idProducto) {
    // return productoRepository.findById(idProducto).orElse(null);
    // }

    // public List<Producto> obtenerProductosPorCategoria(Long idCategoria) {
    // return productoRepository.findByCategoriaId(idCategoria);
    // }
}
