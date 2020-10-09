package farmacia;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtID1;
	private JTextField txtcontra1;
	private JTextField txtnom1;
	private JTextField txtappat;
	private JTextField txtapmat;
	private JTextField txtemail;
	private JTextField txtTelefono;
	private JTextField textField;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(0, 11, 32, 14);
		contentPane.add(lblNewLabel);
		
		txtID1 = new JTextField();
		txtID1.setBounds(30, 8, 46, 20);
		contentPane.add(txtID1);
		txtID1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(133, 11, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		txtcontra1 = new JTextField();
		txtcontra1.setBounds(226, 8, 104, 20);
		contentPane.add(txtcontra1);
		txtcontra1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(30, 77, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtnom1 = new JTextField();
		txtnom1.setBounds(118, 74, 122, 20);
		contentPane.add(txtnom1);
		txtnom1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido Paterno");
		lblNewLabel_3.setBounds(10, 124, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		txtappat = new JTextField();
		txtappat.setBounds(118, 121, 122, 20);
		contentPane.add(txtappat);
		txtappat.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido Materno");
		lblNewLabel_4.setBounds(10, 172, 114, 14);
		contentPane.add(lblNewLabel_4);
		
		txtapmat = new JTextField();
		txtapmat.setBounds(118, 172, 122, 20);
		contentPane.add(txtapmat);
		txtapmat.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(284, 77, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtemail = new JTextField();
		txtemail.setBounds(352, 74, 122, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setBounds(284, 124, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(352, 121, 122, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Genero ");
		lblNewLabel_7.setBounds(284, 172, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(352, 169, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(425, 172, 46, 12);
		contentPane.add(scrollPane);
	}
}
