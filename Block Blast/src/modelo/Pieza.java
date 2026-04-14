package modelo;

import java.awt.Color;

public class Pieza {

	private int[][] forma;
	private Color color;

	public Pieza(int[][] forma, Color color) {
		this.forma = forma;
		this.color = color;
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