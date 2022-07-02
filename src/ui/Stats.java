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
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import avlTree.AVLTree;
import logic.Transaction;
import logic.User;
import logic.UserList;
import priorityQueue.MinHeap;
import seqDataStructures.DynamicArray;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;

public class Stats extends JFrame implements ActionListener {

	JButton catPage;
	JButton accPage;
	JButton savesPage;
	JButton statsPage;
	JButton settPage;
	JButton addTrans;
	JButton getHelp;

	JLabel welcomeLabel;	
	JLabel stat1;
	JLabel stat2;
	JLabel stat3;
	
	UserList ul;
	
	public Stats(UserList ul) {
		this.ul = ul;
	}
	
	
	public void stats(){
		
		System.out.println("Ventana Stats");
		
		User us = ul.getUser();
		float lastMonthBalance = 0;
		float previous = 0;
		LocalDate today = LocalDate.now();
		LinkedList<Transaction> thisMonth = new LinkedList<Transaction>();
		LinkedListIterator<Transaction> it = new LinkedListIterator<Transaction>(us.transactionsInList());
		
		while(it.hasNext()) {
			Transaction ts = it.next();
			LocalDate date = ts.getDate();
			float amount = ts.getAmount();
			boolean isIngreso = ts.getBoolean();
			if(isIngreso) {
				amount += ts.getAmount();
			}else {
				amount -= ts.getAmount();
			}
			
			if(date.getMonth().equals(today.getMonth())) {
				lastMonthBalance += amount;
			}else {
				previous += amount;
			}
		}
		
		float percentageMonth = (previous * 100)/lastMonthBalance;
		if(lastMonthBalance == 0) {
			percentageMonth = 0;
		}
		
		float gastoTotal = 0;
		float ingresosTotal = 0;
		
		LinkedListIterator<Transaction> it2 = new LinkedListIterator<Transaction>(us.transactionsInList());
		while(it2.hasNext()) {
			Transaction ts = it2.next();
			boolean isIngreso = ts.getBoolean();
			if(isIngreso) {
				ingresosTotal += ts.getAmount();
			}else {
				gastoTotal += ts.getAmount();
			}
		}
		
		
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // Tamaño
		welcomeLabel.setText("Estad�sticas"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// ------------ Label: Stat1 -------------------
		
		stat1 = new JLabel(); 
		stat1.setBounds(90,160,400,60); // Tamaño
		stat1.setText("Su capital ha crecido un " + percentageMonth + "% " + "en el �ltimo mes."); // Texto
		stat1.setFont(new Font("Nunito", Font.ITALIC, 16)); // Fuente
		stat1.setForeground(Color.BLACK); // Color del texto
		stat1.setVisible(true); // Visibilidad
		
		// ------------ Label: Stat1 -------------------
		
		stat2 = new JLabel(); 
		stat2.setBounds(100,225,400,60); // Tamaño
		stat2.setText("El total de dinero que ha gastado es: $" + gastoTotal); // Texto
		stat2.setFont(new Font("Nunito", Font.ITALIC, 16)); // Fuente
		stat2.setForeground(Color.BLACK); // Color del texto
		stat2.setVisible(true); // Visibilidad
				
		// ------------ Label: Stat1 -------------------
				
		stat3 = new JLabel(); 
		stat3.setBounds(100,325,400,60); // Tamaño
		stat3.setText("El total de dinero que ha ingresado es $" + ingresosTotal); // Texto
		stat3.setFont(new Font("Nunito", Font.ITALIC, 16)); // Fuente
		stat3.setForeground(Color.BLACK); // Color del texto
		stat3.setVisible(true); // Visibilidad
		
		// ================= BOTONES FIJOS =============================
		
		// ------------ Bot�n: Pagina categor�as -------------------
		
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
     
        // ------------ Bot�n: Pagina cuentas -------------------
		
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
        
        // ------------ Bot�n: Pagina ahorro -------------------
		
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
        
        // ------------ Bot�n: Pagina estadísticas -------------------
		
     	statsPage = new JButton();
        statsPage.setBounds(397,495,110,40); // Tamaño
        statsPage.setText("Resumen"); // Texto
        statsPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        statsPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        statsPage.setForeground(Color.BLACK); // Color del texto
        statsPage.setBackground(Color.LIGHT_GRAY); // Color del fondo
        statsPage.setFocusable(false); // Quitar cuadro alrededor
        statsPage.addActionListener(this); // Añadir ActionListener 
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY)); // Borde
        statsPage.setEnabled(false); // Desabilita el botón
        
        // ------------ Bot�n: Pagina ajustes -------------------
		
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
		
		// ------------ Bot�n: Crear transacción -------------------
	
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
		
		// ------------ Bot�n: Obtener ayuda -----------------------
		
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
		
		this.add(stat1);
		this.add(stat2);
		this.add(stat3);
		
		this.add(welcomeLabel);


		
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
			hm.displayStatsHelp();
		}
		
		
	}	

}