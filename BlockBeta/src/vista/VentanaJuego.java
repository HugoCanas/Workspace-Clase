package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaJuego extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private PanelJuego panelJuego;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaJuego frame = new VentanaJuego();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public VentanaJuego() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Block Blast");
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        panelJuego = new PanelJuego();
        contentPane.add(panelJuego, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}