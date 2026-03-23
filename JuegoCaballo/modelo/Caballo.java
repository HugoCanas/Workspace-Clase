import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Caballo {
	public static final int QUIETO=0;
	public static final int CORRIENDO=1;
	public static final int SALTANDO=2;

	//DATOS
	private Image[] arrayImagenesIzq;
	private Image[] arrayImagesDcha;
	private int velocidad;
	private int posX, posY;
	private int ancho, alto;
	private int dirH, dirV;
	private int estado;
	private int imgActual;
	private int contAnimaciones;

	private AreaJuego areaJuego;

	public Caballo(AreaJuego areaJuego) {
		this.areaJuego=areaJuego;
		velocidad=6;
		estado=QUIETO;
		posX=0;
		posY=660;
		dirH=1;
		dirV=0;
		ancho=120;
		alto=90;
		imgActual=7;
		contAnimaciones=0;
		cargarImagenes();
	}

	public void cargarImagenes() {
		arrayImagesDcha = new Image[8];
		arrayImagenesIzq = new Image[8];

		for (int i = 0; i < 8; i++) {
			arrayImagesDcha[i] = new ImageIcon(getClass().getResource("CaballoD" + (i + 1) + ".png")).getImage();
			arrayImagenesIzq[i] = new ImageIcon(getClass().getResource("CaballoI" + (i + 1) + ".png")).getImage();
		}
	}

	public void dibujar(Graphics g) {
		if(estado==QUIETO) {
			imgActual=7;
		}
		if (dirH==1) {
			g.drawImage(arrayImagesDcha[imgActual], posX, posY, ancho, alto, areaJuego);
		}else {
			g.drawImage(arrayImagenesIzq[imgActual], posX, posY, ancho, alto, areaJuego);
		}
	}

	public void mover() {
		
		if(estado==QUIETO) {
			return;
		}
		// TODO Auto-generated method stub
		if(posX>0 && dirH==-1 || posX + ancho <= areaJuego.getWidth() && dirH == 1) {
			posX=posX+velocidad*dirH; 	
		}
		//ANIMACION
		contAnimaciones++;
		if(contAnimaciones==4) {
			imgActual++;
			imgActual= (imgActual+1)%8;
			contAnimaciones=0;
		}
	}


	//GETTERS Y SETTERS
	public Image[] getArrayImagenesIzq() {
		return arrayImagenesIzq;
	}

	public void setArrayImagenesIzq(Image[] arrayImagenesIzq) {
		this.arrayImagenesIzq = arrayImagenesIzq;
	}

	public Image[] getArrayImagesDcha() {
		return arrayImagesDcha;
	}

	public void setArrayImagesDcha(Image[] arrayImagesDcha) {
		this.arrayImagesDcha = arrayImagesDcha;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getImgActual() {
		return imgActual;
	}

	public void setImgActual(int imgActual) {
		this.imgActual = imgActual;
	}

	public AreaJuego getAreaJuego() {
		return areaJuego;
	}

	public void setAreaJuego(AreaJuego areaJuego) {
		this.areaJuego = areaJuego;
	}

	public int getDirH() {
		return dirH;
	}

	public void setDirH(int dirH) {
		this.dirH = dirH;
	}

	public int getDirV() {
		return dirV;
	}

	public void setDirV(int dirV) {
		this.dirV = dirV;
	}



}