package com.tusistema.auth_service.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.tusistema.auth_service.dto.listarPorCategoria;
// import com.tusistema.auth_service.models.Categoria;
import com.tusistema.auth_service.models.Producto;
import com.tusistema.auth_service.service.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping("/listarProductos")
    public ResponseEntity<List<Producto>> obtenerTodosLosProductos() {
        List<Producto> producto = productoService.obtenerProductos();
        return ResponseEntity.ok(producto);
    }

    @PostMapping("/guardarProductos")
    public ResponseEntity<Boolean> guardarProducto(@RequestBody Producto producto) {
        try {
            Producto productoGuardado = productoService.guardarProducto(producto);
            return ResponseEntity.ok(true); // Si el producto se guardó con éxito
        } catch (Exception e) {
            return ResponseEntity.ok(false); // Si ocurrió algún error al guardar el producto
        }
    }

    @PostMapping("/eliminarProductos")
    public ResponseEntity<Void> eliminarProducto(@RequestBody Map<String, List<Map<String, Integer>>> payload) {
        System.out.println(">> Llegó al backend para eliminar categ");

        List<Map<String, Integer>> lista = payload.get("listaRequest");

        for (Map<String, Integer> item : lista) {
            Long idProducto = Long.valueOf(item.get("idProducto"));
            productoService.eliminarProducto(idProducto);
        }

        return ResponseEntity.ok().build();

    }

    // @PostMapping("/listarProductosPorCategoria")
    // public ResponseEntity<List<Producto>>
    // listarProductosPorCategoria(@RequestBody Map<String, Long> payload) {
    // // Obtenemos el idCategoria de la solicitud
    // Long idCategoria = payload.get("idCategoria");

    // if (idCategoria == null) {
    // return ResponseEntity.badRequest().build(); // Si no se recibe el
    // // idCategoria, retornar BadRequest
    // }

    // // Llamamos al servicio para listar los productos por categoria
    // List<Producto> productos =
    // productoService.listarProductosPorCategoria(idCategoria);
    // return ResponseEntity.ok(productos);
    // }

    // @PostMapping("/listarProductosPorCategoria")
    // public ResponseEntity<List<Producto>>
    // listarProductosPorCategoria(@RequestBody listarPorCategoria request) {
    // // Obtener el idCategoria del objeto request directamente
    // Long idCategoria = request.getIdCategoria();

    // if (idCategoria == null) {
    // return ResponseEntity.badRequest().build(); // Si no se recibe el
    // // idCategoria, retornar BadRequest
    // }

    // // Llamamos al servicio para listar los productos por categoria
    // List<Producto> productos =
    // productoService.listarProductosPorCategoria(idCategoria);
    // return ResponseEntity.ok(productos);
    // }

    @PostMapping("/listarProductosPorCategoria")
    public ResponseEntity<List<Producto>> listarProductosPorCategoria(
            @RequestBody Map<String, List<Map<String, Long>>> payload) {
        System.out.println(">> Llegó al backend para listar productos por categoría");

        // Extraemos la lista de la clave "request" del Map
        List<Map<String, Long>> lista = payload.get("request");

        // Verificamos si la lista está vacía o nula
        if (lista == null || lista.isEmpty()) {
            return ResponseEntity.badRequest().build(); // Retornamos un BadRequest si la lista no contiene elementos
        }

        // Extraemos el idCategoria del primer elemento de la lista
        Long idCategoria = lista.get(0).get("idCategoria");

        if (idCategoria == null) {
            return ResponseEntity.badRequest().build(); // Retornamos BadRequest si no se recibe un idCategoria válido
        }

        // Llamamos al servicio para obtener los productos por categoría
        List<Producto> productos = productoService.listarProductosPorCategoria(idCategoria);
        return ResponseEntity.ok(productos); // Retornamos la lista de productos
    }

    // @PostMapping("/listarProductosPorCategoria")
    // public ResponseEntity<List<Producto>>
    // listarProductosPorCategoria(@RequestBody Map<String, List<Map<String,
    // Integer>>> payload) {
    // System.out.println(">> Llegó al backend para eliminar usuarios");

    // List<Map<String, Integer>> lista = payload.get("request");

    // for (Map<String, Integer> item : lista) {
    // Long id = Long.valueOf(item.get("idCategoria"));
    // List<Producto> productos = productoService.listarProductosPorCategoria(id);
    // return ResponseEntity.ok(productos);
    // }

    // }

    // @GetMapping("/porCategoria/{idCategoria}")
    // public ResponseEntity<List<Producto>>
    // obtenerProductosPorCategoria(@PathVariable Long idCategoria) {
    // List<Producto> productos =
    // productoService.obtenerProductosPorCategoria(idCategoria);
    // return ResponseEntity.ok(productos);
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
    // Producto producto = productoService.obtenerProductoPorId(id);
    // if (producto != null) {
    // return ResponseEntity.ok(producto);
    // } else {
    // return ResponseEntity.notFound().build();
    // }
    // }
}
