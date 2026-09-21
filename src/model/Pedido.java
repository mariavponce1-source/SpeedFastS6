package model;

public class Pedido {
    private String id;
    private String direccion;
    private String tipo;
    private String estado;
    private String repartidor;

    public Pedido(String id, String direccion, String tipo) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = "Pendiente";
        this.repartidor = "Sin asignar";
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getRepartidor() { return repartidor; }
    public void setRepartidor(String repartidor) { this.repartidor = repartidor; }
}