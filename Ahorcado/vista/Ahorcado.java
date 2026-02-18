import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

public class Ahorcado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnNueva;
	private JButton btnSalir;
	private JLabel lblPalabra;
	private ArrayList <String> arrayPalabras;
	private int numFallos;
	private Fichero fichero;

	
	private Teclado teclado;
	private JPanel panelCentro;
	private AreaDibujo areaDibujo;
	
	private EventosAhorcado eventosAhorcado;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ahorcado frame = new Ahorcado();
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
	public Ahorcado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		lblPalabra = new JLabel("_ _ _ _ _ _ _ _ _");
		lblPalabra.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblPalabra.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPalabra, BorderLayout.NORTH);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);		
		panelSur.setLayout(new GridLayout(0, 2, 0, 0));
		btnNueva = new JButton("Nueva Palabra");
		panelSur.add(btnNueva);
		
		btnSalir = new JButton("Salir");
		panelSur.add(btnSalir);
		
		panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		teclado=new Teclado(this);
		panelCentro.add(teclado);
		
		areaDibujo = new AreaDibujo(this);
		panelCentro.add(areaDibujo);
		
		
		eventosAhorcado= new EventosAhorcado(this);
		
		fichero= new Fichero();
		arrayPalabras=fichero.cargarPalabras("Palabras.txt");

		 elegirPalabra();
		
	}

	public void elegirPalabra() {
		//ELIGE UNA PALABRA AL AZAR DEL ARRAYLIST
		Random r;
		String palabra;
		int pos;
		
		if(arrayPalabras.size()==0) {
			JOptionPane.showInternalMessageDialog(null, "No quedan palabras");
			return;
		}
		
		//ELIGE UNA PALABRA AL AZAR DEL ARRAYLIST
		r=new Random();
		pos=r.nextInt(arrayPalabras.size());
		palabra = arrayPalabras.get(pos);
		//LA ELIMINA DEL ARRAYLIST
		arrayPalabras.remove(pos);
		//REINICIA LOS BOTONES (COLOR Y ENABLED)
		teclado.estadoTeclado(true);
		//REINICIA EL CANVAS, PERO UNICAMENTE LOS FALLOS Y REPINTAR
		numFallos=0; //----------------------------------------------------LUEGO CAMBIARLO----------------------------------------------------
		areaDibujo.repaint();
		//PONE TANTOS GUIONES (SEGUIDOS DE UN ESPACIO) COMO LETRAS TENGA LA PALABRA
		lblPalabra.setText("");		
		for (int i=0; i<palabra.length(); i++) {
			lblPalabra.setText(lblPalabra.getText()+ "_ ");
		}
		teclado.setPalabra(palabra);
	}
	
	//GETTERS / SETTERS
	public ArrayList<String> getArrayPalabras() {
		return arrayPalabras;
	}

	public void setArrayPalabras(ArrayList<String> arrayPalabras) {
		this.arrayPalabras = arrayPalabras;
	}

	public int getNumFallos() {
		return numFallos;
	}

	public void setNumFallos(int numFallos) {
		this.numFallos = numFallos;
	}

	public JButton getBtnNueva() {
		return btnNueva;
	}

	public void setBtnNueva(JButton btnNueva) {
		this.btnNueva = btnNueva;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JLabel getLblPalabra() {
		return lblPalabra;
	}

	public void setLblPalabra(JLabel lblPalabra) {
		this.lblPalabra = lblPalabra;
	}

	public Teclado getTeclado() {
		return teclado;
	}

	public void setTeclado(Teclado teclado) {
		this.teclado = teclado;
	}

	public AreaDibujo getAreaDibujo() {
		return areaDibujo;
	}

	public void setAreaDibujo(AreaDibujo areaDibujo) {
		this.areaDibujo = areaDibujo;
	}

}
