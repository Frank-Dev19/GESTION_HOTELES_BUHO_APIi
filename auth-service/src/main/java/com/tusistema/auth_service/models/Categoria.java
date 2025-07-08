package com.tusistema.auth_service.models;

//import java.util.List;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria; // Correspondiente al id_categoria de la base de datos

    @Column(name = "descripcion")
    private String descripcion; // El campo descripcion que mencionas

    // @OneToMany(mappedBy = "categoria") // Relación con la entidad Producto
    // private List<Producto> productos; // Lista de productos asociados a esta
    // categoría

    // Getters and Setters
    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // public List<Producto> getProductos() {
    // return productos;
    // }

    // public void setProductos(List<Producto> productos) {
    // this.productos = productos;
    // }
}
