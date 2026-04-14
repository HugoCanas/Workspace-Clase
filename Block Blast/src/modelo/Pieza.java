package modelo;

import java.awt.Color;
import java.util.Random;

public class Pieza {

	private static final Color[] COLORES = {
			Color.BLUE,
			Color.RED,
			Color.YELLOW,
			Color.GREEN,
			Color.MAGENTA
	};

	private int[][] forma;
	private Color color;
	
	//HACER AQUI TODO EL PROCESO DE LAS FORMAS DIFERENTES

	public Pieza(int[][] forma) {
		this.forma = forma;
		this.color = COLORES[new Random().nextInt(COLORES.length)];
	}

	public int[][] getForma() {
		return forma;
	}

	public void setForma(int[][] forma) {
		this.forma = forma;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}




}