package a;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class HolaMundo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTexto;
	private JTextField txtNum1;
	private JTextField txtNum2;
	private JButton btnMostrarTexto;
	private JButton btnSumar;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HolaMundo frame = new HolaMundo();
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
	public HolaMundo() {
		setTitle("Hola Mundo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Texto:");
		lblNewLabel.setBounds(142, 47, 65, 28);
		contentPane.add(lblNewLabel);

		txtTexto = new JTextField();
		txtTexto.setBounds(265, 51, 158, 20);
		contentPane.add(txtTexto);
		txtTexto.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Numero 1:");
		lblNewLabel_1.setBounds(142, 120, 65, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Numero 2:");
		lblNewLabel_1_1.setBounds(142, 184, 65, 14);
		contentPane.add(lblNewLabel_1_1);

		txtNum1 = new JTextField();
		txtNum1.setColumns(10);
		txtNum1.setBounds(265, 117, 158, 20);
		contentPane.add(txtNum1);

		txtNum2 = new JTextField();
		txtNum2.setColumns(10);
		txtNum2.setBounds(265, 178, 158, 20);
		contentPane.add(txtNum2);

		btnSalir = new JButton("Salir");
		btnSalir.setBounds(290, 258, 89, 23);
		contentPane.add(btnSalir);

		btnMostrarTexto = new JButton("Mostrar");
		btnMostrarTexto.setBounds(490, 50, 89, 23);
		contentPane.add(btnMostrarTexto);

		btnSumar = new JButton("Sumar");
		btnSumar.setBounds(490, 136, 89, 23);
		contentPane.add(btnSumar);

		registrarEventos();
		mostrarMensaje();
		sumarNumeros();

	}//FIN DEL CONSTRUCTOR

	public void registrarEventos() {
		btnSalir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(JOptionPane.showConfirmDialog(HolaMundo.this, "¿Estas Seguro que quieres salir? ", "Aviso", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
	}

	public void mostrarMensaje() {
		btnMostrarTexto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtTexto.setText("Hola Mundo");
			}
		});
	}

	public void sumarNumeros () {
		btnSumar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n1,n2,result;
				try {
					n1=Integer.parseInt(txtNum1.getText());   
					n2=Integer.parseInt(txtNum2.getText());
					result=n1+n2;

					txtTexto.setText(String.valueOf(result));
					/*OTRA FORMA 
					txtTexto.setText(result+"");
					 */
				}catch(NumberFormatException ex){
					//System.out.println("Tiene que escribir dos numeros");
					JOptionPane.showMessageDialog(HolaMundo.this, "Tienes que introducir dos numeros enteros"); 
					//NombreVentana.this = centrar en la ventana en la que estes el mensaje
				}
			}
		});
	}
}
