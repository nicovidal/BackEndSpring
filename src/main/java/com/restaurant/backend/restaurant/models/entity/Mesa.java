
package com.restaurant.backend.restaurant.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="mesa")
public class Mesa {
    
    @Id
    private Long id_mesa;
    private String name_mesa;
    private String estado_mesa;

    public Long getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(Long id_mesa) {
        this.id_mesa = id_mesa;
    }

    public String getName_mesa() {
        return name_mesa;
    }

    public void setName_mesa(String name_mesa) {
        this.name_mesa = name_mesa;
    }

    public String getEstado_mesa() {
        return estado_mesa;
    }

    public void setEstado_mesa(String estado_mesa) {
        this.estado_mesa = estado_mesa;
    }
    
    private static final long serialVersionUID = 1L;
    
    
    
    
    
    
}
