package view;

import controller.GestionPedidosController;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private final GestionPedidosController controller;

    public VentanaPrincipal() {
        this.controller = new GestionPedidosController();

        setTitle("SpeedFast - Sistema de Gestión de Entregas");
        setSize(450, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initUI();
    }

    private void initUI() {
        JPanel panelContenedor = new JPanel(new BorderLayout(15, 15));
        panelContenedor.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));

        // Encabezado
        JLabel lblTitulo = new JLabel("Panel de Control SpeedFast", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        panelContenedor.add(lblTitulo, BorderLayout.NORTH);

        // Botones de acción centralizados
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 0, 15));

        JButton btnRegistrar = new JButton("1. Registrar Nuevo Pedido");
        JButton btnListar = new JButton("2. Listar Pedidos Existentes");
        JButton btnAsignar = new JButton("3. Asignar Repartidor / Iniciar Entrega");

        Font fontBtn = new Font("Segoe UI", Font.PLAIN, 14);
        btnRegistrar.setFont(fontBtn);
        btnListar.setFont(fontBtn);
        btnAsignar.setFont(fontBtn);

        panelBotones.add(btnRegistrar);
        panelBotones.add(btnListar);
        panelBotones.add(btnAsignar);

        panelContenedor.add(panelBotones, BorderLayout.CENTER);
        add(panelContenedor);

        // Eventos de navegación
        btnRegistrar.addActionListener(e -> {
            VentanaRegistroPedido vrp = new VentanaRegistroPedido(controller);
            vrp.setVisible(true);
        });

        btnListar.addActionListener(e -> {
            VentanaListaPedidos vlp = new VentanaListaPedidos(controller);
            vlp.setVisible(true);
        });

        btnAsignar.addActionListener(e -> mostrarDialogoAsignacion());
    }

    private void mostrarDialogoAsignacion() {
        String id = JOptionPane.showInputDialog(this,
                "Ingrese el ID del Pedido a iniciar:",
                "Asignación de Entrega",
                JOptionPane.QUESTION_MESSAGE);

        if (id != null && !id.trim().isEmpty()) {
            String repartidor = JOptionPane.showInputDialog(this,
                    "Nombre del Repartidor asignado:",
                    "Repartidor",
                    JOptionPane.QUESTION_MESSAGE);

            if (repartidor != null && !repartidor.trim().isEmpty()) {
                boolean exito = controller.asignarEntrega(id.trim(), repartidor.trim());
                if (exito) {
                    JOptionPane.showMessageDialog(this,
                            "Entrega iniciada con éxito para el pedido " + id,
                            "Despacho Confirmado",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this,
                            "No se encontró ningún pedido con el ID especificado.",
                            "Error de Búsqueda",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}