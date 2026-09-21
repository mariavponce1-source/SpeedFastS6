# SpeedFast - Sistema de Gestión de Entregas

Aplicación de escritorio desarrollada en **Java** con interfaz gráfica en **Swing**, implementada como parte de la Actividad Formativa Individual de la Semana 6: *"Diseñando interfaces gráficas para aplicaciones en Java"*.

---

## 📋 Descripción del Proyecto

El sistema permite gestionar de manera visual e interactiva el flujo de entregas de la empresa **SpeedFast**, sustituyendo la interacción por consola por una interfaz intuitiva organizada bajo el patrón arquitectónico **Modelo-Vista-Controlador (MVC)**.

### Características Principales:
- **Ventana Principal (`VentanaPrincipal`):** Menú central que coordina la navegación hacia los módulos del sistema.
- **Registro de Pedidos (`VentanaRegistroPedido`):** Formulario con validación de campos obligatorios para ingresar ID, dirección y tipo de pedido (Comida, Encomienda, Express).
- **Listado Dinámico (`VentanaListaPedidos`):** Tabla visual construida con `JTable` y `DefaultTableModel` para consultar pedidos registrados, su estado y el repartidor asignado, con soporte para refrescar datos en tiempo real.
- **Asignación de Repartidores:** Módulo interactivo mediante cuadros de diálogo (`JOptionPane`) para vincular pedidos a repartidores y actualizar su estado a *"En camino"*.
- **Persistencia en Memoria:** Uso de colecciones (`List<Pedido>`) centralizadas en un controlador para compartir el estado entre ventanas.

---

## 📁 Estructura del Código

```text
src/
├── controller/
│   └── GestionPedidosController.java   # Lógica de negocio y manejo de datos en memoria
├── model/
│   └── Pedido.java                    # Entidad Pedido con atributos y métodos de acceso
├── view/
│   ├── VentanaPrincipal.java          # Menú principal y navegación
│   ├── VentanaRegistroPedido.java     # Formulario de alta con validaciones
│   └── VentanaListaPedidos.java       # Visualización de pedidos en JTable
└── main/
    └── Main.java                      # Punto de entrada de la aplicación
