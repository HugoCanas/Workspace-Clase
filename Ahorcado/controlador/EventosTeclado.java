import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class EventosTeclado {

	public EventosTeclado(Teclado teclado) {
		JButton []array;
		array=teclado.getArrayTeclado();

		for (JButton btn : array) {

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//COGER EL TEXTO DEL BOTON 
					char letra;
					String palabra, palAux;
					JLabel lblPalabra;
					boolean esta;

					palabra=teclado.getPalabra();
					lblPalabra=teclado.getAhorcado().getLblPalabra();
					letra=btn.getText().charAt(0);
					palAux="";
					esta=false;
					for(int pos=0;pos<palabra.length();pos++) {
						//SI COINCIDE LA LETRA : LA CONCATENAMOS AL AUX
						if(letra==palabra.charAt(pos)) {
							palAux=palAux+letra+" ";
							//boton verde
							esta=true;
						}else {
							palAux=palAux+lblPalabra.getText().substring(pos*2,pos*2+2);
							//boton rojo
						}
					}
					lblPalabra.setText(palAux);

					if(esta==true)
					{
						btn.setBackground(Color.green);
						btn.setEnabled(false);
						if(!lblPalabra.getText().contains("_")) {
							teclado.estadoTeclado(false);
							teclado.getAhorcado().getBtnNueva().setEnabled(true);
						}
					}else {
						btn.setBackground(Color.red);
						btn.setEnabled(false);
						teclado.getAhorcado().setNumFallos(teclado.getAhorcado().getNumFallos()+1);
						teclado.getAhorcado().getAreaDibujo().repaint();
						if(teclado.getAhorcado().getNumFallos()==7) {
							teclado.estadoTeclado(false);
							teclado.getAhorcado().getBtnNueva().setEnabled(true);
							//INICIAMOS EL RELOJ 
							teclado.getAhorcado().getAreaDibujo().getEventosAreadibujo().getReloj().start();
						}
					}

					//SUSTITUIR LAS POSICIONES EN LAS QUE ESTA LA LETRA -> VERDE
					//SI LA LETRA NO ESTA -> PONER EL BOTON ROJ -> INCREMENTAR FALLOS -> REDIBUJAR AREADIBUJO ->  COMPROBAR SI FINAL
				}
			});

		}

	}

}
