package modelo;

import java.awt.Color;
import java.awt.Graphics;

public class PiezaEspecial extends Pieza {

	public PiezaEspecial(int posX, int posY) {
		super(posX,posY);
	}

	@Override
	public void dibujar(Graphics g) {
		int[][] forma=getForma();
		for(int f=0;f<3;f++) {
			for(int c=0;c<3;c++) {
				if(forma[f][c]==1) {
					int x=getPosX()+c*TAM;
					int y=getPosY()+f*TAM;
					g.setColor(getColor());
					g.fillRect(x+2,y+2,TAM-4,TAM-4);
					g.setColor(Color.ORANGE);	//*****************************borde*****************************
					g.drawRect(x+2,y+2,TAM-4,TAM-4);
					g.drawRect(x+3,y+3,TAM-6,TAM-6);
				}
			}
		}
	}
}