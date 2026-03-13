import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AreaJuego extends JPanel{
	//DATOS
	private int puntuacion;
	private Image [] fondos;
	public Caballo caballo;
	public int nivel;
	
	
	public AreaJuego() {
		//setBackground(Color.YELLOW);
		//CARGAR FONDOS Y DIBUJAR UNO
		fondos = new Image[3];
		for(int i=0;i<fondos.length;i++) {
			fondos[i]= new ImageIcon(getClass().getResource("montana"+(i+1)+".jpg")).getImage();
		}
		caballo = new Caballo(this);
		
	}//FIN DEL CONSTRUCTOR

	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(fondos[nivel], 0, 0, getWidth(), getHeight(), getFocusCycleRootAncestor());
		caballo.dibujar(g);
	}
}
