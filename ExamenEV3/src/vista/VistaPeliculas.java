package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;

public class VistaPeliculas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnA;
	private JButton btnE;
	private JButton btnI;
	private JButton btnO;
	private JButton btnU;
	private JButton btnTodos;
	private JButton btnMover1;
	private JButton btnMover2;
	private JComboBox <String> comboAnio; //necesita addItem


	private JButton btnSalir;
	private JButton btnGuardar;
	private JList <String> listIzq;
	private JList <String> listDcha;
	private File fichero;
	private DefaultListModel <String> modelo;
	private DefaultListModel <String> modeloAnios;
	private String strPelicula;
	private String inception= "Inception";
	private String inside_out= "Inside Out";
	private String ironMan= "Iron Man 3";



	//private AreaPeliculas areaPeliculas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPeliculas frame = new VistaPeliculas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaPeliculas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 999, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cargar del Fichero");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(31, 11, 117, 14);
		contentPane.add(lblNewLabel);

		btnTodos = new JButton("Todos");
		btnTodos.setBounds(10, 36, 182, 23);
		contentPane.add(btnTodos);

		btnA = new JButton("A");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnA.setBounds(10, 65, 60, 23);
		contentPane.add(btnA);

		btnE = new JButton("E");
		btnE.setBounds(80, 65, 47, 23);
		contentPane.add(btnE);

		btnI = new JButton("I");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnI.setBounds(137, 65, 55, 23);
		contentPane.add(btnI);

		btnO = new JButton("O");
		btnO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnO.setBounds(199, 65, 46, 23);
		contentPane.add(btnO);

		btnU = new JButton("U");
		btnU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnU.setBounds(255, 65, 46, 23);
		contentPane.add(btnU);

		listIzq = new JList<String>();
		listIzq.setBounds(20, 99, 209, 247);
		contentPane.add(listIzq);

		comboAnio = new JComboBox<String>();
		comboAnio.setToolTipText("Desconocido");
		comboAnio.setBounds(37, 379, 137, 23);
		contentPane.add(comboAnio);

		modelo= new DefaultListModel<String>();
		listIzq.setModel(modelo);
		modelo.addElement(inception);
		modelo.addElement(inside_out);
		modelo.addElement(ironMan);



		modeloAnios= new DefaultListModel<String>();
		//listDcha.setModel(modeloAnios);


		JLabel lblNewLabel_1 = new JLabel("Año:");
		lblNewLabel_1.setBounds(10, 383, 46, 14);
		contentPane.add(lblNewLabel_1);

		btnMover1 = new JButton(">>");
		btnMover1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMover1.setBounds(262, 208, 62, 30);
		contentPane.add(btnMover1);

		listDcha = new JList<String>();
		listDcha.setBounds(355, 99, 201, 247);
		contentPane.add(listDcha);



		btnMover2 = new JButton(">>");
		btnMover2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMover2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMover2.setBounds(616, 208, 62, 30);
		contentPane.add(btnMover2);

		JPanel panelPeliculas = new JPanel();
		panelPeliculas.setBounds(721, 99, 209, 253);
		contentPane.add(panelPeliculas);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(384, 379, 89, 23);
		contentPane.add(btnGuardar);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(224, 429, 89, 23);
		contentPane.add(btnSalir);

		/*areaPeliculas = new AreaPeliculas(this);
		contentPane.add(areaPeliculas, BorderLayout.CENTER);*/

		//new EventosPeliculas(this);
		LlenarComboBox();
		RegistrarEventos();
	}





	public DefaultListModel<String> getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel<String> modelo) {
		this.modelo = modelo;
	}

	private void LlenarComboBox() {
		// TODO Auto-generated method stub

		for (int contador=1930; contador<2036;contador++) {	
			comboAnio.addItem(String.valueOf(contador));; 
		}
	}



	public void LeerFicheroLetraE() {
		String fichero;
		Scanner scFichero;

		fichero="peliculas.txt";


		try {
			scFichero= new Scanner(new File(fichero));
			getModelo().clear();
			//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
			//NO SE COMO HACER QUE LEA UNA SI Y UNA NO HE INTENDADO MIL COSAS
			// 3. Cargar el resto de líneas en la lista
			while(scFichero.hasNext()){ 
				if(scFichero.nextLine().startsWith("E")) {
					getModelo().addElement(scFichero.next());
				}
				scFichero.nextLine();//salto de linea
			}
			scFichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LeerFicheroLetraI() {
		String fichero;
		Scanner scFichero;

		fichero="peliculas.txt";


		try {
			scFichero= new Scanner(new File(fichero));
			getModelo().clear();
			//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
			//NO SE COMO HACER QUE LEA UNA SI Y UNA NO HE INTENDADO MIL COSAS
			// 3. Cargar el resto de líneas en la lista
			while(scFichero.hasNext()){ 
				if(scFichero.nextLine().startsWith("I")) {
					getModelo().addElement(scFichero.next());
				}
				scFichero.nextLine();//salto de linea
			}
			scFichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LeerFicheroLetraO() {
		String fichero;
		Scanner scFichero;

		fichero="peliculas.txt";


		try {
			scFichero= new Scanner(new File(fichero));
			getModelo().clear();
			//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
			//NO SE COMO HACER QUE LEA UNA SI Y UNA NO HE INTENDADO MIL COSAS
			// 3. Cargar el resto de líneas en la lista
			while(scFichero.hasNext()){ 
				if(scFichero.nextLine().startsWith("I")) {
					getModelo().addElement(scFichero.next());
				}
				scFichero.nextLine();//salto de linea
			}
			scFichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LeerFicheroLetraU() {
		String fichero;
		Scanner scFichero;

		fichero="peliculas.txt";


		try {
			scFichero= new Scanner(new File(fichero));
			getModelo().clear();
			//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
			//NO SE COMO HACER QUE LEA UNA SI Y UNA NO HE INTENDADO MIL COSAS
			// 3. Cargar el resto de líneas en la lista
			while(scFichero.hasNext()){ 
				if(scFichero.nextLine().startsWith("U")) {
					getModelo().addElement(scFichero.next());
				}
				scFichero.nextLine();//salto de linea
			}
			scFichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LeerFicheroLetraA() {
		String fichero;
		Scanner scFichero;

		fichero="peliculas.txt";


		try {
			scFichero= new Scanner(new File(fichero));
			getModelo().clear();
			//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
			//NO SE COMO HACER QUE LEA UNA SI Y UNA NO HE INTENDADO MIL COSAS
			// 3. Cargar el resto de líneas en la lista
			while(scFichero.hasNext()){ 
				if(scFichero.nextLine().startsWith("A")) {
					getModelo().addElement(scFichero.next());
				}
				scFichero.nextLine();//salto de linea
			}
			scFichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void LeerFicheroNombres() {
		// TODO Auto-generated method stub

		String fichero;
		Scanner scFichero;

		fichero="peliculas.txt";

		try {
			scFichero= new Scanner(new File(fichero));
			getModelo().clear();
			//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
			//NO SE COMO HACER QUE LEA UNA SI Y UNA NO HE INTENDADO MIL COSAS
			// 3. Cargar el resto de líneas en la lista
			while(scFichero.hasNext()){ 
				getModelo().addElement(scFichero.nextLine());
				scFichero.nextLine();//salto de linea
			}
			scFichero.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void RegistrarEventos() {

		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		/*btnMover1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//PARA EL CAMBIO DE LOS JLIST
				//SE QUE LO HEMOS HECHO PERO NO ENCUENTRO DONDE
				if(comboAnio.getSelectedItem()=="Desconocido") {
					getModeloAnios().addElement("?????"+listIzq.getSelectedValue());  
				}else {
					getModeloAnios().addElement(comboAnio.getSelectedItem()+listIzq.getSelectedValue());
				}
			}
		});*/

		btnTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerFicheroNombres();
			}
		});

		btnA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerFicheroLetraA();
			}
		});

		btnE.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerFicheroLetraE();
			}
		});

		btnI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerFicheroLetraI();
			}
		});

		btnO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerFicheroLetraO();
			}
		});

		btnU.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LeerFicheroLetraU();
			}
		});



	}

	public DefaultListModel<String> getModeloAnios() {
		return modeloAnios;
	}

	public void setModeloAnios(DefaultListModel<String> modeloAnios) {
		this.modeloAnios = modeloAnios;
	}

	public JComboBox<String> getComboAnio() {
		return comboAnio;
	}

	public void setComboAnio(JComboBox<String> comboAnio) {
		this.comboAnio = comboAnio;
	}


}
