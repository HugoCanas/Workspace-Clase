import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Cuadrado{
	//DATOS
	private int posXinic,posYinic;
	private Cuadrado pareja;
	
	public Circulo(Color color, int ancho, int alto, String letra, int posX, int posY, int velocidad, int dirH, int dirV) {
		super(color, ancho, alto, letra, posX, posY,velocidad, dirH, dirV);
		pareja=null;
		this.posXinic = posX;
		this.posYinic = posY;
	}

	public Circulo() {
		super();
		posXinic=getPosX();
		posYinic=getPosY();
		pareja=null;
	}
	

	//METODOS (FUNCIONES)

	public void dibujar(Graphics g) {
		//interior
		g.setColor(getColor());
		g.fillOval(getPosX(), getPosY(), getAncho(), getAlto());
		//BORDE
		g.setColor(Color.BLACK);
		g.drawOval(getPosX(), getPosY(), getAncho(), getAlto());
		//FALTA LA LETRA
		dibujarLetra(g);
		
		
		
	}

	public int getPosXinic() {
		return posXinic;
	}

	public void setPosXinic(int posXinic) {
		this.posXinic = posXinic;
	}

	public int getPosYinic() {
		return posYinic;
	}

	public void setPosYinic(int posYinic) {
		this.posYinic = posYinic;
	}

	public Cuadrado getPareja() {
		return pareja;
	}

	public void setPareja(Cuadrado pareja) {
		this.pareja = pareja;
	}
	
	
	
	
	
}
