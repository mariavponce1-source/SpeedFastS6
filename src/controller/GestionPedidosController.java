package controller;

import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class GestionPedidosController {
    private final List<Pedido> listaPedidos;

    public GestionPedidosController() {
        this.listaPedidos = new ArrayList<>();
        // Datos de prueba iniciales
        listaPedidos.add(new Pedido("PED-101", "Av. Libertador 450", "Comida"));
        listaPedidos.add(new Pedido("PED-102", "Calle Central 89", "Express"));
    }

    public boolean agregarPedido(Pedido pedido) {
        for (Pedido p : listaPedidos) {
            if (p.getId().equalsIgnoreCase(pedido.getId())) {
                return false; // ID duplicado
            }
        }
        listaPedidos.add(pedido);
        return true;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public boolean asignarEntrega(String idPedido, String repartidor) {
        for (Pedido p : listaPedidos) {
            if (p.getId().equalsIgnoreCase(idPedido)) {
                p.setRepartidor(repartidor);
                p.setEstado("En camino");
                return true;
            }
        }
        return false;
    }
}