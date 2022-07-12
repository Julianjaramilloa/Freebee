package ui;


import java.awt.BorderLayout;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logic.Account;
import logic.ReaderWriter;
import logic.Transaction;
import logic.UserList;
import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;

public class Categories extends JFrame implements ActionListener {

	JButton catPage;
	JButton accPage;
	JButton savesPage;
	JButton statsPage;
	JButton settPage;
	JButton addTrans;
	JButton getHelp;
	JButton cat1;
		
	JButton[] catButs = new JButton[11];
	
	JLabel welcomeLabel;
	
	UserList ul;
	
	public Categories(UserList ul) {
		this.ul = ul; 
	}
	
	String[] categories = {"Vivienda", "Salud", "Compras", "Comidas", "ComidasFuera", "Transporte", "Arriendo", "Educacion", "Ocio", "Ingresos", "Trabajo"};
	
	private void displayCatButtons() {
		
		// Altura de los botones con relaci�n a cuantos hay (se puede mejorar la anchura)
		int h = 450/11;
		int p = 0;
		
		for (int i=0; i<11; i++) {
			catButs[i]= new JButton();
			if (i<5) {
				catButs[i].setBounds(90,(120 + (i*(h+10))),180,h); // Tama�o
			} else {
				catButs[i].setBounds(310,(120 + (p*(h+10))),180,h); // Tama�o
				p++;
			}
			
			catButs[i].setText(categories[i]); // Texto
			catButs[i].setBorder(new LineBorder(Color.BLACK)); // Borde
			catButs[i].setFont(new Font("Consolas", Font.BOLD, 16)); // Fuente
			catButs[i].setForeground(Color.BLACK); // Color del texto
			catButs[i].setBackground(Color.WHITE); // Color del fondo
			catButs[i].setFocusable(false); // Quitar cuadro alrededor
			catButs[i].addActionListener(this); // A�adir ActionListener
			catButs[i].setBorder(BorderFactory.createEtchedBorder()); // Borde
			this.add(catButs[i]);
		}
		
	}
	
	public void categories(){
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tamaño
		welcomeLabel.setText("Categor�as"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		displayCatButtons();
		
		// ================= BOTONES FIJOS =============================
		
		// ------------ Botón: Pagina categorías -------------------
		
		catPage = new JButton();
        catPage.setBounds(22,495,110,40); // Tamaño
        catPage.setText("Categor�as"); // Texto
        catPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        catPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        catPage.setForeground(Color.BLACK); // Color del texto
        catPage.setBackground(Color.LIGHT_GRAY); // Color del fondo
        catPage.setFocusable(false); // Quitar cuadro alrededor
        catPage.addActionListener(this); // Añadir ActionListener 
        catPage.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY)); // Borde
        catPage.setEnabled(false); // Desabilita el botón
     
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
        
        // ------------ Botón: Pagina estadÃ­sticas -------------------
		
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
        settPage.setBackground(Color.WHITE); // Color del fondo
        settPage.setFocusable(false); // Quitar cuadro alrededor
        settPage.addActionListener(this); // Añadir ActionListener
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
		
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
		this.add(welcomeLabel);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ReaderWriter rw = new ReaderWriter(ul);
				rw.saveChanges();
			}
		});

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
		
		for (JButton b : catButs) {
			if (pressed.getSource() == b){
				System.out.print(b.getLabel() + "\n");
				ShowCategory sc = new ShowCategory(ul);
				sc.showCat(b.getLabel());
				//tr.showTrans(accName, id);
			}
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
			hm.displayCategoriesHelp();
		}
		
		
	}	

}