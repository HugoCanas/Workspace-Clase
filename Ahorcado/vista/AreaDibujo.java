import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class AreaDibujo extends Canvas {
	private Ahorcado ahorcado;
	private EventosAreaDibujo eventosAreaDibujo;
	private int desplazamiento;
	//PARA EL DOBLE BUFFER
	private Image imagen;
	private Graphics pantVirtual;
	private Image []arrayImagenes;
	private Fichero fichero;

	public AreaDibujo(Ahorcado ahorcado) {
		this.setBackground(Color.CYAN);
		this.ahorcado=ahorcado;
		eventosAreaDibujo= new EventosAreaDibujo(this);
		desplazamiento=0;
		cargarImagenes();
	}

	private void cargarImagenes() {
		// TODO Auto-generated method stub
		fichero = new Fichero();
		//CARGANDO LAS IMAGENES DE FICHERO PNG INDEPENDIENTES
		//arrayImagenes=fichero.leerImagenes();
		
		//CARGAMOS LAS IMAGENES DE UN SPRITE
		arrayImagenes=fichero.leerSprite();
	}

	@Override
	public void paint(Graphics g) { //se crea escribiendo paint y ctr+espacio
		// TODO Auto-generated method stub
		super.paint(g);
		//g.drawRe
		//DIBUJA TODOS LOS ELEMENTOS QUE FORMAN PARTE DEL JUEGO 
		//dibujarAhorcado(g);
		dibujarImagenes(g);
	}
	
	private void dibujarImagenes(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(arrayImagenes[ahorcado.getNumFallos()], 0, 50, this.getWidth(), this.getHeight()-50, ahorcado);
		if(ahorcado.getNumFallos()>=7) {
			g.setColor(Color.BLUE);
			g.setFont(new Font("Arial", Font.BOLD,24));
			g.drawString(ahorcado.getTeclado().getPalabra(),30, 30);
			g.setColor(Color.BLACK);
		}
	}

	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//super.update(g); HACE QUE VAYA CON TIRONES/DESAPARECER
		imagen=createImage(this.getWidth(),this.getHeight());
		pantVirtual=imagen.getGraphics();
		paint(pantVirtual);
		g.drawImage(imagen, 0, 0, null); //EL TAMAÑO DE LA IMAGEN ES EL MISMO QUE EL DEL CANVAS
	}

	private void dibujarAhorcado(Graphics g) {
		// TODO Auto-generated method stub
		//DUBUJAR PATIBULO 
		//VENTANA DE 600PX * 500PX
		//g.setColor(Color.blue);
		g.drawLine(90, 360, 90, 430);
		g.drawLine(90, 360, 185, 360);
		if(ahorcado.getNumFallos()<7) {
			g.drawLine(185, 360, 285, 360);
		}else {
			g.drawLine(185, 360, 185, 430);
			g.drawLine(285, 360, 285, 430);
		}
		g.drawLine(285, 360, 320, 360);
		g.drawLine(320, 430, 320, 50);
		g.drawLine(320, 50, 220, 50);
		g.drawLine(220, 50, 220, 80);

		//DUBUJAR PARTES DEL CUERPO

		switch(ahorcado.getNumFallos()) {
		case 7: //simular la caida 
			desplazamiento+=5;
			//dibujar cuerda
			g.drawLine(220, 50, 220, 80+desplazamiento);
			//ESCRIBIR LA PAALABRA CORRECTA
			//g.setFont(new Font("Arial",Font.BOLD, 25));
			//g.drawString(ahorcado.getTeclado().getPalabra(), 30, 30);
			if(desplazamiento>=100) {
				eventosAreaDibujo.getReloj().stop();
			}
		case 6: // PIERNA DCHA
			g.drawLine(220, 230+desplazamiento, 250, 290+desplazamiento);
		case 5: // PIERNA IZQ
			g.drawLine(220, 230+desplazamiento, 190, 290+desplazamiento);
		case 4: // BRAZO DCHO
			g.drawLine(220, 160+desplazamiento, 260, 200+desplazamiento);
		case 3: // BRAZO IZQ
			g.drawLine(220, 160+desplazamiento, 180, 200+desplazamiento);
		case 2: // CUERPO 
			g.drawLine(220, 140+desplazamiento, 220, 230+desplazamiento);
		case 1: // CABEZA 
			g.drawOval(195, 80+desplazamiento, 50, 60);
		}

		

	}

	public EventosAreaDibujo getEventosAreadibujo() {
		return eventosAreaDibujo;
	}

	public void setEventosAreadibujo(EventosAreaDibujo eventosAreaDibujo) {
		this.eventosAreaDibujo = eventosAreaDibujo;
	}

	public int getDesplazamiento() {
		return desplazamiento;
	}

	public void setDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}
}
