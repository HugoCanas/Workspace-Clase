import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class MisSMS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JButton btnAnadir;
	private JList <String> listaPersonas;
	private JTextField [] arrayPersonas;
	private JTextField textPersona1;
	private JTextField textPersona2;
	private JTextField textPersona3;
	private JTextField textPersona4;
	private JTextField textPersona5;
	private JTextField textPersona6;
	private JTextField textPersona7;
	private JTextField textPersona8;
	private JCheckBox [] arrayChechBox;
	private JCheckBox chckbxPersona1;
	private JCheckBox chckbxPersona2;
	private JCheckBox chckbxPersona3;
	private JCheckBox chckbxPersona4;
	private JCheckBox chckbxPersona5;
	private JCheckBox chckbxPersona6;
	private JCheckBox chckbxPersona7;
	private JCheckBox chckbxPersona8;
	private String [] arrayMensajes;
	private TextArea areaMensaje;
	private JButton btnGuardarFichero;
	private JCheckBox chckbxTodos;
	private JButton btnSalir;


	private String mensaje1;
	private String mensaje2;
	private String mensaje3;
	private String mensaje4;
	private String mensaje5;
	private String mensaje6;
	private String mensaje7;
	private String mensaje8;

	private DefaultListModel <String> modelo;


	private int pos=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MisSMS frame = new MisSMS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MisSMS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1040, 556);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(51, 378, 107, 20);
		contentPane.add(lblNewLabel);

		textNombre = new JTextField();
		textNombre.setBounds(51, 410, 154, 33);
		contentPane.add(textNombre);
		textNombre.setColumns(10);

		btnAnadir = new JButton("Añadir");
		btnAnadir.setBounds(87, 454, 89, 23);
		contentPane.add(btnAnadir);


		listaPersonas = new JList<String>();
		listaPersonas.setBounds(46, 63, 159, 294);
		contentPane.add(listaPersonas);

		modelo= new DefaultListModel<String>();
		listaPersonas.setModel(modelo);

		textPersona1 = new JTextField();
		textPersona1.setEnabled(false);
		textPersona1.setBounds(255, 93, 107, 20);
		contentPane.add(textPersona1);
		textPersona1.setColumns(10);

		textPersona2 = new JTextField();
		textPersona2.setEnabled(false);
		textPersona2.setColumns(10);
		textPersona2.setBounds(255, 124, 107, 20);
		contentPane.add(textPersona2);

		textPersona3 = new JTextField();
		textPersona3.setEnabled(false);
		textPersona3.setColumns(10);
		textPersona3.setBounds(255, 155, 107, 20);
		contentPane.add(textPersona3);

		textPersona4 = new JTextField();
		textPersona4.setEnabled(false);
		textPersona4.setColumns(10);
		textPersona4.setBounds(255, 186, 107, 20);
		contentPane.add(textPersona4);

		textPersona5 = new JTextField();
		textPersona5.setEnabled(false);
		textPersona5.setColumns(10);
		textPersona5.setBounds(255, 217, 107, 20);
		contentPane.add(textPersona5);

		textPersona6 = new JTextField();
		textPersona6.setEnabled(false);
		textPersona6.setColumns(10);
		textPersona6.setBounds(255, 248, 107, 20);
		contentPane.add(textPersona6);

		textPersona7 = new JTextField();
		textPersona7.setEnabled(false);
		textPersona7.setColumns(10);
		textPersona7.setBounds(255, 279, 107, 20);
		contentPane.add(textPersona7);

		textPersona8 = new JTextField();
		textPersona8.setEnabled(false);
		textPersona8.setColumns(10);
		textPersona8.setBounds(255, 310, 107, 20);
		contentPane.add(textPersona8);

		JLabel lblNewLabel_1 = new JLabel("Guardar");
		lblNewLabel_1.setBounds(389, 64, 46, 14);
		contentPane.add(lblNewLabel_1);

		chckbxPersona1 = new JCheckBox("");
		chckbxPersona1.setEnabled(false);
		chckbxPersona1.setBounds(402, 92, 46, 23);
		contentPane.add(chckbxPersona1);

		chckbxPersona2 = new JCheckBox("");
		chckbxPersona2.setEnabled(false);
		chckbxPersona2.setBounds(402, 123, 46, 23);
		contentPane.add(chckbxPersona2);

		chckbxPersona3 = new JCheckBox("");
		chckbxPersona3.setEnabled(false);
		chckbxPersona3.setBounds(402, 154, 46, 23);
		contentPane.add(chckbxPersona3);

		chckbxPersona4 = new JCheckBox("");
		chckbxPersona4.setEnabled(false);
		chckbxPersona4.setBounds(402, 185, 46, 23);
		contentPane.add(chckbxPersona4);

		chckbxPersona5 = new JCheckBox("");
		chckbxPersona5.setEnabled(false);
		chckbxPersona5.setBounds(402, 216, 46, 23);
		contentPane.add(chckbxPersona5);

		chckbxPersona6 = new JCheckBox("");
		chckbxPersona6.setEnabled(false);
		chckbxPersona6.setBounds(402, 247, 46, 23);
		contentPane.add(chckbxPersona6);

		chckbxPersona7 = new JCheckBox("");
		chckbxPersona7.setEnabled(false);
		chckbxPersona7.setBounds(402, 278, 46, 23);
		contentPane.add(chckbxPersona7);

		chckbxPersona8 = new JCheckBox("");
		chckbxPersona8.setEnabled(false);
		chckbxPersona8.setBounds(402, 309, 46, 23);
		contentPane.add(chckbxPersona8);

		JLabel lblNewLabel_2 = new JLabel("Texto del mensaje: ");
		lblNewLabel_2.setBounds(527, 38, 286, 20);
		contentPane.add(lblNewLabel_2);

		areaMensaje = new TextArea();
		areaMensaje.setBounds(527, 77, 439, 241);
		contentPane.add(areaMensaje);

		btnGuardarFichero = new JButton("GuardarFichero");
		btnGuardarFichero.setBounds(683, 361, 130, 33);
		contentPane.add(btnGuardarFichero);

		chckbxTodos = new JCheckBox("Todos");
		chckbxTodos.setBounds(402, 366, 97, 23);
		contentPane.add(chckbxTodos);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(788, 454, 89, 23);
		contentPane.add(btnSalir);


		arrayChechBox= new JCheckBox [8];
		arrayPersonas = new JTextField [8];
		arrayMensajes = new String [8];


		llenarArrayPersonas(arrayPersonas);
		llenarArrayMensajes(arrayMensajes);
		llenarArrayCheckBox(arrayChechBox);

		RegistrarEventos();

	}


	private void llenarArrayCheckBox(JCheckBox[] arrayChechBox2) {
		// TODO Auto-generated method stub
		arrayChechBox2[0]=chckbxPersona1;
		arrayChechBox2[1]=chckbxPersona2;
		arrayChechBox2[2]=chckbxPersona3;
		arrayChechBox2[3]=chckbxPersona4;
		arrayChechBox2[4]=chckbxPersona5;
		arrayChechBox2[5]=chckbxPersona6;
		arrayChechBox2[6]=chckbxPersona7;
		arrayChechBox2[7]=chckbxPersona8;
	}

	private void llenarArrayMensajes(String[] arrayMensajes2) {
		// TODO Auto-generated method stub
		arrayMensajes2[0] = mensaje1;
		arrayMensajes2[1] = mensaje2;
		arrayMensajes2[2] = mensaje3;
		arrayMensajes2[3] = mensaje4;
		arrayMensajes2[4] = mensaje5;
		arrayMensajes2[5] = mensaje6;
		arrayMensajes2[6] = mensaje7;
		arrayMensajes2[7] = mensaje8;

	}

	private void llenarArrayPersonas(JTextField[] arrayPersonas2) {
		// TODO Auto-generated method stub
		arrayPersonas2[0]=textPersona1;
		arrayPersonas2[1]=textPersona2;
		arrayPersonas2[2]=textPersona3;
		arrayPersonas2[3]=textPersona4;
		arrayPersonas2[4]=textPersona5;
		arrayPersonas2[5]=textPersona6;
		arrayPersonas2[6]=textPersona7;
		arrayPersonas2[7]=textPersona8;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textField) {
		this.textNombre = textField;
	}

	public JButton getBtnAnadir() {
		return btnAnadir;
	}

	public void setBtnAnadir(JButton btnAnadir) {
		this.btnAnadir = btnAnadir;
	}

	public JList<String> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(JList<String> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public JTextField[] getArrayPersonas() {
		return arrayPersonas;
	}

	public void setArrayPersonas(JTextField[] arrayPersonas) {
		this.arrayPersonas = arrayPersonas;
	}

	public JTextField getTextPersona1() {
		return textPersona1;
	}

	public void setTextPersona1(JTextField textPersona1) {
		this.textPersona1 = textPersona1;
	}

	public JTextField getTextPersona2() {
		return textPersona2;
	}

	public void setTextPersona2(JTextField textPersona2) {
		this.textPersona2 = textPersona2;
	}

	public JTextField getTextPersona3() {
		return textPersona3;
	}

	public void setTextPersona3(JTextField textPersona3) {
		this.textPersona3 = textPersona3;
	}

	public JTextField getTextPersona4() {
		return textPersona4;
	}

	public void setTextPersona4(JTextField textPersona4) {
		this.textPersona4 = textPersona4;
	}

	public JTextField getTextPersona5() {
		return textPersona5;
	}

	public void setTextPersona5(JTextField textPersona5) {
		this.textPersona5 = textPersona5;
	}

	public JTextField getTextPersona6() {
		return textPersona6;
	}

	public void setTextPersona6(JTextField textPersona6) {
		this.textPersona6 = textPersona6;
	}

	public JTextField getTextPersona7() {
		return textPersona7;
	}

	public void setTextPersona7(JTextField textPersona7) {
		this.textPersona7 = textPersona7;
	}

	public JTextField getTextPersona8() {
		return textPersona8;
	}

	public void setTextPersona8(JTextField textPersona8) {
		this.textPersona8 = textPersona8;
	}

	public JCheckBox[] getArrayChechBox() {
		return arrayChechBox;
	}

	public void setArrayChechBox(JCheckBox[] arrayChechBox) {
		this.arrayChechBox = arrayChechBox;
	}

	public JCheckBox getChckbxPersona1() {
		return chckbxPersona1;
	}

	public void setChckbxPersona1(JCheckBox chckbxPersona1) {
		this.chckbxPersona1 = chckbxPersona1;
	}

	public JCheckBox getChckbxPersona2() {
		return chckbxPersona2;
	}

	public void setChckbxPersona2(JCheckBox chckbxPersona2) {
		this.chckbxPersona2 = chckbxPersona2;
	}

	public JCheckBox getChckbxPersona3() {
		return chckbxPersona3;
	}

	public void setChckbxPersona3(JCheckBox chckbxPersona3) {
		this.chckbxPersona3 = chckbxPersona3;
	}

	public JCheckBox getChckbxPersona4() {
		return chckbxPersona4;
	}

	public void setChckbxPersona4(JCheckBox chckbxPersona4) {
		this.chckbxPersona4 = chckbxPersona4;
	}

	public JCheckBox getChckbxPersona5() {
		return chckbxPersona5;
	}

	public void setChckbxPersona5(JCheckBox chckbxPersona5) {
		this.chckbxPersona5 = chckbxPersona5;
	}

	public JCheckBox getChckbxPersona6() {
		return chckbxPersona6;
	}

	public void setChckbxPersona6(JCheckBox chckbxPersona6) {
		this.chckbxPersona6 = chckbxPersona6;
	}

	public JCheckBox getChckbxPersona7() {
		return chckbxPersona7;
	}

	public void setChckbxPersona7(JCheckBox chckbxPersona7) {
		this.chckbxPersona7 = chckbxPersona7;
	}

	public JCheckBox getChckbxPersona8() {
		return chckbxPersona8;
	}

	public void setChckbxPersona8(JCheckBox chckbxPersona8) {
		this.chckbxPersona8 = chckbxPersona8;
	}

	public String[] getArrayMensajes() {
		return arrayMensajes;
	}

	public void setArrayMensajes(String[] arrayMensajes) {
		this.arrayMensajes = arrayMensajes;
	}

	public TextArea getAreaMensaje() {
		return areaMensaje;
	}

	public void setAreaMensaje(TextArea areaMensaje) {
		this.areaMensaje = areaMensaje;
	}

	public JButton getBtnGuardarFichero() {
		return btnGuardarFichero;
	}

	public void setBtnGuardarFichero(JButton btnGuardarFichero) {
		this.btnGuardarFichero = btnGuardarFichero;
	}

	public JCheckBox getChckbxTodos() {
		return chckbxTodos;
	}

	public void setChckbxTodos(JCheckBox chckbxTodos) {
		this.chckbxTodos = chckbxTodos;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public DefaultListModel<String> getModelo() {
		return modelo;
	}

	public void setModelo(DefaultListModel<String> modelo) {
		this.modelo = modelo;
	}


	public void RegistrarEventos() {

		btnAnadir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub



				if(textNombre.getText().length() >0){
					modelo.add(pos,textNombre.getText()); 
					System.out.println("DEBUG LLEGA AL IF");

					arrayPersonas[pos].setText(textNombre.getText()); 
					arrayChechBox[pos].setEnabled(true);  
					arrayPersonas[pos].setEnabled(true);
					pos++;

				}else {
					JOptionPane.showMessageDialog(null, "El nombre no puede ser nulo");
					System.out.println("DEBUG LLEGA AL ELSE"); 



				}

			}



		});

		listaPersonas.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub

				for (int i=0; i < arrayPersonas.length ;i++) {

					arrayPersonas[i].setBackground(null);

				}
				arrayPersonas[listaPersonas.getSelectedIndex()].setBackground(Color.CYAN); //FUNCIONA

				areaMensaje.setText(null);
				areaMensaje.setText(arrayMensajes[listaPersonas.getSelectedIndex()]);
				//TENGO QUE CONSEGUIR EL GET DE EL ARRAY DE CADA PERSONA DE MI ARRAY DE STRING Y SETEAR EL TEXTO

			}
		});

		listaPersonas.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 2 ) {                 // 2 = doble click
					if (listaPersonas.getSelectedIndex() >= 0 && !arrayChechBox[listaPersonas.getSelectedIndex()].isSelected() ) { 
						arrayChechBox[listaPersonas.getSelectedIndex()].setSelected(true);
					}
					else  { 
						arrayChechBox[listaPersonas.getSelectedIndex()].setSelected(false);
					}
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		chckbxTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i=0; i<arrayPersonas.length; i++) {
					if(chckbxTodos.isSelected()) {
						if(arrayChechBox[i].isEnabled()) {
							arrayChechBox[i].setSelected(true);
						}
					}
					if(!chckbxTodos.isSelected()) {
						if(arrayChechBox[i].isEnabled()) {
							arrayChechBox[i].setSelected(false);
						}
					}
				}
			}
		});
		
		areaMensaje.addTextListener(new TextListener() {

			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				String mensaje;
				areaMensaje.getText();
				
				areaMensaje.setText(arrayMensajes[listaPersonas.getSelectedIndex()]);
			}
		});
		
		btnGuardarFichero.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int contador = 0;
				
				for(int i = 0; i<arrayPersonas.length; i++) {
					if(arrayMensajes[listaPersonas.getSelectedIndex()].length() >0) {
						contador++;
					}
					if(contador ==8) {
							JOptionPane.showMessageDialog(null, "No se puede guardar un fichero con todos los mensajes nulo");
						}
					}
				}
		});
	}
}

