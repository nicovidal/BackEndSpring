package com.restaurant.backend.restaurant.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.backend.restaurant.dto.PedidoConEstado;
import com.restaurant.backend.restaurant.models.entity.Mesa;
import com.restaurant.backend.restaurant.models.entity.Pedido;
import com.restaurant.backend.restaurant.models.entity.Product;
import com.restaurant.backend.restaurant.models.services.IMesaService;
import com.restaurant.backend.restaurant.models.services.IPedidoService;
import com.restaurant.backend.restaurant.models.services.IProductService;
import java.io.IOException;
import java.util.HashMap;

import java.util.List;
import java.util.stream.Collectors;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PedidoRestController {

    @Autowired
    private IPedidoService pedidoService;

    @Autowired
    private IMesaService mesaService;

    @Autowired
    private IProductService productService;

    @GetMapping("/pedidos")
    public List<Pedido> index() {
        return pedidoService.findAll();
    }

    @GetMapping("/pedidosConEstado")
    public List<PedidoConEstado> getPedidosConEstado() {
        try {
            List<Pedido> pedidos = pedidoService.findAll();
            List<Mesa> mesas = mesaService.findAll();
            List<Product> productos = productService.findAll(); // Get all products

            ObjectMapper mapper = new ObjectMapper();

            return pedidos.stream().map(pedido -> {
                System.out.println("ID del Pedido: " + pedido.getMesa_id());

                Mesa mesa = mesas.stream()
                        .filter(m -> m.getId_mesa().equals(pedido.getMesa_id()))
                        .findFirst()
                        .orElse(null);

                // Maneja el caso cuando la mesa no se encuentra
                String estadoMesa = (mesa != null) ? mesa.getEstado_mesa() : "Desconocido";
                System.out.println("Estado de la Mesa: " + estadoMesa);

                List<Map<String, Object>> comidaList;
                List<Map<String, Object>> bebidaList;

                try {
                    comidaList = mapper.readValue(pedido.getComida(), new TypeReference<List<Map<String, Object>>>() {
                    });
                    bebidaList = mapper.readValue(pedido.getBebida(), new TypeReference<List<Map<String, Object>>>() {
                    });
                } catch (IOException e) {
                    // Manejo de la excepción
                    e.printStackTrace();
                    comidaList = List.of(); // Lista vacía en caso de error
                    bebidaList = List.of(); // Lista vacía en caso de error
                }

                // Ajustamos los tipos en los maps
                List<Map<String, Object>> comida = comidaList.stream()
                        .map(item -> {
                            String id = item.get("id").toString();
                            Integer cantidad = (Integer) item.get("cantidad");
                            String nombre = productos.stream()
                                    .filter(producto -> producto.getId_product().equals(Integer.parseInt(id)))
                                    .findFirst()
                                    .map(Product::getName_product)
                                    .orElse("Desconocido");
                            Map<String, Object> map = new HashMap<>();
                            map.put("nombre", nombre);
                            map.put("cantidad", cantidad);
                            return map;
                        })
                        .collect(Collectors.toList());

                List<Map<String, Object>> bebida = bebidaList.stream()
                        .map(item -> {
                            String id = item.get("id").toString();
                            Integer cantidad = (Integer) item.get("cantidad");
                            String nombre = productos.stream()
                                    .filter(producto -> producto.getId_product().equals(Integer.parseInt(id)))
                                    .findFirst()
                                    .map(Product::getName_product)
                                    .orElse("Desconocido");
                            Map<String, Object> map = new HashMap<>();
                            map.put("nombre", nombre);
                            map.put("cantidad", cantidad);
                            return map;
                        })
                        .collect(Collectors.toList());

                return new PedidoConEstado(pedido, estadoMesa, comida, bebida);

            }).collect(Collectors.toList());

        } catch (Exception e) {
            // Manejo de la excepción
            e.printStackTrace();
            return List.of(); // Lista vacía en caso de error
        }
    }

}
