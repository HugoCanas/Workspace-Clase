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

	private static final int[][][] FORMAS = {
			{{1,0,0},{0,0,0},{0,0,0}},
			{{1,1,0},{0,0,0},{0,0,0}},// línea horizontal de 2
			{{1,1,1},{0,0,0},{0,0,0}},// línea horizontal de 3
			{{1,0,0},{1,0,0},{0,0,0}},// línea vertical de 2
			{{1,0,0},{1,0,0},{1,0,0}},// línea vertical de 3
			{{1,1,0},{1,1,0},{0,0,0}},// cuadrado 2x2
			{{1,1,1},{1,1,1},{1,1,1}},// cuadrado 3x3
			{{1,0,0},{1,0,0},{1,1,0}},// L pequeña normal
			{{0,1,0},{0,1,0},{1,1,0}},// L pequeña invertida
			{{1,1,0},{1,0,0},{1,0,0}},// J pequeña normal
			{{1,1,0},{0,1,0},{0,1,0}},// J pequeña invertida
			{{1,1,1},{0,1,0},{0,0,0}},// forma t
			{{0,1,1},{1,1,0},{0,0,0}},// forma s
			{{1,1,0},{0,1,1},{0,0,0}},// forma z
	};	

	private int [][] forma;
	private Color color;

	//HACER AQUI TODO EL PROCESO DE LAS FORMAS DIFERENTES

	public Pieza() {
		Random r = new Random();
		this.forma = FORMAS[r.nextInt(FORMAS.length)];
		this.color = COLORES[r.nextInt(COLORES.length)];
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