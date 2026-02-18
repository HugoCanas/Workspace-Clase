import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class Fichero {


	public Fichero() {



	}

	public ArrayList<String> cargarPalabras(String fichero) {
		Scanner scFichero;
		ArrayList<String> palabras;
		palabras=new ArrayList<String>();
		try {
			scFichero=new Scanner(new File("./recursos/"+fichero));
			while(scFichero.hasNext()) {
				palabras.add(scFichero.nextLine());
			}
			scFichero.close();
			return palabras;
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Image[] leerImagenes() {
		Image[] arrayImagenes;
		arrayImagenes= new Image[8];
		//LEER TODOS LOS FICHEROS DE LAS IMAGENES DEL AHORCADO Y GUARDARLOS EN CADA POSICION DEL ARRAY 

		for(int i =0; i<arrayImagenes.length;i++) {
			arrayImagenes[i] = new ImageIcon(getClass().getResource("Ahorcado" + i + ".png")).getImage();
		}
		return arrayImagenes;
	}

	public Image[] leerSprite() {
		// TODO Auto-generated method stubç
		Image[] arrayImagenes;
		arrayImagenes=new Image[8];
		
		BufferedImage bfImage;
		try {
			bfImage=ImageIO.read((new File("./recursos/spriteAhorcado.jpg")));
			for(int i=0;i<arrayImagenes.length;i++) {
				if(i<2) {
				arrayImagenes[i]=bfImage.getSubimage(162*(i%5),161*(i/5), 813/5, 321/2);
				}else {
				arrayImagenes[i]=bfImage.getSubimage(162*((i+1)%5),161*((i+1)/5), 813/5, 321/2);
			}
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return arrayImagenes;
	}
}
