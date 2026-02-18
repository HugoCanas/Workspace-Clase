import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class GestionCorreo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JTextField txtWeb;
	private JCheckBox chckbxEmpleado;
	private JButton btnAnadir;
	private JTextField textEdad;
	private JTextField textDireccion;
	private JTextField textTelefono;
	private JScrollPane scrollPane;
	private JList <String> lstNombres;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_3;
	private JList <String> lstCorreo;
	private JScrollPane scrollPane_2;
	private JList <String> lstWebs;
	private DefaultListModel<String>modeloNombres,modeloCorreos,modeloWebs;
	private JPanel panelEmpleado;
	private ArrayList<Persona> arrayPersonas; 
	private JButton btnCargarBD;
	private JButton btnGuardarBD;

	private BaseDatos bd;
	private JButton btnEnviarMail;
	private EnviarMail enviarMail;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionCorreo frame = new GestionCorreo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public GestionCorreo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(70, 42, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setBounds(70, 72, 46, 14);
		contentPane.add(lblCorreo);

		JLabel lblWeb = new JLabel("Web:");
		lblWeb.setBounds(70, 109, 46, 14);
		contentPane.add(lblWeb);

		txtNombre = new JTextField();
		txtNombre.setBounds(126, 39, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);

		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(126, 69, 159, 20);
		contentPane.add(txtCorreo);

		txtWeb = new JTextField();
		txtWeb.setColumns(10);
		txtWeb.setBounds(126, 106, 86, 20);
		contentPane.add(txtWeb);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setBounds(352, 105, 89, 23);
		contentPane.add(btnAnadir);

		chckbxEmpleado = new JCheckBox("Empleado");
		chckbxEmpleado.setSelected(true);
		chckbxEmpleado.setBounds(352, 38, 97, 23);
		contentPane.add(chckbxEmpleado);

		panelEmpleado = new JPanel();
		panelEmpleado.setBounds(500, 24, 263, 126);
		contentPane.add(panelEmpleado);
		panelEmpleado.setLayout(null);

		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 11, 46, 14);
		panelEmpleado.add(lblEdad);

		JLabel lblNewLabel_1_1 = new JLabel("Direccion");
		lblNewLabel_1_1.setBounds(10, 52, 46, 14);
		panelEmpleado.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Telefono");
		lblNewLabel_1_1_1.setBounds(10, 101, 46, 14);
		panelEmpleado.add(lblNewLabel_1_1_1);

		textEdad = new JTextField();
		textEdad.setColumns(10);
		textEdad.setBounds(66, 8, 86, 20);
		panelEmpleado.add(textEdad);

		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(66, 49, 86, 20);
		panelEmpleado.add(textDireccion);

		textTelefono = new JTextField();
		textTelefono.setColumns(10);
		textTelefono.setBounds(66, 98, 86, 20);
		panelEmpleado.add(textTelefono);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 195, 131, 216);
		contentPane.add(scrollPane);

		lstNombres = new JList<String>();
		scrollPane.setViewportView(lstNombres);
		modeloNombres=new DefaultListModel<String>();
		lstNombres.setModel(modeloNombres);

		lblNewLabel_1 = new JLabel("Nombres:");
		lblNewLabel_1.setBounds(49, 170, 46, 14);
		contentPane.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("Correos:");
		lblNewLabel_2.setBounds(275, 170, 46, 14);
		contentPane.add(lblNewLabel_2);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(258, 195, 131, 216);
		contentPane.add(scrollPane_1);

		lstCorreo = new JList<String>();
		scrollPane_1.setRowHeaderView(lstCorreo);
		modeloCorreos=new DefaultListModel<String>();
		lstCorreo.setModel(modeloCorreos);

		lblNewLabel_3 = new JLabel("Webs:");
		lblNewLabel_3.setBounds(487, 170, 46, 14);
		contentPane.add(lblNewLabel_3);

		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(466, 195, 131, 216);
		contentPane.add(scrollPane_2);

		lstWebs = new JList<String>();
		scrollPane_2.setViewportView(lstWebs);
		modeloWebs=new DefaultListModel<String>();
		lstWebs.setModel(modeloWebs);

		btnGuardarBD = new JButton("GuardarID");
		btnGuardarBD.setBounds(636, 215, 89, 23);
		contentPane.add(btnGuardarBD);

		btnCargarBD = new JButton("CargarID");
		btnCargarBD.setBounds(636, 258, 89, 23);
		contentPane.add(btnCargarBD);
		
		btnEnviarMail = new JButton("Enviar Mail");
		btnEnviarMail.setBounds(636, 302, 89, 23);
		contentPane.add(btnEnviarMail);

		Persona per;
		Empleado emp;
		per = new Persona();
		per.getNombre();
		emp = new Empleado();
		emp.getCorreo();

		arrayPersonas=new ArrayList<Persona>();
		bd=new BaseDatos();
		registrarEventos();

		arrayPersonas.add(emp);

	}//FIN DEL CONSTRUCTOR

	
	
	private void seleccionarListas(int selectedIndex) {
		// TODO Auto-generated method stub
		lstNombres.setSelectedIndex(selectedIndex);
		lstCorreo.setSelectedIndex(selectedIndex);
		lstWebs.setSelectedIndex(selectedIndex); //Para seleccionar y que se cambien en todas las listas a la vez

	}

	private void registrarEventos() {
		btnEnviarMail.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Crear una nueva instancia de la clase EnviarMail y ponerla visible 
				enviarMail= new EnviarMail(GestionCorreo.this);
				enviarMail.setVisible(true);
				GestionCorreo.this.setVisible(false);
				enviarMail.recibirDatos();
				
			}
		});
		
		
		btnGuardarBD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//RECORRER EL ARRAYLIST Y PARA CADA OBJETO INSERTARLO EN LA BD COMO PERSONA O COMO EMPLEADO, SOLO SI NO HA SIDO GUARDADO PREVIAMENTE 
				for (Persona per : arrayPersonas) {
					if(per.getEstado()==(per.NUEVO)) {
						if(bd.insertar(per)==1) {
							per.setEstado(per.GUARDADO);
						}
					}
				}
			}
		});

		btnCargarBD.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ResultSet rs;
				Persona per;
				Empleado emp;
				rs=bd.ObtenerTodos();
				int resultado = JOptionPane.showConfirmDialog(GestionCorreo.this, "Vas a sobreescribir la informacion, esta seguro?", "Aviso", 
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				//MENSAJE DE AVISO Y PEDIR CONFIRMACION
				
				if(resultado == JOptionPane.YES_OPTION ) {
					modeloNombres.clear();
					modeloCorreos.clear();
					modeloWebs.clear();
					try {
						if(rs.first()) {
							do {
								per= new Persona(rs.getString("nombre"), rs.getString("correo"), rs.getString("web"));
								per.setEstado(Persona.GUARDADO);
								per.setIdPersona(rs.getInt("id"));
								if(rs.getBoolean("esEmpleado")) {
									emp=new Empleado(per,rs.getInt("edad"),rs.getString("direccion"),rs.getString("telefono"));
									emp.setEstado(Persona.GUARDADO);
									arrayPersonas.add(emp);
								}else {
									arrayPersonas.add(per);
								}
								modeloNombres.addElement(per.getNombre());
								modeloCorreos.addElement(per.getCorreo());
								modeloWebs.addElement(per.getWeb());
							}while(rs.next());
						}
					} catch(SQLException e1) {
						e1.printStackTrace();
					}
				}else {
					
				}
			}
		});

		lstNombres.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				seleccionarListas(lstNombres.getSelectedIndex());

			}


		});

		lstCorreo.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				seleccionarListas(lstCorreo.getSelectedIndex());

			}


		});

		lstWebs.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				seleccionarListas(lstWebs.getSelectedIndex());

			}


		});

		chckbxEmpleado.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {//DEL ITEM LISTENER
				//si esta marcado pongo visible el panel sino pongo invisible el panel 
				panelEmpleado.setVisible(chckbxEmpleado.isSelected());
			}
		});

		btnAnadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Persona per;
				Empleado emp;
				// TODO Auto-generated method stub
				//EL NOMBRE ES OBLIGATORIO

				if(txtNombre.getText().trim().equals("")) {
					txtNombre.requestFocus(); //PARA METERME EN EL TEXTO
					txtNombre.selectAll(); //PARA RESALTAR LO QUE SE HA ESCRITO 
					return;
				}

				per=new Persona(txtNombre.getText().trim(), txtCorreo.getText().trim(), txtWeb.getText().trim());

				if(!per.esCorreoCorrecto()) {
					txtCorreo.requestFocus();
					txtCorreo.selectAll();
					return;
				}


				//CREAR UN OBJETO DE CLASE PERSONA O EMPLEADO CON LOS DATOS DE LOS JTEXTFIELD Y AÑADIRLO AL ARRAYLIST
				per=new Persona(txtNombre.getText().trim(), txtCorreo.getText().trim(), txtWeb.getText().trim());

				if(chckbxEmpleado.isSelected()) {
					try {
						emp=new Empleado(per, Integer.parseInt(textEdad.getText().trim()),textDireccion.getText().trim(),textTelefono.getText().trim());
						arrayPersonas.add(emp);
					}catch(NumberFormatException e1) {
						textEdad.requestFocus();
						textEdad.selectAll();
						return;
					}
				}else {//ES UNA PERSONA
					arrayPersonas.add(per);
				}
				//AÑADIR LOS DATOS DE LOS JTEXTFIELD (O DEL OBJETO PERSONA) A LOS JLIST
				modeloNombres.addElement(per.getNombre());
				if(per.getCorreo().trim().equals("")) {
					modeloCorreos.addElement(" ");
				}else {
					modeloCorreos.addElement(per.getCorreo());
				}
				if(per.getWeb().trim().equals("")) {
					modeloWebs.addElement(" ");
				}else{
					modeloWebs.addElement(per.getWeb());
				}
				txtNombre.setText("");
				txtCorreo.setText("");
				txtWeb.setText("");
				textEdad.setText("");
				textDireccion.setText("");
				textTelefono.setText("");
				txtNombre.requestFocus();
			}

		});
	}


	public JList<String> getLstNombres() {
		return lstNombres;
	}


	public void setLstNombres(JList<String> lstNombres) {
		this.lstNombres = lstNombres;
	}


	public JList<String> getLstCorreo() {
		return lstCorreo;
	}


	public void setLstCorreo(JList<String> lstCorreo) {
		this.lstCorreo = lstCorreo;
	}


	public JList<String> getLstWebs() {
		return lstWebs;
	}


	public void setLstWebs(JList<String> lstWebs) {
		this.lstWebs = lstWebs;
	}


	public ArrayList<Persona> getArrayPersonas() {
		return arrayPersonas;
	}


	public void setArrayPersonas(ArrayList<Persona> arrayPersonas) {
		this.arrayPersonas = arrayPersonas;
	}


	public BaseDatos getBd() {
		return bd;
	}


	public void setBd(BaseDatos bd) {
		this.bd = bd;
	}
}
