package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Conexion.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

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
	private JTextField textField_1;
	private int tipo;
	private Conexion conector;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private boolean hola;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*/

	/**
	 * Create the frame.
	 */
	public Registro(boolean hola, int tipo) {
		this.hola = hola;
		this.tipo = tipo;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 508, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(30, 29, 32, 14);
		contentPane.add(lblNewLabel);
		
		txtID1 = new JTextField();
		txtID1.setBounds(72, 26, 46, 20);
		txtID1.setEnabled(false);
		contentPane.add(txtID1);
		txtID1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(284, 79, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		txtcontra1 = new JTextField();
		txtcontra1.setBounds(352, 76, 122, 20);
		contentPane.add(txtcontra1);
		txtcontra1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(30, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txtnom1 = new JTextField();
		txtnom1.setBounds(132, 121, 122, 20);
		contentPane.add(txtnom1);
		txtnom1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido Paterno");
		lblNewLabel_3.setBounds(30, 172, 114, 14);
		contentPane.add(lblNewLabel_3);
		
		txtappat = new JTextField();
		txtappat.setBounds(132, 169, 122, 20);
		contentPane.add(txtappat);
		txtappat.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido Materno");
		lblNewLabel_4.setBounds(30, 222, 114, 14);
		contentPane.add(lblNewLabel_4);
		
		txtapmat = new JTextField();
		txtapmat.setBounds(132, 219, 122, 20);
		contentPane.add(txtapmat);
		txtapmat.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(284, 124, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtemail = new JTextField();
		txtemail.setBounds(352, 121, 122, 20);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono");
		lblNewLabel_6.setBounds(284, 172, 75, 14);
		contentPane.add(lblNewLabel_6);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(352, 169, 122, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Genero ");
		lblNewLabel_7.setBounds(284, 260, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setBounds(30, 79, 75, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(132, 76, 122, 20);
		contentPane.add(textField);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Femenino", "Otro"}));
		comboBox.setBounds(352, 260, 122, 20);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_7_1 = new JLabel("Edad");
		lblNewLabel_7_1.setBounds(284, 222, 46, 14);
		contentPane.add(lblNewLabel_7_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(352, 219, 122, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("Puesto");
		lblNewLabel_7_2.setBounds(30, 260, 46, 14);
		contentPane.add(lblNewLabel_7_2);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador", "Gerente", "Empleado"}));
		comboBox_1.setBounds(132, 260, 122, 20);
		
		contentPane.add(comboBox_1);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salirMetodo();
			}
		});
		btnNewButton.setBounds(30, 314, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(385, 314, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (hola) {
					Guardar();
				}else{
					Editar();
				}
			}
		});
		contentPane.add(btnGuardar);
		if (!hola) {
			llenar();
		}
	}
	private void salirMetodo() {
		this.dispose();		
	}
	
	
	public void Guardar() {
		int id = 0;
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Conexion conector2 = new Conexion();
		Connection conexion;
		Connection conexion2;
		Connection conexion3;
		try {
			conexion = conector.conectar();
		
				ps=conexion.prepareStatement("INSERT INTO `usu_farmacia`.`mempleado` (`id_puesto`, `nombre`, `apat_emp`, `amat_emp`, `direccion`, `telefono`, `email`, `genero`, `edad`) VALUES (?, ?, ?, ?,?,?,?,?,?);");
				System.out.print(comboBox_1.getSelectedIndex());
				ps.setInt(1,(comboBox_1.getSelectedIndex()));
				ps.setString(2,(txtnom1.getText()));
				ps.setString(3,(txtappat.getText()));
				ps.setString(4,(txtapmat.getText()));
				ps.setString(5,("Vacio"));
				ps.setString(6,(txtTelefono.getText()));
				ps.setString(7,(txtemail.getText()));
				ps.setString(8,(comboBox.getSelectedItem().toString()));
				ps.setString(9,(textField_1.getText()));
				ps.executeUpdate();
				

				ps=conexion.prepareStatement("SELECT*FROM mempleado order by id_empleado desc");
				rs =  ps.executeQuery();
				if((rs).next()) {
				id = rs.getInt("id_empleado");
				}
				
				ps=conexion.prepareStatement("INSERT INTO `usu_farmacia`.`musuario` (`id_empleado`, `id_puesto`, `nombre_usuario`, `contraseña`) VALUES (?,?,?,?);");
				ps.setInt(1,(id));
				ps.setInt(2,(comboBox_1.getSelectedIndex()));
				ps.setString(3,(textField.getText()));
				ps.setString(4,(txtcontra1.getText()));
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Registro guardado");

				salirMetodo();
				
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
			
		
	}
		
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public void Editar() {
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Connection conexion;
		try {
			conexion = conector.conectar();
		
				ps=conexion.prepareStatement("UPDATE   mempleado SET id_puesto = ?, nombre= ?, apat_emp= ?, amat_emp= ?, direccion= ?, telefono= ?, email= ?, genero= ?, edad= ? WHERE id_empleado = ? ");
				System.out.print(comboBox_1.getSelectedIndex());
				ps.setInt(1,(comboBox_1.getSelectedIndex()));
				ps.setString(2,(txtnom1.getText()));
				ps.setString(3,(txtappat.getText()));
				ps.setString(4,(txtapmat.getText()));
				ps.setString(5,("Vacio"));
				ps.setString(6,(txtTelefono.getText()));
				ps.setString(7,(txtemail.getText()));
				ps.setString(8,(comboBox.getSelectedItem().toString()));
				ps.setString(9,(textField_1.getText()));
				ps.setInt(10,(Integer.valueOf(txtID1.getText())));
				ps.executeUpdate();
				
				ps=conexion.prepareStatement("UPDATE musuario SET id_empleado= ?, id_puesto= ?, nombre_usuario= ?, contraseña= ?  where id_empleado = ?;");
				ps.setInt(1,(Integer.valueOf(txtID1.getText())));
				ps.setInt(2,(comboBox_1.getSelectedIndex()));
				ps.setString(3,(textField.getText()));
				ps.setString(4,(txtcontra1.getText()));
				ps.setInt(5,(Integer.valueOf(txtID1.getText())));
				ps.executeUpdate();
				
				JOptionPane.showMessageDialog(null,"Registro guardado");
				salirMetodo();
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
			
		
	}
	public void llenar() {
		txtID1.setText(Integer.valueOf(tipo).toString());
		PreparedStatement ps;
		ResultSet rs;
		conector = new Conexion();
		Conexion conector2 = new Conexion();
		Connection conexion;
		Connection conexion2;
		Connection conexion3;
		try {
			conexion = conector.conectar();
		
				
				

				ps=conexion.prepareStatement("SELECT*FROM mempleado where id_empleado = ?");
				ps.setInt(1,(tipo));
				rs =  ps.executeQuery();
				if((rs).next()) {
				comboBox_1.setSelectedIndex(rs.getInt("id_puesto"));
				txtnom1.setText(rs.getString("nombre"));
				txtappat.setText(rs.getString("apat_emp"));
				txtapmat.setText(rs.getString("amat_emp"));
				txtTelefono.setText(rs.getString("telefono"));
				txtemail.setText(rs.getString("email"));
				textField_1.setText(rs.getString("edad"));
				comboBox.setSelectedItem(rs.getString("genero"));
				
				}
				
				ps=conexion.prepareStatement("SELECT*FROM musuario where id_empleado = ?");
				ps.setInt(1,(tipo));
				rs =  ps.executeQuery();
				if((rs).next()) {

				textField.setText(rs.getString("nombre_usuario"));
				txtcontra1.setText(rs.getString("contraseña"));
				
				
				}
				
				
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
			
		
	}
	
	
	
	//ps=conexion.prepareStatement("UPDATE almacen SET AlmCant=? WHERE AlmPro=?");
}	//	ps.executeUpdate(); 
