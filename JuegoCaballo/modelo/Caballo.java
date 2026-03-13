import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;

public class Caballo {
	public static final int QUIETO=0;
	public static final int CORRIENDO=1;
	public static final int SALTANDO=2;
	//DATOS
	private Image[] arrayImagenes;
	private Image[] arrayImagenesDcha;
	private int velocidad;
	private int posX,posY;
	private int ancho, alto;
	private int estado;
	private int imgActual;
	
	private AreaJuego areaJuego;
	
	public Caballo (AreaJuego areaJuego) {
		this.areaJuego= areaJuego;
		velocidad = 5;
		estado=QUIETO;
		posX = 0;
		posY = 560; 
		ancho = 90;
		alto = 60;
		imgActual=7;
		cargarImagenes();
	}


	private void cargarImagenes() {
		// TODO Auto-generated method stub
		arrayImagenesDcha = new Image[8];
		arrayImagenes = new Image[8];
		for(int i = 0;i<arrayImagenesDcha.length;i++) {
			arrayImagenesDcha[1]= new ImageIcon(getClass().getResource("CaballoD"+(i+1)+".png")).getImage();
			arrayImagenes[1]= new ImageIcon(getClass().getResource("CaballoI"+(i+1)+".png")).getImage();
		}
	}


	public Image[] getArrayImagenes() {
		return arrayImagenes;
	}

	public void setArrayImagenes(Image[] arrayImagenes) {
		this.arrayImagenes = arrayImagenes;
	}

	public Image[] getArrayImagenesDcha() {
		return arrayImagenesDcha;
	}

	public void setArrayImagenesDcha(Image[] arrayImagenesDcha) {
		this.arrayImagenesDcha = arrayImagenesDcha;
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
}
