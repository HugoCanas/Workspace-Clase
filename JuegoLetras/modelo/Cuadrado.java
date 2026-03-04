import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Cuadrado {
	public static final int TAM=30;
	public static final int SEP=35;
	//DATOS
	private Color color;
	private int ancho, alto;
	private String letra;
	private int posX, posY;
	
	private int velocidad;
	private int dirH; //-1 izquierda, 1 derecha, 0 no se mueve en horizontal
	private int dirV; //-1 arriba, 1 abajo, 0 no se mueve en vertical
	
	private AreaJuego areaJuego;
	
	
	//CONSTRUCTOR/ES
	public Cuadrado(Color color, int ancho, int alto, String letra, int posX, int posY, int velocidad, int dirH, int dirV) {
		this.color = color;
		this.ancho = ancho;
		this.alto = alto;
		this.letra = letra;
		this.posX = posX;
		this.posY = posY;
		this.velocidad = velocidad;
		this.dirH = dirH;
		this.dirV = dirV;
	}

	public Cuadrado() {
		color=Color.CYAN;
		ancho=TAM;
		alto=TAM;
		letra="";
		posX=0;
		posY=0;
		velocidad=5;
		dirH=-1;
		dirV=1;
	}

	//METODOS (FUNCIONES)

	public void dibujar(Graphics g) {
		//interior
		g.setColor(color);
		g.fillRect(posX, posY, ancho, alto);
		//BORDE
		g.setColor(color.BLACK);
		g.drawRect(posX, posY, ancho, alto);
		//FALTA LA LETRA
		dibujarLetra(g);
		
		
	}
	
	public void dibujarLetra(Graphics g) {
		FontMetrics fm;
		Rectangle2D rect;
		
		g.setFont(new Font("Arial", Font.BOLD,20));
		fm=g.getFontMetrics();
		rect=fm.getStringBounds(letra, g);
		
		g.drawString(letra, (int)(posX+ancho/2-rect.getWidth()/2+1), (int)(posY+alto/2+rect.getHeight()/2-2));
	}

	public void mover() {
		// TODO Auto-generated method stub
	
		posX=posX+velocidad*dirH;
		posY=posY+velocidad*dirV;
		//CONTROLAR REBOTES CON PAREDES
		//PARED IZQUIERDA
		if(posX<=0 || posX + ancho >= areaJuego.getWidth()) {
			dirH=-dirH;
		}
		if(posY<=0 || posY + alto >= areaJuego.getHeight()) {
			dirV=-dirV;
		}
		
	}
	
	//GETTERS & SETTERS
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
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

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
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

	public AreaJuego getAreaJuego() {
		return areaJuego;
	}

	public void setAreaJuego(AreaJuego areaJuego) {
		this.areaJuego = areaJuego;
	}

	public Rectangle getRect() {
		Rectangle r;
		
		r=new Rectangle(posX, posY, ancho, alto);
		return r;
	}

	

}
