package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Pieza {

	public static final int TAM=40;

	private static final Color[] COLORES = {
		Color.BLUE, Color.RED, Color.YELLOW,
		Color.GREEN, Color.MAGENTA
	};

	private static final int[][][] FORMAS = {
		{{1,0,0},{0,0,0},{0,0,0}},
		{{1,1,0},{0,0,0},{0,0,0}},
		{{1,1,1},{0,0,0},{0,0,0}},
		{{1,0,0},{1,0,0},{0,0,0}},
		{{1,0,0},{1,0,0},{1,0,0}},
		{{1,1,0},{1,1,0},{0,0,0}},
		{{1,1,1},{1,1,1},{1,1,1}},
		{{1,0,0},{1,0,0},{1,1,0}},
		{{0,1,0},{0,1,0},{1,1,0}},
		{{1,1,0},{1,0,0},{1,0,0}},
		{{1,1,0},{0,1,0},{0,1,0}},
		{{1,1,1},{0,1,0},{0,0,0}},
		{{0,1,1},{1,1,0},{0,0,0}},
		{{1,1,0},{0,1,1},{0,0,0}},
	};

	//DATOS
	private int[][] forma;
	private Color color;
	private int posX,posY;
	private int posXinic,posYinic;
	private boolean colocada;
	private int bloqueF,bloqueC; //En que bloque de la pieza ha pinchado el raton

	//CONSTRUCTOR
	public Pieza(int posX, int posY) {
		Random r=new Random();
		this.forma=FORMAS[r.nextInt(FORMAS.length)];
		this.color=COLORES[r.nextInt(COLORES.length)];
		this.posX=posX;
		this.posY=posY;
		this.posXinic=posX;
		this.posYinic=posY;
		colocada=false;
		bloqueF=0;
		bloqueC=0;
	}

	//MÉTODOS
	public void dibujar(Graphics g) {
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				if(forma[f][c]==1) {
					int x=posX+c*TAM;
					int y=posY+f*TAM;
					//Relleno
					g.setColor(color);
					g.fillRect(x+2,y+2,TAM-4,TAM-4);
					//Borde
					g.setColor(Color.BLACK);
					g.drawRect(x+2,y+2,TAM-4,TAM-4);
				}
			}
		}
	}

	//Comprobar si el raton ha pulsado encima y guardar en que bloque
	public boolean contiene(int mx, int my) {
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				if(forma[f][c]==1) {
					int x=posX+c*TAM;
					int y=posY+f*TAM;
					if(mx>=x && mx<x+TAM && my>=y && my<y+TAM) {
						bloqueF=f;
						bloqueC=c;
						return true;
					}
				}
			}
		}
		return false;
	}

	public void volverAInicio() {
		posX=posXinic;
		posY=posYinic;
	}

	//GETTERS Y SETTERS
	public int[][] getForma() {
		return forma;
	}

	public void setForma(int[][] forma) {
		this.forma=forma;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color=color;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX=posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY=posY;
	}

	public int getPosXinic() {
		return posXinic;
	}

	public int getPosYinic() {
		return posYinic;
	}

	public boolean isColocada() {
		return colocada;
	}

	public void setColocada(boolean colocada) {
		this.colocada=colocada;
	}

	public int getBloqueF() {
		return bloqueF;
	}

	public int getBloqueC() {
		return bloqueC;
	}
}