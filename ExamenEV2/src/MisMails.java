
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class MisMails extends JFrame {

	private static final long serialVersionUID = 1L;
	public static final int MAX = 8;

	// COMPONENTES
	private JPanel contentPane;
	private JList<String> lstNombres;
	private DefaultListModel<String> modeloLista;
	private JTextField[] arrayJTextField;
	private JCheckBox[] arrayJCheckBox;
	private JCheckBox chkTodos;
	private JTextField txtNombre;
	private JTextArea txtMensaje;
	private JButton btnAnadir;
	private JButton btnGuardar;
	private JButton btnSalir;

	// MAIN
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				MisMails frame = new MisMails();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	// CONSTRUCTOR
	public MisMails() {
		setTitle("MisMails");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 80, 680, 500);

		contentPane = new JPanel(new BorderLayout(6, 6));
		contentPane.setBorder(new EmptyBorder(8, 8, 8, 8));
		setContentPane(contentPane);

		// ── PANEL IZQUIERDO: JList ────────────────────────────────────
		JPanel panelIzq = new JPanel(new BorderLayout(4, 4));
		panelIzq.setPreferredSize(new Dimension(140, 0));
		panelIzq.setBorder(new TitledBorder("Contactos"));

		modeloLista = new DefaultListModel<>();
		lstNombres = new JList<>(modeloLista);
		lstNombres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panelIzq.add(new JScrollPane(lstNombres), BorderLayout.CENTER);

		// Parte inferior izquierda: campo nombre + botón Añadir
		JPanel panelAnadir = new JPanel(new BorderLayout(4, 4));
		panelAnadir.add(new JLabel("Nombre:"), BorderLayout.NORTH);
		txtNombre = new JTextField();
		panelAnadir.add(txtNombre, BorderLayout.CENTER);
		btnAnadir = new JButton("Añadir");
		panelAnadir.add(btnAnadir, BorderLayout.SOUTH);
		panelIzq.add(panelAnadir, BorderLayout.SOUTH);

		contentPane.add(panelIzq, BorderLayout.WEST);

		// ── PANEL CENTRAL: arrays de JTextField y JCheckBox ──────────
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(new TitledBorder("Lista de destinatarios"));

		arrayJTextField = new JTextField[MAX];
		arrayJCheckBox  = new JCheckBox[MAX];

		for (int i = 0; i < MAX; i++) {
			JPanel fila = new JPanel(new BorderLayout(4, 2));
			fila.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

			arrayJTextField[i] = new JTextField();
			arrayJTextField[i].setEnabled(false);
			arrayJTextField[i].setBackground(Color.WHITE);

			arrayJCheckBox[i] = new JCheckBox();
			arrayJCheckBox[i].setEnabled(false);

			fila.add(arrayJTextField[i], BorderLayout.CENTER);
			fila.add(arrayJCheckBox[i], BorderLayout.EAST);
			panelCentro.add(fila);
			panelCentro.add(Box.createVerticalStrut(2));
		}

		// CheckBox "Todos" al final
		chkTodos = new JCheckBox("Todos");
		JPanel filaTodos = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		filaTodos.add(chkTodos);
		panelCentro.add(filaTodos);

		contentPane.add(panelCentro, BorderLayout.CENTER);

		// ── PANEL DERECHO: Guardar + TextArea del mensaje ─────────────
		JPanel panelDer = new JPanel(new BorderLayout(4, 4));
		panelDer.setPreferredSize(new Dimension(200, 0));
		panelDer.setBorder(new TitledBorder("Texto del mensaje:"));

		btnGuardar = new JButton("Guardar fichero");
		panelDer.add(btnGuardar, BorderLayout.NORTH);

		txtMensaje = new JTextArea();
		txtMensaje.setLineWrap(true);
		txtMensaje.setWrapStyleWord(true);
		panelDer.add(new JScrollPane(txtMensaje), BorderLayout.CENTER);

		contentPane.add(panelDer, BorderLayout.EAST);

		// ── PANEL SUR: botón Salir ────────────────────────────────────
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		btnSalir = new JButton("Salir");
		panelSur.add(btnSalir);
		contentPane.add(panelSur, BorderLayout.SOUTH);

		// ── CONTROLADOR ───────────────────────────────────────────────
		new EventosMisMails(this);
	}

	// ── GETTERS ──────────────────────────────────────────────────────
	public JList<String> getLstNombres()             {
		return lstNombres; }
	public DefaultListModel<String> getModeloLista() {
		return modeloLista; }
	public JTextField[] getArrayJTextField()         { 
		return arrayJTextField; }
	public JCheckBox[] getArrayJCheckBox()           { 
		return arrayJCheckBox; }
	public JCheckBox getChkTodos()                   { 
		return chkTodos; }
	public JTextField getTxtNombre()                 { 
		return txtNombre; }
	public JTextArea getTxtMensaje()                 { 
		return txtMensaje; }
	public JButton getBtnAnadir()                    { 
		return btnAnadir; }
	public JButton getBtnGuardar()                   {
		return btnGuardar; }
	public JButton getBtnSalir()                     { 
		return btnSalir; }
}