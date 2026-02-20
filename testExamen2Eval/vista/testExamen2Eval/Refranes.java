package testExamen2Eval;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class Refranes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnCargar;
	private JRadioButton rdRefran1;
	private JRadioButton rdRefran2;
	private JRadioButton rdRefran3;
	private JList <String> lstPalabras;
	private JButton btnSubir;
	private JButton btnBajar;
	private JButton btnEliminar;
	private JButton btnSalir;

	
	private ButtonGroup grpBotones;
	private String strRefran;
	private DefaultListModel <String> modelo;
	private EventosRefranes eventosRefranes;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refranes frame = new Refranes();
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
	public Refranes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdRefran1 = new JRadioButton("Refran 1");
		rdRefran1.setSelected(true);
		rdRefran1.setBounds(110, 40, 109, 23);
		contentPane.add(rdRefran1);
		
		rdRefran2 = new JRadioButton("Refran 2");
		rdRefran2.setBounds(279, 40, 109, 23);
		contentPane.add(rdRefran2);
		
		rdRefran3 = new JRadioButton("Refran 3");
		rdRefran3.setBounds(465, 40, 109, 23);
		contentPane.add(rdRefran3);
		
		grpBotones=new ButtonGroup();
		grpBotones.add(rdRefran1);
		grpBotones.add(rdRefran2);
		grpBotones.add(rdRefran3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 103, 265, 265);
		contentPane.add(scrollPane);
		
		lstPalabras = new JList();
		scrollPane.setViewportView(lstPalabras);

		modelo= new DefaultListModel<String>();
		lstPalabras.setModel(modelo);
		
		btnCargar = new JButton("Cargar Refranes");
		btnCargar.setBounds(486, 87, 118, 23);
		contentPane.add(btnCargar);
		
		btnSubir = new JButton("Subir");
		btnSubir.setBounds(49, 422, 89, 23);
		contentPane.add(btnSubir);
		
		btnBajar = new JButton("Bajar");
		btnBajar.setBounds(208, 422, 89, 23);
		contentPane.add(btnBajar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(370, 422, 89, 23);
		contentPane.add(btnEliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(543, 422, 89, 23);
		contentPane.add(btnSalir);

		eventosRefranes=new EventosRefranes(this);
		
	}//FIN DEL CONSTRUCTOR

	public JButton getBtnCargar() {
		return btnCargar;
	}

	public void setBtnCargar(JButton btnCargar) {
		this.btnCargar = btnCargar;
	}

	public JRadioButton getRdRefran1() {
		return rdRefran1;
	}

	public void setRdRefran1(JRadioButton rdRefran1) {
		this.rdRefran1 = rdRefran1;
	}

	public JRadioButton getRdRefran2() {
		return rdRefran2;
	}

	public void setRdRefran2(JRadioButton rdRefran2) {
		this.rdRefran2 = rdRefran2;
	}

	public JRadioButton getRdRefran3() {
		return rdRefran3;
	}

	public void setRdRefran3(JRadioButton rdRefran3) {
		this.rdRefran3 = rdRefran3;
	}

	

	public JButton getBtnSubir() {
		return btnSubir;
	}

	public void setBtnSubir(JButton btnSubir) {
		this.btnSubir = btnSubir;
	}

	public JButton getBtnBajar() {
		return btnBajar;
	}

	public void setBtnBajar(JButton btnBajar) {
		this.btnBajar = btnBajar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public ButtonGroup getGrpBotones() {
		return grpBotones;
	}

	public void setGrpBotones(ButtonGroup grpBotones) {
		this.grpBotones = grpBotones;
	}

	public String getStrRefran() {
		return strRefran;
	}

	public void setStrRefran(String strRefran) {
		this.strRefran = strRefran;
	}

	public DefaultListModel<String> getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel<String> modelo) {
		this.modelo = modelo;
	}

	public JList<String> getLstPalabras() {
		return lstPalabras;
	}

	public void setLstPalabras(JList<String> lstPalabras) {
		this.lstPalabras = lstPalabras;
	}

	
	
}
