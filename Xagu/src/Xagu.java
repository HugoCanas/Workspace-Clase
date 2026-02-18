import java.awt.EventQueue;
import java.awt.FileDialog;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Xagu extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int FILAS=10;
	public static final int COLS=10;
	private JPanel contentPane;
	private JButton btnCargar;
	private JButton btnBuscar;
	private JButton btnSalir;

	private JLabel [][]casillas; 
	private JPanel panelLaberinto;
	private int filaXagu, colXagu;
	private boolean salidaEncontrada;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Xagu frame = new Xagu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	public Xagu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelBotones = new JPanel();
		contentPane.add(panelBotones, BorderLayout.NORTH);

		btnCargar = new JButton("Cargar");
		panelBotones.add(btnCargar);

		btnBuscar = new JButton("Buscar");
		panelBotones.add(btnBuscar);

		btnSalir = new JButton("Salir");
		panelBotones.add(btnSalir);

		panelLaberinto = new JPanel();
		contentPane.add(panelLaberinto, BorderLayout.CENTER);
		panelLaberinto.setLayout(new GridLayout(FILAS,COLS, 0, 0));

		crearLabels();
		registrarEventos();

	}//FIN DEL CONSTRUCTOR

	public void registrarEventos() {
		btnCargar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cargarMapa();

			}
		});
		
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				buscarSalida(casillas,filaXagu,colXagu);
			}
		});
	}
	
	public void buscarSalida(JLabel[][] casillas,int filaXagu,int colXagu) {
		if(filaXagu==0 || filaXagu==FILAS-1 || colXagu==0 || colXagu==COLS-1) {
			//MARCAR CAMINO
			casillas[filaXagu][colXagu].setText("€");
			salidaEncontrada=true;
			return; //para evitar un else
		}
		//LLAMADAS RECURSIVAS
		casillas[filaXagu][colXagu].setText("-");
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//HACIA ARRIBA
		if(!salidaEncontrada && casillas[filaXagu-1][colXagu].getText().equals("")){
			buscarSalida(casillas,filaXagu-1,colXagu);
		}
		//HACIA DERECHA
		if(!salidaEncontrada && casillas[filaXagu][colXagu+1].getText().equals("")){
			buscarSalida(casillas,filaXagu,colXagu+1);
		}
		//HACIA ABAJO
		if(!salidaEncontrada && casillas[filaXagu+1][colXagu].getText().equals("")){
			buscarSalida(casillas,filaXagu+1,colXagu);
		}
		//HACIA IZQUIERDA
		if(!salidaEncontrada && casillas[filaXagu][colXagu-1].getText().equals("")){
			buscarSalida(casillas,filaXagu,colXagu-1);
		}
		
		if(salidaEncontrada) {
			casillas[filaXagu][colXagu].setText("€");
		}
		
	}

	public void cargarMapa() {
		// TODO Auto-generated method stub
		Scanner scFich;
		FileDialog dlgMapa;
		String linea;
		String fich;
		
		salidaEncontrada=false;

		dlgMapa=new FileDialog(this,"Cargar Mapa", FileDialog.LOAD);
		//dlgMapa.setDirectory(System.getProperty("user.home")+"\\Desktop"); //Establezco la ruta del usuario de el programa a el escritorio
		dlgMapa.setDirectory(".\\img");
		dlgMapa.setVisible(true);
		fich=dlgMapa.getFile();



		if(fich!=null) {
			try {
				scFich=new Scanner(new File(dlgMapa.getDirectory()+fich));
				//scFich=new Scanner(new File(getClass().getResources(fich)+(fich));
				int fila=0;
				while(scFich.hasNext()){
					//LEER LINEA
					linea=scFich.nextLine();
					//PROCESAR LINEA
					for(int col=0;col<COLS;col++) {
						/*SI ES 0 -> QUITAR + (VACIAR CASILLA)
						 * SI ES UN 1 -> CARGAR IMAGEN MURO.JPG
						 * SI ES UN 2 -> CARGAR IMAGEN XAGU.JPG
						 */
						if(linea.charAt(col)=='0'){
							casillas[fila][col].setText("");
							casillas[fila][col].setIcon(null);
						}
						if(linea.charAt(col)=='1') {
							//cargar Fichero imagen 
							casillas[fila][col].setIcon(new ImageIcon(getClass().getResource("muro.jpg")));
							casillas[fila][col].setText("*");
						}
						if(linea.charAt(col)=='2') {
							//cargar Fichero imagen 
							casillas[fila][col].setIcon(new ImageIcon(getClass().getResource("xagu.jpg")));
							casillas[fila][col].setText("*");
							filaXagu=fila;
							colXagu=col;
						}
					}
					fila++;
				}
				scFich.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



	public void crearLabels() {
		JLabel lblAux; //DECLARADO
		//DIMENSIONAR EL ARRAY DE CASILLAS
		//INSTANCIA
		casillas = new JLabel[FILAS][COLS]; //INSTANCIA


		//CREAR LOS 100 JLabels CON SUS CARACTERISTICAS
		//TEXTO,TAMAÑO,POSICION,COLOR,ETC...
		//AÑADIRLO AL PANEL 
		//AÑADIRLO AL ARRAY

		for(int fila=0;fila<FILAS;fila++) {
			for(int col=0;col<COLS;col++) {
				lblAux=new JLabel("*");
				lblAux.setHorizontalAlignment(JLabel.CENTER);
				lblAux.setFont(new Font("Arial",Font.BOLD,20));
				panelLaberinto.add(lblAux);
				casillas[fila][col]=lblAux;
			}
		}
	}

}
