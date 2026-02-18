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

public class Recursividad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFact;
	private JLabel lblNumero1;
	private JButton btnFact;
	private JTextField txtNum;
	private JTextField textNum1;
	private JTextField textNum2;
	private JLabel lblPotencia;
	private JTextField textPot;
	private JButton btnPot;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recursividad frame = new Recursividad();
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
	public Recursividad() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Numero");
		lblNewLabel.setBounds(121, 93, 46, 14);
		contentPane.add(lblNewLabel);

		txtNum = new JTextField();
		txtNum.setBounds(194, 90, 86, 20);
		contentPane.add(txtNum);
		txtNum.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Factorial");
		lblNewLabel_1.setBounds(325, 93, 46, 14);
		contentPane.add(lblNewLabel_1);

		textFact = new JTextField();
		textFact.setBounds(400, 90, 86, 20);
		contentPane.add(textFact);
		textFact.setColumns(10);

		btnFact = new JButton("Calcular fact");
		btnFact.setBounds(522, 89, 120, 23);
		contentPane.add(btnFact);

		lblNumero1 = new JLabel("Numero 1:");
		lblNumero1.setBounds(102, 190, 65, 14);
		contentPane.add(lblNumero1);

		textNum1 = new JTextField();
		textNum1.setColumns(10);
		textNum1.setBounds(194, 187, 86, 20);
		contentPane.add(textNum1);

		JLabel lblNumero1_1 = new JLabel("Exponente :");
		lblNumero1_1.setBounds(102, 235, 65, 14);
		contentPane.add(lblNumero1_1);

		textNum2 = new JTextField();
		textNum2.setColumns(10);
		textNum2.setBounds(194, 232, 86, 20);
		contentPane.add(textNum2);

		lblPotencia = new JLabel("Potencia");
		lblPotencia.setBounds(320, 215, 65, 14);
		contentPane.add(lblPotencia);

		textPot = new JTextField();
		textPot.setColumns(10);
		textPot.setBounds(374, 212, 179, 20);
		contentPane.add(textPot);

		btnPot = new JButton("Calcular pot");
		btnPot.setBounds(522, 300, 120, 23);
		contentPane.add(btnPot);

		registrarEventos();


	}//FIN DEL CONSTRUCTOR


	public void registrarEventos() {

		btnPot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				/*CON TRY... CATCH RECOGER LOS VALORES DE LA BASE Y DEL EXPONENTE 
				 * COMPROBAR QUE SON NUMEROS*/

				/* SI SON "CORRECTOS" HACER LA LLAMADA A LA FUNCION POTENCIA
				 */
				int num,pot;
				double resultado;

				try {
					num=Integer.parseInt(textNum1.getText());
					pot=Integer.parseInt(textNum2.getText());
					
					resultado=potencia(num,pot);
					textPot.setText(resultado+" ");
					
				}catch(NumberFormatException ex) {
					return;

					
				}
			}
		});

		btnFact.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int num;
				double resultado;

				//COGER EL VALOR DEL NUMERO 
				try {
					num=Integer.parseInt(txtNum.getText()); 
					//LLAMAR A LA FUNCION FACTORIAL PARA QUE LO CALCULE Y ME DEVUELVA EL RESULTADO

					if(num<0) {
						JOptionPane.showMessageDialog(null, "No existe factorial de numeros negativos");
						return;
					}

					resultado=factorial(num);
					textFact.setText(resultado+" ");//CONVIERTE AUTOMATICAMENTE EN STRING
					//txtFact.setText(factorial(num)+""); OTRA MANERA DE HACERLO


				}catch(NumberFormatException ex) {
					return;
				}
			}


		});
	}//FIN DE REGISTRAR EVENTOS

	public double factorial(int num) {
		double result;

		if(num==0 || num==1) {
			return 1;
		}

		result=num*factorial(num-1);
		return result;
	}

	public double potencia(int num, int pot) {
		double result;
		boolean cambio = false;
		
		if(pot<0) {
			pot = -pot;
			cambio=true;
		}
		
		if(pot==0) {
			return 1;
		} else if(pot==1) {
			return num;
		}
		
		result = num*potencia  (num,pot-1);
		
		if(cambio == true) {
			result=1/result;
		}
		
		return result;
	}
}

