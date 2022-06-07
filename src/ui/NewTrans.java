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


public class NewTrans extends JFrame implements ActionListener {

	JButton saveTrans;
	JButton getHelp;
	
	JLabel welcomeLabel;
	JLabel descLabel;
	JLabel valueLabel;
	
	JLabel warningLabel;
	
	JTextField descField;
	JTextField valueField;
	
	String username;
	String password;
	String cpass;
	
	
	public void createTrans(){
		
		System.out.println("Ventana NewTrans");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tamaño
		welcomeLabel.setText("Nueva transacción"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// -------- Label: Títulos y advertencia ----------------
		
		descLabel = new JLabel(); 
		descLabel.setBounds(150,110,300,70); // Tamaño
		descLabel.setText("Descripción:"); // Texto
		descLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		descLabel.setForeground(Color.BLACK); // Color del texto
		descLabel.setVisible(true); // Visibilidad
		
		valueLabel = new JLabel(); 
		valueLabel.setBounds(150,190,300,70); // Tamaño
		valueLabel.setText("Valor:"); // Texto
		valueLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		valueLabel.setForeground(Color.BLACK); // Color del texto
		valueLabel.setVisible(true); // Visibilidad
		
		warningLabel = new JLabel(); 
		warningLabel.setBounds(165,480,280,60); // Tamaño
		warningLabel.setText("No use el caracter ';' para evitar fallos en la aplicación"); // Texto
		warningLabel.setFont(new Font("Nunito", Font.ITALIC, 10)); // Fuente
		warningLabel.setForeground(Color.BLACK); // Color del texto
		warningLabel.setVisible(true); // Visibilidad
		
		// ------------ Botón: Crear nuevo ususario -----------------------
		
		saveTrans = new JButton();
		saveTrans.setBounds(262,430,70,25); // Tamaño
		saveTrans.setText("Guardar"); // Texto
		saveTrans.setBorder(new LineBorder(Color.BLACK)); // Borde
		saveTrans.setFont(new Font("Consolas", Font.BOLD, 12)); // Fuente
		saveTrans.setForeground(Color.BLACK); // Color del texto
		saveTrans.setBackground(Color.WHITE); // Color del fondo
		saveTrans.setFocusable(false); // Quitar cuadro alrededor
		saveTrans.addActionListener(this); // Añadir ActionListener
		saveTrans.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
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
		
		// Username
		descField = new JTextField(); 
		descField.setVisible(true);
		descField.setText(""); // Texto por defecto
		descField.setBounds(145, 160, 305, 40); // Tamaño
		descField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		descField.setForeground(Color.BLACK);  // Color del texto
		descField.setBackground(Color.WHITE); // Color del fondo
		descField.setCaretColor(Color.DARK_GRAY); // Color del caret

		// Password
		valueField = new JTextField(); 
		valueField.setVisible(true);
		valueField.setText(""); // Texto por defecto
		valueField.setBounds(145, 240, 305, 40); // Tamaño
		valueField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		valueField.setForeground(Color.BLACK);  // Color del texto
		valueField.setBackground(Color.WHITE); // Color del fondo
		valueField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
		
				
		// ------------- Frame -------------------------------
		
		this.add(saveTrans);
		this.add(getHelp);
		this.add(welcomeLabel);
		this.add(descLabel);
		this.add(valueLabel);
		this.add(warningLabel);
		this.add(descField);
		this.add(valueField);
		
		this.setTitle("Freebee"); // Título
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLayout(null); // Layout
		this.setSize(600,580); // Dimensiones
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
		
		if (pressed.getSource() == saveTrans) {
			username = descField.getText();
			password = valueField.getText();
		
		}
		
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displayNewTransHelp();
		}
		
	}	
}
