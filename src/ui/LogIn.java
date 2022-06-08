package userInterface;

/*
 * Freebe
 * @author Marcos Pinzón Pardo
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
//import ui.MainMenu;


public class LogIn extends JFrame implements ActionListener {

	JButton logIn;
	JButton getHelp;
	JButton newUser;
	JLabel welcomeLabel;
	JLabel nameLabel;
	JLabel passLabel;
	JLabel promptLabel;
	JTextField nameField;
	JTextField passField;
	
	String username;
	String password;
	
	
	public void credentialsIn(){
		
		System.out.println("Ventana Log In");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tamaño
		welcomeLabel.setText("Inicio de sesión"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// -------- Label: Títulos y advertencia ----------------
		
		nameLabel = new JLabel(); 
		nameLabel.setBounds(150,135,300,70); // Tamaño
		nameLabel.setText("Usuario"); // Texto
		nameLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		nameLabel.setForeground(Color.BLACK); // Color del texto
		nameLabel.setVisible(true); // Visibilidad
		
		passLabel = new JLabel(); 
		passLabel.setBounds(150,215,300,70); // Tamaño
		passLabel.setText("Contraseña"); // Texto
		passLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		passLabel.setForeground(Color.BLACK); // Color del texto
		passLabel.setVisible(true); // Visibilidad
		
		promptLabel = new JLabel(); 	
		promptLabel.setBounds(205,335,300,70); // Tamaño
		promptLabel.setText("¿No tienes usuario?"); // Texto
		promptLabel.setFont(new Font("Nunito", Font.ITALIC, 9)); // Fuente
		promptLabel.setForeground(Color.BLACK); // Color del texto
		promptLabel.setVisible(true); // Visibilidad
		
		
		// ------------ Botón: Iniciar sesión -----------------------
		
		logIn = new JButton();
		logIn.setBounds(230,420,120,30); // Tamaño
		logIn.setText("Iniciar sesión"); // Texto
		logIn.setBorder(new LineBorder(Color.BLACK)); // Borde
		logIn.setFont(new Font("Consolas", Font.BOLD, 14)); // Fuente
		logIn.setForeground(Color.WHITE); // Color del texto
		logIn.setBackground(Color.BLACK); // Color del fondo
		logIn.setFocusable(false); // Quitar cuadro alrededor
		logIn.addActionListener(this); // Añadir ActionListener
		logIn.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Botón: Obtener ayuda -----------------------
		
		getHelp = new JButton();
		getHelp.setBounds(510,500,25,25); // Tamaño
		getHelp.setText("?"); // Texto
		getHelp.setBorder(new LineBorder(Color.BLACK)); // Borde
		getHelp.setFont(new Font("Consolas", Font.ITALIC, 12)); // Fuente
		getHelp.setForeground(Color.BLACK); // Color del texto
		getHelp.setBackground(Color.WHITE); // Color del fondo
		getHelp.setFocusable(false); // Quitar cuadro alrededor
		getHelp.addActionListener(this); // Añadir ActionListener
		getHelp.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Botón: Nuevo usuario -----------------------
		
		newUser = new JButton();
		newUser.setBounds(300,359,75,22); // Tamaño
		newUser.setText("Crear usuario"); // Texto
		newUser.setBorder(new LineBorder(Color.BLACK)); // Borde
		newUser.setFont(new Font("Consolas", Font.PLAIN, 9)); // Fuente
		newUser.setForeground(Color.BLACK); // Color del texto
		newUser.setBackground(Color.WHITE); // Color del fondo
		newUser.setFocusable(false); // Quitar cuadro alrededor
		newUser.addActionListener(this); // Añadir ActionListener
		newUser.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------- TextField: Datos de log in ------
		
		// Username
		nameField = new JTextField(); 
		nameField.setVisible(true);
		nameField.setText(""); // Texto por defecto
		nameField.setBounds(145, 185, 305, 40); // Tamaño
		nameField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		nameField.setForeground(Color.BLACK);  // Color del texto
		nameField.setBackground(Color.WHITE); // Color del fondo
		nameField.setCaretColor(Color.DARK_GRAY); // Color del caret

		// Password
		passField = new JTextField(); 
		passField.setVisible(true);
		passField.setText(""); // Texto por defecto
		passField.setBounds(145, 265, 305, 40); // Tamaño
		passField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		passField.setForeground(Color.BLACK);  // Color del texto
		passField.setBackground(Color.WHITE); // Color del fondo
		passField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
		
				
		// ------------- Frame -------------------------------
		
		this.add(logIn);
		this.add(getHelp);
		this.add(newUser);
		this.add(welcomeLabel);
		this.add(nameLabel);
		this.add(passLabel);
		this.add(promptLabel);
		this.add(nameField);
		this.add(passField);
		
		this.setTitle("Freebee"); // Título
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null); // Layout
		this.setSize(600,600); // Dimensiones
		this.setResizable(false); // No cambia de tamaño
		this.getContentPane().setBackground(Color.WHITE); // Color de fondo
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setVisible(true); // Visible
		this.setLocationRelativeTo(null); // Muestra en centro

	}
	
	// Criterio al presionar el botón
	@Override
	public void actionPerformed(ActionEvent pressed) {
		
		if (pressed.getSource() == logIn) {
			
			username = nameField.getText();
			password = passField.getText();
			System.out.println("Username input: " + username + " Password input: " + password);
			
			
			//Encontrar usuario
			
//			String login = ul.login(username, password);
//			if (login.equals("alright")) {
//				System.out.println("Username input: " + username + " Password input: " + password);
//				Categories ct = new Categories();
//				ct.categories();
//				this.dispose();
//			} else {
//				System.out.println(login);
//				JOptionPane.showMessageDialog(null, login, "Error", JOptionPane.WARNING_MESSAGE);
//			}					
					
		}
		
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displayLogInHelp();
		}
		
		if (pressed.getSource() == newUser) {
			System.out.println("Abriendo creación de nuevo usuario");
			NewUser nw = new NewUser(); 
			nw.createUser();
		}
		
	}	
}
