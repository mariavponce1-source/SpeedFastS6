package view;

import controller.GestionPedidosController;
import model.Pedido;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedido extends JFrame {
    private final GestionPedidosController controller;
    private JTextField txtId;
    private JTextField txtDireccion;
    private JComboBox<String> cbTipo;

    public VentanaRegistroPedido(GestionPedidosController controller) {
        this.controller = controller;

        setTitle("SpeedFast - Registrar Pedido");
        setSize(400, 260);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        initUI();
    }

    private void initUI() {
        JPanel panelForm = new JPanel(new GridLayout(4, 2, 10, 12));
        panelForm.setBorder(BorderFactory.createEmptyBorder(20, 25, 10, 25));

        panelForm.add(new JLabel("ID de Pedido:"));
        txtId = new JTextField();
        panelForm.add(txtId);

        panelForm.add(new JLabel("Dirección de Entrega:"));
        txtDireccion = new JTextField();
        panelForm.add(txtDireccion);

        panelForm.add(new JLabel("Tipo de Pedido:"));
        String[] opciones = {"Comida", "Encomienda", "Express"};
        cbTipo = new JComboBox<>(opciones);
        panelForm.add(cbTipo);

        JButton btnGuardar = new JButton("Guardar Pedido");
        JButton btnCancelar = new JButton("Cerrar");

        panelForm.add(btnGuardar);
        panelForm.add(btnCancelar);

        add(panelForm, BorderLayout.CENTER);

        // Eventos
        btnGuardar.addActionListener(e -> guardarPedido());
        btnCancelar.addActionListener(e -> dispose());
    }

    private void guardarPedido() {
        String id = txtId.getText().trim();
        String direccion = txtDireccion.getText().trim();
        String tipo = (String) cbTipo.getSelectedItem();

        if (id.isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Todos los campos son obligatorios.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Pedido nuevo = new Pedido(id, direccion, tipo);
        boolean exito = controller.agregarPedido(nuevo);

        if (exito) {
            JOptionPane.showMessageDialog(this,
                    "¡Pedido " + id + " registrado correctamente!",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Ya existe un pedido con el ID: " + id,
                    "Error de duplicidad",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtId.setText("");
        txtDireccion.setText("");
        cbTipo.setSelectedIndex(0);
    }
}