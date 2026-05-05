
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EventosMisMails {

    // DATOS
    private MisMails mm;
    // Array de mensajes: uno por persona (índice = posición en la JList)
    private String[] mensajes;
    // Índice de la persona seleccionada actualmente en la JList
    private int seleccionActual;

    // CONSTRUCTOR
    public EventosMisMails(MisMails mm) {
        this.mm = mm;
        mensajes = new String[MisMails.MAX]; //tema de extablecer el maximo de los 
        for (int i = 0; i < MisMails.MAX; i++) mensajes[i] = "";
        seleccionActual = -1;

        // ── Botón AÑADIR ──────────────────────────────────────────────
        mm.getBtnAnadir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = mm.getTxtNombre().getText().trim();

                // Validaciones
                if (nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(mm, "El nombre no puede estar vacío.",
                            "Aviso", JOptionPane.WARNING_MESSAGE);
                    mm.getTxtNombre().requestFocus();
                    return;
                }
                if (mm.getModeloLista().size() >= MisMails.MAX) {
                    JOptionPane.showMessageDialog(mm, "Ya hay " + MisMails.MAX + " personas (máximo).",
                            "Aviso", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Añadir a la JList
                int pos = mm.getModeloLista().size();
                mm.getModeloLista().addElement(nombre);

                // Rellenar el JTextField correspondiente y habilitar su CheckBox
                mm.getArrayJTextField()[pos].setText(nombre);
                mm.getArrayJTextField()[pos].setEnabled(true);
                mm.getArrayJCheckBox()[pos].setEnabled(true);

                // Limpiar campo y devolver foco
                mm.getTxtNombre().setText("");
                mm.getTxtNombre().requestFocus();
            }
        });

        // ── Selección en la JList ──────────────────────────────────────
        mm.getLstNombres().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) return;

                // Guardar el mensaje actual antes de cambiar
                if (seleccionActual >= 0) {
                    mensajes[seleccionActual] = mm.getTxtMensaje().getText();
                }

                int nuevaPos = mm.getLstNombres().getSelectedIndex();
                if (nuevaPos == -1) return;

                // Quitar color CYAN al anterior
                if (seleccionActual >= 0) {
                    mm.getArrayJTextField()[seleccionActual].setBackground(Color.WHITE);
                }

                // Marcar en CYAN el nuevo seleccionado
                mm.getArrayJTextField()[nuevaPos].setBackground(Color.CYAN);

                // Cargar el mensaje correspondiente en el JTextArea
                mm.getTxtMensaje().setText(mensajes[nuevaPos]);

                seleccionActual = nuevaPos;
            }
        });

        // ── Doble clic en la JList → cambiar estado del CheckBox ──────
        mm.getLstNombres().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int pos = mm.getLstNombres().getSelectedIndex();
                    if (pos >= 0 && mm.getArrayJCheckBox()[pos].isEnabled()) {
                        boolean estado = mm.getArrayJCheckBox()[pos].isSelected();
                        mm.getArrayJCheckBox()[pos].setSelected(!estado);
                    }
                }
            }
        });

        // ── Modificar el mensaje → guardarlo para la persona seleccionada ─
        mm.getTxtMensaje().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (seleccionActual >= 0) {
                    mensajes[seleccionActual] = mm.getTxtMensaje().getText();
                }
            }
        });

        // ── CheckBox "Todos" ──────────────────────────────────────────
        mm.getChkTodos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean marcado = mm.getChkTodos().isSelected();
                int cantidad = mm.getModeloLista().size();
                for (int i = 0; i < cantidad; i++) {
                    // Solo los habilitados (hay personas añadidas)
                    if (mm.getArrayJCheckBox()[i].isEnabled()) {
                        mm.getArrayJCheckBox()[i].setSelected(marcado);
                    }
                }
            }
        });

        // ── Botón GUARDAR ──────────────────────────────────────────────
        mm.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Guardar mensaje actual antes de escribir
                if (seleccionActual >= 0) {
                    mensajes[seleccionActual] = mm.getTxtMensaje().getText();
                }

                // Elegir fichero con JFileChooser
                JFileChooser fc = new JFileChooser();
                fc.setDialogTitle("Guardar mensajes");
                if (fc.showSaveDialog(mm) != JFileChooser.APPROVE_OPTION) return;

                File fichero = fc.getSelectedFile();
                try (PrintWriter pw = new PrintWriter(new FileWriter(fichero))) {
                    int cantidad = mm.getModeloLista().size();
                    boolean alguienGuardado = false;
                    for (int i = 0; i < cantidad; i++) {
                        if (mm.getArrayJCheckBox()[i].isSelected()) {
                            pw.println(mm.getModeloLista().getElementAt(i));
                            pw.println(mensajes[i]);
                            alguienGuardado = true;
                        }
                    }
                    if (!alguienGuardado) {
                        JOptionPane.showMessageDialog(mm,
                                "No hay ninguna persona marcada.",
                                "Aviso", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    JOptionPane.showMessageDialog(mm, "Mensajes guardados correctamente.",
                            "Guardar", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(mm, "Error al guardar: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // ── Botón SALIR ────────────────────────────────────────────────
        mm.getBtnSalir().addActionListener(e -> System.exit(0));
    }
}