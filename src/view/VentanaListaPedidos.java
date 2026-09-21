package view;

import controller.GestionPedidosController;
import model.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {
    private final GestionPedidosController controller;
    private JTable tablaPedidos;
    private DefaultTableModel tableModel;

    public VentanaListaPedidos(GestionPedidosController controller) {
        this.controller = controller;

        setTitle("SpeedFast - Listado de Pedidos");
        setSize(650, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        initUI();
        cargarDatosTabla();
    }

    private void initUI() {
        setLayout(new BorderLayout(10, 10));

        // Configuración de tabla y modelo
        String[] columnas = {"ID", "Dirección", "Tipo", "Estado", "Repartidor"};
        tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Filas de solo lectura
            }
        };

        tablaPedidos = new JTable(tableModel);
        tablaPedidos.setRowHeight(24);
        JScrollPane scrollPane = new JScrollPane(tablaPedidos);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        add(scrollPane, BorderLayout.CENTER);

        // Barra inferior de acciones
        JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        JButton btnRefrescar = new JButton("Refrescar Tabla");
        JButton btnCerrar = new JButton("Cerrar");

        panelInferior.add(btnRefrescar);
        panelInferior.add(btnCerrar);
        add(panelInferior, BorderLayout.SOUTH);

        // Eventos
        btnRefrescar.addActionListener(e -> cargarDatosTabla());
        btnCerrar.addActionListener(e -> dispose());
    }

    public void cargarDatosTabla() {
        tableModel.setRowCount(0); // Limpiar filas previas
        List<Pedido> pedidos = controller.getListaPedidos();

        for (Pedido p : pedidos) {
            Object[] fila = {
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado(),
                    p.getRepartidor()
            };
            tableModel.addRow(fila);
        }
    }
}