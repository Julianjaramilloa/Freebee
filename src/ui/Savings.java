package userInterface;

/*
 * Freebie
 * @author Marcos Pinz�n Pardo
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Savings extends JFrame implements ActionListener {

	JButton catPage;
	JButton accPage;
	JButton savesPage;
	JButton statsPage;
	JButton settPage;
	JButton addTrans;
	JButton getHelp;

	JLabel welcomeLabel;	
	
	public void savings(){
		
		System.out.println("Ventana Savings");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tama�o
		welcomeLabel.setText("Ahorro / Tips"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// ================= BOTONES FIJOS =============================
		
		// ------------ Bot�n: Pagina categor�as -------------------
		
		catPage = new JButton();
        catPage.setBounds(22,495,110,40); // Tama�o
        catPage.setText("Categor�as"); // Texto
        catPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        catPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        catPage.setForeground(Color.BLACK); // Color del texto
        catPage.setBackground(Color.WHITE); // Color del fondo
        catPage.setFocusable(false); // Quitar cuadro alrededor
        catPage.addActionListener(this); // A�adir ActionListener 
        catPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
     
        // ------------ Bot�n: Pagina cuentas -------------------
		
     	accPage = new JButton();
        accPage.setBounds(147,495,110,40); // Tama�o
        accPage.setText("Cuentas"); // Texto
        accPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        accPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        accPage.setForeground(Color.BLACK); // Color del texto
        accPage.setBackground(Color.WHITE); // Color del fondo
        accPage.setFocusable(false); // Quitar cuadro alrededor
        accPage.addActionListener(this); // A�adir ActionListener
        accPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ Bot�n: Pagina ahorro -------------------
		
     	savesPage = new JButton();
        savesPage.setBounds(272,495,110,40); // Tama�o
        savesPage.setText("Ahorro"); // Texto
        savesPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        savesPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        savesPage.setForeground(Color.BLACK); // Color del texto
        savesPage.setBackground(Color.LIGHT_GRAY); // Color del fondo
        savesPage.setFocusable(false); // Quitar cuadro alrededor
        savesPage.addActionListener(this); // A�adir ActionListener 
        savesPage.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY)); // Borde
        savesPage.setEnabled(false); // Desabilita el bot�n
        
        // ------------ Bot�n: Pagina estad�sticas -------------------
		
     	statsPage = new JButton();
        statsPage.setBounds(397,495,110,40); // Tama�o
        statsPage.setText("Resumen"); // Texto
        statsPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        statsPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        statsPage.setForeground(Color.BLACK); // Color del texto
        statsPage.setBackground(Color.WHITE); // Color del fondo
        statsPage.setFocusable(false); // Quitar cuadro alrededor
        statsPage.addActionListener(this); // A�adir ActionListener
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ Bot�n: Pagina ajustes -------------------
		
     	settPage = new JButton();
        settPage.setBounds(522,495,40,40); // Tama�o
        settPage.setText("="); // Texto
        settPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        settPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        settPage.setForeground(Color.BLACK); // Color del texto
        settPage.setBackground(Color.WHITE); // Color del fondo
        settPage.setFocusable(false); // Quitar cuadro alrededor
        settPage.addActionListener(this); // A�adir ActionListener
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
		
		// ------------ Bot�n: Crear transacci�n -------------------
	
		addTrans = new JButton();
		addTrans.setBounds(505,440,25,25); // Tama�o
		addTrans.setText("+"); // Texto
		addTrans.setBorder(new LineBorder(Color.BLACK)); // Borde
		addTrans.setFont(new Font("Consolas", Font.BOLD, 14)); // Fuente
		addTrans.setForeground(Color.ORANGE); // Color del texto
		addTrans.setBackground(Color.WHITE); // Color del fondo
		addTrans.setFocusable(false); // Quitar cuadro alrededor
		addTrans.addActionListener(this); // A�adir ActionListener
		addTrans.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Bot�n: Obtener ayuda -----------------------
		
		getHelp = new JButton();
		getHelp.setBounds(50,440,25,25); // Tama�o
		getHelp.setText("?"); // Texto
		getHelp.setBorder(new LineBorder(Color.BLACK)); // Borde
		getHelp.setFont(new Font("Consolas", Font.ITALIC, 12)); // Fuente
		getHelp.setForeground(Color.BLACK); // Color del texto
		getHelp.setBackground(Color.WHITE); // Color del fondo
		getHelp.setFocusable(false); // Quitar cuadro alrededor
		getHelp.addActionListener(this); // A�adir ActionListener
		getHelp.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
					
		// ------------- Frame -------------------------------
		
		
		this.add(catPage);
		this.add(accPage);
		this.add(savesPage);
		this.add(statsPage);
		this.add(settPage);
		this.add(getHelp);
		this.add(addTrans);
		
		this.add(welcomeLabel);


		
		this.setTitle("Freebee"); // T�tulo
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null); // Layout
		this.setSize(600,600); // Dimensiones
		this.setResizable(false); // No cambia de tama�o
		this.getContentPane().setBackground(Color.WHITE); // Color de fondo
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setVisible(true); // Visible
		this.setLocationRelativeTo(null); // Muestra en centro

		
	}
	
	private void readData() {
		
		File f = new File("tips.txt");
		try {
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				tokenize(line);
			}
			sc.close();
			} catch (FileNotFoundException e) {
			System.out.println("Error leyendo archivo citasSample.txt");
			e.printStackTrace();
		}
	}
	
	private void tokenize(String line) {
		
		Scanner sc = new Scanner(line);
		sc.useDelimiter(";");
		
		String cita = sc.next().trim();
		String autor = sc.next().trim();
		
		String tip = cita + " -" + autor;
		
		System.out.println(tip);
			
		// A�adir al array (cita,autor);
		
		//printRandomTip(arr);
		
		sc.close();

	}
	
	//private void printRandomTip(DynamicArray arr) {
		// Aqu� pondr� el c�digo que genere un �ndice al azar para que se muestre en pantalla
		// pero para hacerlo primero se necesita que funcione lo otro
	//}
	
	// Criterio al presionar el bot�n
	
	@Override
	public void actionPerformed(ActionEvent pressed) {
		
		//--------------------------------------------------------
		
		if (pressed.getSource() == catPage) {
			System.out.println("Abriendo Categories");
			Categories ct = new Categories();
			ct.categories();
			this.dispose();
		}
				
		if (pressed.getSource() == accPage) {
			System.out.println("Abriendo Accounts");
			Accounts ac = new Accounts();
			ac.accounts();
			this.dispose();
		}
				
		if (pressed.getSource() == savesPage) {
			System.out.println("Abriendo Savings");
			Savings sv = new Savings();
			sv.savings();
			this.dispose();
		}
				
		if (pressed.getSource() == statsPage) {
			System.out.println("Abriendo Stats");
			Stats st = new Stats();
			st.stats();
			this.dispose();
		}
				
		if (pressed.getSource() == settPage) {
			System.out.println("Abriendo Settings");
			Settings st = new Settings();
			st.settings();
			this.dispose();
		}
				
		if (pressed.getSource() == addTrans) {
			System.out.println("Abriendo CreateTrans");
			NewTrans nt = new NewTrans();
			nt.createTrans();
		}
				
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displaySavingsHelp();
		}
	}	
}