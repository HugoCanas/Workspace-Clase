import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class AreaJuego extends JPanel{
	public static final int PRESENT=0;
	public static final int JUEGO=1;

	private Cuadrado cuadrado;
	private Circulo circulo;
	private ArrayList<Cuadrado> arrayCuadrados;
	private ArrayList<Circulo> arrayCirculos;

	private String letras="ABCDEFGHIJKLMN�OPQRSTUVWXYZ";
	private JuegoLetras juegoLetras;
	private EventosAreaJuego eventosAreaJuego;
	private int estadoJuego;

	//CONSTRUCTOR
	public AreaJuego(JuegoLetras juegoLetras) {
		setBackground(Color.WHITE);
		this.juegoLetras=juegoLetras;
		estadoJuego=PRESENT;
		circulo= new Circulo(Color.PINK, Cuadrado.TAM ,Cuadrado.TAM, "a", 10,500, 5, 1,-1);
		cuadrado= new Cuadrado(Color.CYAN, Cuadrado.TAM ,Cuadrado.TAM,"A", 700,10, 5, -1,1);

		arrayCuadrados = new ArrayList<Cuadrado>();
		arrayCirculos = new ArrayList<Circulo>();

		eventosAreaJuego=new EventosAreaJuego(this); 
	}

	@Override
	public void paint(Graphics g) {
		//DIBUJA TOOOOOOOOOOOOOOOOOOOOOODOS
		// TODO Auto-generated method stub
		super.paint(g);

		if(estadoJuego==PRESENT) {
			circulo.dibujar(g);
			cuadrado.dibujar(g);
		}else {//ESTAMOS EN MODO JUEGO

			for (Cuadrado cuadrado : arrayCuadrados) {
				cuadrado.dibujar(g);
			}

			for (Circulo circulo : arrayCirculos) {
				circulo.dibujar(g);
			}
		}

	}

	public void crearObjetos() {
		int cantidad;
		Cuadrado cuadrado;
		Circulo circulo;
		// TODO Auto-generated method stub
		//INSTANCIAR LOS ARRAYLIST 
		arrayCuadrados.clear();
		arrayCirculos.clear();
		//CREAR CUADRADOS Y CIRCULOS, POSICIONARLOS 
		if(juegoLetras.getRdbtnFacil().isSelected()) {
			cantidad=5;
		}else if (juegoLetras.getRdbtnMedio().isSelected()){
			cantidad=10;
		}else {
			cantidad=15;
		}

		for(int cont=0;cont<cantidad;cont++) {
			cuadrado=new Cuadrado();
			//falta la posicion
			cuadrado.setPosX(50+(Cuadrado.TAM+Cuadrado.SEP)*(cont%5));
			cuadrado.setPosY(20+(Cuadrado.TAM+Cuadrado.SEP)*(cont/5));
			arrayCuadrados.add(cuadrado);
		}

	}

	public void crearCirculo() {

	}

	public void crearCuadrado() {

	}

	public Cuadrado getCuadrado() {
		return cuadrado;
	}

	public void setCuadrado(Cuadrado cuadrado) {
		this.cuadrado = cuadrado;
	}

	public Circulo getCirculo() {
		return circulo;
	}

	public void setCirculo(Circulo circulo) {
		this.circulo = circulo;
	}

	public ArrayList<Cuadrado> getArrayCuadrados() {
		return arrayCuadrados;
	}

	public void setArrayCuadrados(ArrayList<Cuadrado> arrayCuadrados) {
		this.arrayCuadrados = arrayCuadrados;
	}

	public ArrayList<Circulo> getArrayCirculos() {
		return arrayCirculos;
	}

	public void setArrayCirculos(ArrayList<Circulo> arrayCirculos) {
		this.arrayCirculos = arrayCirculos;
	}

	public String getLetras() {
		return letras;
	}

	public void setLetras(String letras) {
		this.letras = letras;
	}

	public JuegoLetras getJuegoLetras() {
		return juegoLetras;
	}

	public void setJuegoLetras(JuegoLetras juegoLetras) {
		this.juegoLetras = juegoLetras;
	}

	public EventosAreaJuego getEventosAreaJuego() {
		return eventosAreaJuego;
	}

	public void setEventosAreaJuego(EventosAreaJuego eventosAreaJuego) {
		this.eventosAreaJuego = eventosAreaJuego;
	}

	public int getEstadoJuego() {
		return estadoJuego;
	}

	public void setEstadoJuego(int estadoJuego) {
		this.estadoJuego = estadoJuego;
	}


}
