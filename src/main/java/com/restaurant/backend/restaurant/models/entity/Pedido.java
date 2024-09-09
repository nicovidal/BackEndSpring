
package com.restaurant.backend.restaurant.models.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Table;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

import java.util.List;



@Entity
@Table(name="pedidos")
public class Pedido implements Serializable{
    
    @Id
    private Long id_pedido;
    private Integer mesa_id;
    
    @Column(columnDefinition = "jsonb")
    private String bebida; // Guardamos como String para manejar JSON
    
    @Column(columnDefinition = "jsonb")
    private String comida; // Guardamos como String para manejar JSON
    
    private Date inicio;
    private Date fin;
    private String genero;
    private Integer camarero_id;
    private Integer total_pedido;

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Integer getMesa_id() {
        return mesa_id;
    }

    public void setMesa_id(Integer mesa_id) {
        this.mesa_id = mesa_id;
    }

    public String getBebida() {
        return bebida;
    }

    public void setBebida(String bebida) {
        this.bebida = bebida;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getCamarero_id() {
        return camarero_id;
    }

    public void setCamarero_id(Integer camarero_id) {
        this.camarero_id = camarero_id;
    }

    public Integer getTotal_pedido() {
        return total_pedido;
    }

    public void setTotal_pedido(Integer total_pedido) {
        this.total_pedido = total_pedido;
    }

  

   
    
    

  
    
    private static final long serialVersionUID=1L;
    
    
}
