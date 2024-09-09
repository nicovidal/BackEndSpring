package com.restaurant.backend.restaurant.dto;

import com.restaurant.backend.restaurant.models.entity.Pedido;
import java.util.List;
import java.util.Map;

public class PedidoConEstado {

    private Pedido pedido;
    private String estadoMesa;
    private List<Map<String, Object>> comida;
    private List<Map<String, Object>> bebida;

    public PedidoConEstado(Pedido pedido, String estadoMesa, List<Map<String, Object>> comida, List<Map<String, Object>> bebida) {
        this.pedido = pedido;
        this.estadoMesa = estadoMesa;
        this.comida = comida;
        this.bebida = bebida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public List<Map<String, Object>> getComida() {
        return comida;
    }

    public void setComida(List<Map<String, Object>> comida) {
        this.comida = comida;
    }

    public List<Map<String, Object>> getBebida() {
        return bebida;
    }

    public void setBebida(List<Map<String, Object>> bebida) {
        this.bebida = bebida;
    }
}
