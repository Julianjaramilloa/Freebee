package ui;

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

import logic.UserList;


public class NewAcc extends JFrame implements ActionListener {

	JButton saveAcc;
	JButton getHelp;
	
	JLabel welcomeLabel;
	JLabel nameLabel;
	JLabel passLabel;
	JLabel currencyLabel;
	JLabel warningLabel;
	JTextField nameField;
	JTextField balanceField;
	JTextField currencyField;
	
	String accName;
	Float balance;
	String currency;
	
	UserList ul;
	
	public NewAcc(UserList ul) {
		this.ul = ul;
	}
	
	public void createAcc(){
		
		System.out.println("Ventana NewAcc");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tamaño
		welcomeLabel.setText("Nueva cuenta"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// -------- Label: Títulos y advertencia ----------------
		
		nameLabel = new JLabel(); 
		nameLabel.setBounds(150,110,300,70); // Tamaño
		nameLabel.setText("Nombre"); // Texto
		nameLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		nameLabel.setForeground(Color.BLACK); // Color del texto
		nameLabel.setVisible(true); // Visibilidad
		
		passLabel = new JLabel(); 
		passLabel.setBounds(150,190,300,70); // Tamaño
		passLabel.setText("Balance inicial"); // Texto
		passLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		passLabel.setForeground(Color.BLACK); // Color del texto
		passLabel.setVisible(true); // Visibilidad
		
		currencyLabel = new JLabel(); 	
		currencyLabel.setBounds(150,270,300,70); // Tamaño
		currencyLabel.setText("Tipo de divisa"); // Texto
		currencyLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		currencyLabel.setForeground(Color.BLACK); // Color del texto
		currencyLabel.setVisible(true); // Visibilidad
		
		warningLabel = new JLabel(); 
		warningLabel.setBounds(165,480,280,60); // Tamaño
		warningLabel.setText("No use el caracter ';' para evitar fallos en la aplicación"); // Texto
		warningLabel.setFont(new Font("Nunito", Font.ITALIC, 10)); // Fuente
		warningLabel.setForeground(Color.BLACK); // Color del texto
		warningLabel.setVisible(true); // Visibilidad
		
		// ------------ Botón: Crear nuevo ususario -----------------------
		
		saveAcc = new JButton();
		saveAcc.setBounds(262,430,70,25); // Tamaño
		saveAcc.setText("Guardar"); // Texto
		saveAcc.setBorder(new LineBorder(Color.BLACK)); // Borde
		saveAcc.setFont(new Font("Consolas", Font.BOLD, 12)); // Fuente
		saveAcc.setForeground(Color.BLACK); // Color del texto
		saveAcc.setBackground(Color.WHITE); // Color del fondo
		saveAcc.setFocusable(false); // Quitar cuadro alrededor
		saveAcc.addActionListener(this); // Añadir ActionListener
		saveAcc.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
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
		
		// ------------- TextField: Datos de nuevo usuario ------
		
		// accName
		nameField = new JTextField(); 
		nameField.setVisible(true);
		nameField.setText(""); // Texto por defecto
		nameField.setBounds(145, 160, 305, 40); // Tamaño
		nameField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		nameField.setForeground(Color.BLACK);  // Color del texto
		nameField.setBackground(Color.WHITE); // Color del fondo
		nameField.setCaretColor(Color.DARK_GRAY); // Color del caret

		// Password
		balanceField = new JTextField(); 
		balanceField.setVisible(true);
		balanceField.setText("0"); // Texto por defecto
		balanceField.setBounds(145, 240, 305, 40); // Tamaño
		balanceField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		balanceField.setForeground(Color.BLACK);  // Color del texto
		balanceField.setBackground(Color.WHITE); // Color del fondo
		balanceField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
		// Confirm password
		currencyField = new JTextField(); 
		currencyField.setVisible(true);
		currencyField.setText(""); // Texto por defecto
		currencyField.setBounds(145, 320, 305, 40); // Tamaño
		currencyField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		currencyField.setForeground(Color.BLACK);  // Color del texto
		currencyField.setBackground(Color.WHITE); // Color del fondo
		currencyField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
				
		// ------------- Frame -------------------------------
		
		this.add(saveAcc);
		this.add(getHelp);
		this.add(welcomeLabel);
		this.add(nameLabel);
		this.add(passLabel);
		this.add(currencyLabel);
		this.add(warningLabel);
		this.add(nameField);
		this.add(balanceField);
		this.add(currencyField);
		
		this.setTitle("Freebee"); // Título
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
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
		
		if (pressed.getSource() == saveAcc) {
			accName = nameField.getText();
			balance = Float.parseFloat(balanceField.getText());
			currency = currencyField.getText();
			
			if (accName.isBlank() == false && currency.isBlank() == false) {
				System.out.println("Nueva cuenta obtenida: " + accName + " Balance: $" + balance + " Currency: " + currency);
				JOptionPane.showMessageDialog(null, "La cuenta " + accName + " se ha \nguardado correctamente", "Cuenta creada", JOptionPane.INFORMATION_MESSAGE);
				
				
				ul.getUser().addAccount(accName, balance, currency);
				
				saveAcc.setEnabled(false); // Desabilita el botón
				this.dispose();
				
			} else {
				System.out.println("¡Falta nombre o currency!");
				JOptionPane.showMessageDialog(null, "Por favor llene todos los campos", "Faltan datos", JOptionPane.WARNING_MESSAGE);
			}	
			
		}
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displayNewAccHelp();
		}
		
	}	
}