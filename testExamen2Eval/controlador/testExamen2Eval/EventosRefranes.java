package testExamen2Eval;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EventosRefranes {
	private Refranes refranes;
	private int numElements;
	
	public EventosRefranes(Refranes refranes) {
		this.refranes = refranes;

		refranes.getBtnCargar().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		        // 1. Ver qué radio está seleccionado
				String fichero;
				Scanner scFichero;

				if(refranes.getRdRefran1().isSelected()) {

					fichero="Refran1.txt";

				}
				else if(refranes.getRdRefran2().isSelected()) {

					fichero="Refran2.txt";

				}
				else {

					fichero="Refran3.txt";

				}
				 // 2. Leer el fichero
				try {
					scFichero= new Scanner(new File(fichero));
					refranes.getModelo().clear();
					numElements=0;
					//LEER EL FICHERO LINEA A GUARDANDO LOS DATOS
					refranes.setStrRefran(scFichero.nextLine());
			        // 3. Cargar el resto de líneas en la lista
					while(scFichero.hasNext()){

						refranes.getModelo().addElement(scFichero.nextLine());
						numElements ++;
					}
					scFichero.close();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		refranes.getBtnSubir().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int pos;
				String palabra;
				pos=refranes.getLstPalabras().getSelectedIndex();
				palabra=refranes.getLstPalabras().getSelectedValue();

					if(pos>0) {
						refranes.getModelo().remove(pos);
						refranes.getModelo().add(pos-1, palabra);
						refranes.getLstPalabras().setSelectedIndex(pos-1);
					}
				}	
		});
		
		refranes.getBtnEliminar().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(refranes.getLstPalabras().getSelectedIndex()!=-1) {
					refranes.getModelo().remove(refranes.getLstPalabras().getSelectedIndex());
				}
			}
		});
	}



}
