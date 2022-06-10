package ui;


/*
 * Freebie
 * @author Marcos Pinzón Pardo
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logic.UserList;

public class Settings extends JFrame implements ActionListener {

	JButton catPage;
	JButton accPage;
	JButton savesPage;
	JButton statsPage;
	JButton settPage;
	JButton addTrans;
	JButton getHelp;
	
	JButton user;
	JButton accounts;
	JButton general;
	JButton about;
	JLabel welcomeLabel;	
	
	UserList ul;
	
	public Settings(UserList ul) {
		this.ul = ul;
	}
	
	
	public void settings(){
		
		System.out.println("Ventana Settings");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tamaño
		welcomeLabel.setText("Ajustes"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		
		// ------------ Botón: Abrir usuarios -----------------------
		
		user = new JButton();
		user.setBounds(140,190,120,45); // Tamaño
		user.setText("Usuario"); // Texto
		user.setBorder(new LineBorder(Color.BLACK)); // Borde
		user.setFont(new Font("Consolas", Font.BOLD, 18)); // Fuente
		user.setForeground(Color.BLACK); // Color del texto
		user.setBackground(Color.WHITE); // Color del fondo
		user.setFocusable(false); // Quitar cuadro alrededor
		user.addActionListener(this); // Añadir ActionListener
		user.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Botón: Abrir cuentas -----------------------
		
		accounts = new JButton();
		accounts.setBounds(330,190,120,45); // Tamaño
		accounts.setText("Cuentas"); // Texto
		accounts.setBorder(new LineBorder(Color.BLACK)); // Borde
		accounts.setFont(new Font("Consolas", Font.BOLD, 18)); // Fuente
		accounts.setForeground(Color.BLACK); // Color del texto
		accounts.setBackground(Color.WHITE); // Color del fondo
		accounts.setFocusable(false); // Quitar cuadro alrededor
		accounts.addActionListener(this); // Añadir ActionListener
		accounts.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Botón: Abrir general -----------------------
		
		general = new JButton();
		general.setBounds(140,290,120,45); // Tamaño
		general.setText("General"); // Texto
		general.setBorder(new LineBorder(Color.BLACK)); // Borde
		general.setFont(new Font("Consolas", Font.BOLD, 18)); // Fuente
		general.setForeground(Color.BLACK); // Color del texto
		general.setBackground(Color.WHITE); // Color del fondo
		general.setFocusable(false); // Quitar cuadro alrededor
		general.addActionListener(this); // Añadir ActionListener
		general.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Botón: Abrir acerca de -----------------------
		
		about = new JButton();
		about.setBounds(330,290,120,45); // Tamaño
		about.setText("Acerca de"); // Texto
		about.setBorder(new LineBorder(Color.BLACK)); // Borde
		about.setFont(new Font("Consolas", Font.BOLD, 18)); // Fuente
		about.setForeground(Color.BLACK); // Color del texto
		about.setBackground(Color.WHITE); // Color del fondo
		about.setFocusable(false); // Quitar cuadro alrededor
		about.addActionListener(this); // Añadir ActionListener
		about.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ================= BOTONES FIJOS =============================
		
		// ------------ Botón: Pagina categorías -------------------
		
		catPage = new JButton();
        catPage.setBounds(22,495,110,40); // Tamaño
        catPage.setText("Categor�as"); // Texto
        catPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        catPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        catPage.setForeground(Color.BLACK); // Color del texto
        catPage.setBackground(Color.WHITE); // Color del fondo
        catPage.setFocusable(false); // Quitar cuadro alrededor
        catPage.addActionListener(this); // Añadir ActionListener
        catPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
     
        // ------------ Botón: Pagina cuentas -------------------
		
     	accPage = new JButton();
        accPage.setBounds(147,495,110,40); // Tamaño
        accPage.setText("Cuentas"); // Texto
        accPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        accPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        accPage.setForeground(Color.BLACK); // Color del texto
        accPage.setBackground(Color.WHITE); // Color del fondo
        accPage.setFocusable(false); // Quitar cuadro alrededor
        accPage.addActionListener(this); // Añadir ActionListener
        accPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ Botón: Pagina ahorro -------------------
		
     	savesPage = new JButton();
        savesPage.setBounds(272,495,110,40); // Tamaño
        savesPage.setText("Ahorro"); // Texto
        savesPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        savesPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        savesPage.setForeground(Color.BLACK); // Color del texto
        savesPage.setBackground(Color.WHITE); // Color del fondo
        savesPage.setFocusable(false); // Quitar cuadro alrededor
        savesPage.addActionListener(this); // Añadir ActionListener
        savesPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ Botón: Pagina estadísticas -------------------
		
     	statsPage = new JButton();
        statsPage.setBounds(397,495,110,40); // Tamaño
        statsPage.setText("Resumen"); // Texto
        statsPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        statsPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        statsPage.setForeground(Color.BLACK); // Color del texto
        statsPage.setBackground(Color.WHITE); // Color del fondo
        statsPage.setFocusable(false); // Quitar cuadro alrededor
        statsPage.addActionListener(this); // Añadir ActionListener
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ Botón: Pagina ajustes -------------------
		
     	settPage = new JButton();
        settPage.setBounds(522,495,40,40); // Tamaño
        settPage.setText("="); // Texto
        settPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        settPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        settPage.setForeground(Color.BLACK); // Color del texto
        settPage.setBackground(Color.LIGHT_GRAY); // Color del fondo
        settPage.setFocusable(false); // Quitar cuadro alrededor
        settPage.addActionListener(this); // Añadir ActionListener
        settPage.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY)); // Borde
        settPage.setEnabled(false); // Desabilita el botón
		
		// ------------ Botón: Crear transacción -------------------
	
		addTrans = new JButton();
		addTrans.setBounds(505,440,25,25); // Tamaño
		addTrans.setText("+"); // Texto
		addTrans.setBorder(new LineBorder(Color.BLACK)); // Borde
		addTrans.setFont(new Font("Consolas", Font.BOLD, 14)); // Fuente
		addTrans.setForeground(Color.ORANGE); // Color del texto
		addTrans.setBackground(Color.WHITE); // Color del fondo
		addTrans.setFocusable(false); // Quitar cuadro alrededor
		addTrans.addActionListener(this); // Añadir ActionListener
		addTrans.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ Botón: Obtener ayuda -----------------------
		
		getHelp = new JButton();
		getHelp.setBounds(50,440,25,25); // Tamaño
		getHelp.setText("?"); // Texto
		getHelp.setBorder(new LineBorder(Color.BLACK)); // Borde
		getHelp.setFont(new Font("Consolas", Font.ITALIC, 12)); // Fuente
		getHelp.setForeground(Color.BLACK); // Color del texto
		getHelp.setBackground(Color.WHITE); // Color del fondo
		getHelp.setFocusable(false); // Quitar cuadro alrededor
		getHelp.addActionListener(this); // Añadir ActionListener
		getHelp.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
					
		// ------------- Frame -------------------------------
		
		
		this.add(catPage);
		this.add(accPage);
		this.add(savesPage);
		this.add(statsPage);
		this.add(settPage);
		this.add(getHelp);
		this.add(addTrans);
		
		this.add(user);
		this.add(accounts);
		this.add(general);
		this.add(welcomeLabel);
		this.add(about);

		
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
	
	private void displayAbout() {
		
		JLabel title;
		JLabel help1;
		JLabel help2;
		JLabel help3;
		
		System.out.println("Ventana displaySupportAndContactHelp");
			
		// ------------------- Label ------------------------
		
		// Título
		title = new JLabel(); 
		title.setBounds(30,30,200,40); // Tamaño
		title.setText("Acerca de"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 20)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
				
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,100,550,30); // Tamaño
		help1.setText("Esta app es un proyecto de la materia 'Estructuras de datos' de UNAL sede Bogot�"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 14)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
				
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,130,500,30); // Tamaño
		help2.setText("Autores: Marcos Pinz�n Pardo, C�sar Arthuro L�mos Silva, Dylan Rivero"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 14)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help3 = new JLabel(); 
		help3.setBounds(30,160,500,30); // Tamaño
		help3.setText("              Esteves, Juli�n C�rdoba Jaramillo y Camilo Apraez Apraez."); // Texto
		help3.setFont(new Font("Nunito", Font.PLAIN, 14)); // Fuente
		help3.setForeground(Color.BLACK); // Color del texto
		help3.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebe / Acerca de"); // Título
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setLocationRelativeTo(null);
		this.setSize(600,300);
		this.setResizable(false); // No cambia de tamaño
		this.setLayout(null);
		this.setVisible(true);
		this.add(title);
		this.add(help1);
		this.add(help2);
		this.add(help3);
		this.getContentPane().setBackground(Color.WHITE); // Color de fondo
		
	}

	// Criterio al presionar el botón
	@Override
	public void actionPerformed(ActionEvent pressed) {
		
		if (pressed.getSource() == user) {
			System.out.println("Abriendo ajustes/user");
		}
		
		if (pressed.getSource() == accounts) {
			System.out.println("Abriendo ajustes/cuentas");
		}
		
		if (pressed.getSource() == general) {
			System.out.println("Abriendo ajustes/general");
		}
		
		if (pressed.getSource() == about) {
			System.out.println("Abriendo ajustes/acercaDe");
			Settings st = new Settings(ul);
			st.displayAbout();
		}
		
		//--------------------------------------------------------
		
		if (pressed.getSource() == catPage) {
			System.out.println("Abriendo Categories");
			Categories ct = new Categories(ul);
			ct.categories();
			this.dispose();
		}
				
		if (pressed.getSource() == accPage) {
			System.out.println("Abriendo Accounts");
			Accounts ac = new Accounts(ul);
			ac.accounts();
			this.dispose();
		}
				
		if (pressed.getSource() == savesPage) {
			System.out.println("Abriendo Savings");
			Savings sv = new Savings(ul);
			sv.savings();
			this.dispose();
		}
				
		if (pressed.getSource() == statsPage) {
			System.out.println("Abriendo Stats");
			Stats st = new Stats(ul);
			st.stats();
			this.dispose();
		}
				
		if (pressed.getSource() == settPage) {
			System.out.println("Abriendo Settings");
			Settings st = new Settings(ul);
			st.settings();
			this.dispose();
		}
		
		if (pressed.getSource() == addTrans) {
			System.out.println("Abriendo CreateTrans");
			NewTrans nt = new NewTrans(ul);
			nt.createTrans();
		}
		
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displaySettingsHelp();
		}
		
	}	

}
	