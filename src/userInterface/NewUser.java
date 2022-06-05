package userInterface;

/*
 * Freebe
 * @author Marcos Pinz�n Pardo
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class NewUser extends JFrame implements ActionListener {

	JButton saveUser;
	JButton getHelp;
	JLabel welcomeLabel;
	JLabel nameLabel;
	JLabel passLabel;
	JLabel cpassLabel;
	JLabel warningLabel;
	JTextField nameField;
	JTextField passField;
	JTextField cpassField;
	
	String username;
	String password;
	String cpass;
	
	
	public void createUser(){
		
		System.out.println("Ventana NewUser");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(60,30,400,60); // Tama�o
		welcomeLabel.setText("Creaci�n de usuario"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// -------- Label: T�tulos y advertencia ----------------
		
		nameLabel = new JLabel(); 
		nameLabel.setBounds(150,110,300,70); // Tama�o
		nameLabel.setText("Nombre de usuario"); // Texto
		nameLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		nameLabel.setForeground(Color.BLACK); // Color del texto
		nameLabel.setVisible(true); // Visibilidad
		
		passLabel = new JLabel(); 
		passLabel.setBounds(150,190,300,70); // Tama�o
		passLabel.setText("Crea una contrase�a"); // Texto
		passLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		passLabel.setForeground(Color.BLACK); // Color del texto
		passLabel.setVisible(true); // Visibilidad
		
		cpassLabel = new JLabel(); 	
		cpassLabel.setBounds(150,270,300,70); // Tama�o
		cpassLabel.setText("Confirma tu contrase�a"); // Texto
		cpassLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		cpassLabel.setForeground(Color.BLACK); // Color del texto
		cpassLabel.setVisible(true); // Visibilidad
		
		warningLabel = new JLabel(); 
		warningLabel.setBounds(165,480,280,60); // Tama�o
		warningLabel.setText("No use el caracter ';' para evitar fallos en la aplicaci�n"); // Texto
		warningLabel.setFont(new Font("Nunito", Font.ITALIC, 10)); // Fuente
		warningLabel.setForeground(Color.BLACK); // Color del texto
		warningLabel.setVisible(true); // Visibilidad
		
		// ------------ Bot�n: Crear nuevo ususario -----------------------
		
		saveUser = new JButton();
		saveUser.setBounds(262,430,70,25); // Tama�o
		saveUser.setText("Guardar"); // Texto
		saveUser.setBorder(new LineBorder(Color.BLACK)); // Borde
		saveUser.setFont(new Font("Consolas", Font.BOLD, 12)); // Fuente
		saveUser.setForeground(Color.BLACK); // Color del texto
		saveUser.setBackground(Color.WHITE); // Color del fondo
		saveUser.setFocusable(false); // Quitar cuadro alrededor
		saveUser.addActionListener(this); // A�adir ActionListener
		saveUser.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Bot�n: Obtener ayuda -----------------------
		
		getHelp = new JButton();
		getHelp.setBounds(510,500,25,25); // Tama�o
		getHelp.setText("?"); // Texto
		getHelp.setBorder(new LineBorder(Color.BLACK)); // Borde
		getHelp.setFont(new Font("Consolas", Font.ITALIC, 12)); // Fuente
		getHelp.setForeground(Color.BLACK); // Color del texto
		getHelp.setBackground(Color.WHITE); // Color del fondo
		getHelp.setFocusable(false); // Quitar cuadro alrededor
		getHelp.addActionListener(this); // A�adir ActionListener
		getHelp.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------- TextField: Datos de nuevo usuario ------
		
		// Username
		nameField = new JTextField(); 
		nameField.setVisible(true);
		nameField.setText(""); // Texto por defecto
		nameField.setBounds(145, 160, 305, 40); // Tama�o
		nameField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		nameField.setForeground(Color.BLACK);  // Color del texto
		nameField.setBackground(Color.WHITE); // Color del fondo
		nameField.setCaretColor(Color.DARK_GRAY); // Color del caret

		// Password
		passField = new JTextField(); 
		passField.setVisible(true);
		passField.setText(""); // Texto por defecto
		passField.setBounds(145, 240, 305, 40); // Tama�o
		passField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		passField.setForeground(Color.BLACK);  // Color del texto
		passField.setBackground(Color.WHITE); // Color del fondo
		passField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
		// Confirm password
		cpassField = new JTextField(); 
		cpassField.setVisible(true);
		cpassField.setText(""); // Texto por defecto
		cpassField.setBounds(145, 320, 305, 40); // Tama�o
		cpassField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		cpassField.setForeground(Color.BLACK);  // Color del texto
		cpassField.setBackground(Color.WHITE); // Color del fondo
		cpassField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
				
		// ------------- Frame -------------------------------
		
		this.add(saveUser);
		this.add(getHelp);
		this.add(welcomeLabel);
		this.add(nameLabel);
		this.add(passLabel);
		this.add(cpassLabel);
		this.add(warningLabel);
		this.add(nameField);
		this.add(passField);
		this.add(cpassField);
		
		this.setTitle("Freebee"); // T�tulo
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(null); // Layout
		this.setSize(600,600); // Dimensiones
		this.setResizable(false); // No cambia de tama�o
		this.getContentPane().setBackground(Color.WHITE); // Color de fondo
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setVisible(true); // Visible
		this.setLocationRelativeTo(null); // Muestra en centro

	}
	
	// Criterio al presionar el bot�n
	@Override
	public void actionPerformed(ActionEvent pressed) {
		
		if (pressed.getSource() == saveUser) {
			username = nameField.getText();
			password = passField.getText();
			cpass = cpassField.getText();
			
			if (password.equals(cpass)) {
				System.out.println("Nuevo usuario obtenido: " + username + " " + password + "," + cpass);
				JOptionPane.showMessageDialog(null, "El usuario " + username + " se ha \nguardado correctamente", "Usuario registrado", JOptionPane.INFORMATION_MESSAGE);
				// Crear y escribir nuevo usuario en registros
				saveUser.setEnabled(false); // Desabilita el bot�n
				this.dispose();
				new MainMenu();
			} else {
				System.out.println("�Las contrase�as no coinciden!");
				JOptionPane.showMessageDialog(null, "Las contrase�as no coinciden", "Intentelo de nuevo", JOptionPane.WARNING_MESSAGE);
			}			
		}
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displayNewUserHelp();
		}
		
	}	
}