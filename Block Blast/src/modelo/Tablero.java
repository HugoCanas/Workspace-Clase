package modelo;

import java.awt.Color;
import java.awt.Graphics;

public class Tablero {

	public static final int FILAS=8;
	public static final int COLS=8;

	//DATOS
	private Color[][] celdas; //null = vacia, Color = ocupada

	//CONSTRUCTOR
	public Tablero() {
		celdas=new Color[FILAS][COLS];
	}

	//MÉTODOS
	public void dibujar(Graphics g, int offsetX, int offsetY, int tam) {
		for(int f=0;f<FILAS;f++) {
			for(int c=0;c<COLS;c++) {
				int x=offsetX+c*tam;
				int y=offsetY+f*tam;
				if(celdas[f][c]==null) {
					g.setColor(new Color(30,30,50));
				} else {
					g.setColor(celdas[f][c]);
				}
				g.fillRect(x+2,y+2,tam-4,tam-4);
				g.setColor(new Color(60,60,90));
				g.drawRect(x+2,y+2,tam-4,tam-4);
			}
		}
	}

	//Dibujar preview donde caeria la pieza
	public void dibujarPreview(Graphics g, Pieza pieza, int fila, int col, int offsetX, int offsetY, int tam) {
		int[][] forma=pieza.getForma();
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				if(forma[f][c]==1) {
					int x=offsetX+(col+c)*tam;
					int y=offsetY+(fila+f)*tam;
					//Color gris para que se vea donde va a caer
					g.setColor(Color.DARK_GRAY);
					g.fillRect(x+2,y+2,tam-4,tam-4);
				}
			}
		}
	}

	//Comprobar si cabe la pieza en esa posicion
	public boolean cabe(Pieza pieza, int fila, int col) {
		int[][] forma=pieza.getForma();
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				if(forma[f][c]==1) {
					int fT=fila+f;
					int cT=col+c;
					//Que no se salga y que este vacia
					if(fT<0 || fT>=FILAS || cT<0 || cT>=COLS) return false;
					if(celdas[fT][cT]!=null) return false;
				}
			}
		}
		return true;
	}

	//Colocar la pieza en el tablero
	public void colocar(Pieza pieza, int fila, int col) {
		int[][] forma=pieza.getForma();
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				if(forma[f][c]==1) {
					celdas[fila+f][col+c]=pieza.getColor();
				}
			}
		}
	}

	//Limpiar filas y columnas completas, devuelve cuantas lineas
	public int limpiarLineas() {
		boolean[] filasComp=new boolean[FILAS];
		boolean[] colsComp=new boolean[COLS];
		int lineas=0;
		boolean completa;

		//Comprobar filas
		for(int f=0;f<FILAS;f++) {
			completa=true;
			for(int c=0;c<COLS;c++) {
				if(celdas[f][c]==null) {
					completa=false;
					break;
				}
			}
			filasComp[f]=completa;
			if(completa) lineas++;
		}
		//Comprobar columnas
		for(int c=0;c<COLS;c++) {
			completa=true;
			for(int f=0;f<FILAS;f++) {
				if(celdas[f][c]==null) {
					completa=false;
					break;
				}
			}
			colsComp[c]=completa;
			if(completa) lineas++;
		}
		//Vaciar las completas
		for(int f=0;f<FILAS;f++) {
			for(int c=0;c<COLS;c++) {
				if(filasComp[f] || colsComp[c]) {
					celdas[f][c]=null;
				}
			}
		}
		return lineas;
	}

	//Comprobar si la pieza cabe en algun sitio
	public boolean cabeEnAlgunSitio(Pieza pieza) {
		for(int f=0;f<FILAS;f++) {
			for(int c=0;c<COLS;c++) {
				if(cabe(pieza,f,c)) return true;
			}
		}
		return false;
	}

	//GETTERS Y SETTERS
	public Color[][] getCeldas() {
		return celdas;
	}

	public void setCeldas(Color[][] celdas) {
		this.celdas=celdas;
	}
}