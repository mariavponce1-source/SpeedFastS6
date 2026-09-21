package main;

import view.VentanaPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // Ejecución en el Event Dispatch Thread (EDT) de Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Look and Feel del sistema operativo para una apariencia moderna
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {
            }

            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}