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
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logic.Transaction;
import logic.User;
import logic.UserList;
import seqDataStructures.DynamicArray;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;
import seqDataStructures.Pila;

public class Savings extends JFrame implements ActionListener {

	JButton catPage;
	JButton accPage;
	JButton savesPage;
	JButton statsPage;
	JButton settPage;
	JButton addTrans;
	JButton getHelp;

	
	JLabel stat1;
	JLabel stat2;
	JLabel welcomeLabel;
	
	JButton tipButton;
	JLabel tipLabel1;
	JLabel tipLabel2;
	
	UserList ul;
	
	public Savings(UserList ul) {
		this.ul = ul;
	}
	
	
	LinkedList<String> citas = new LinkedList<String>();
	Pila<String> tipsToShow = new Pila<String>();
		
	
	private void changeTipLabel() {	
		String tip = printRandomTip();
		String p1, p2;
	    if (tip.length()%2 == 0){
	        p1 =tip.substring(0, tip.length()/2);
	        p2 = tip.substring(tip.length()/2);
	    } else {
	        p1 = tip.substring(0, tip.length()/2);
	        p2 = tip.substring(tip.length()/2+1);
	    }   
	    
	    tipLabel1.setText(p1);
	    tipLabel2.setText(p2);
	}
	
	
	public void savings(){
		
		readData();

		System.out.println("Ventana Savings");
		
		User us = ul.getUser();
		float totalBalance = us.getTotalBalance();
		float lastTenDaysBalance = 0;
		LocalDate today = LocalDate.now();
		LocalDate tenDaysBefore = today.minusDays(10);
		LinkedList<Transaction> allTransactions = us.transactionsInList();
		LinkedListIterator<Transaction> it = new LinkedListIterator<Transaction>(allTransactions);
		LinkedList<Transaction> inRangeTransactions = new LinkedList<Transaction>();
		
		
		while(it.hasNext()) {
			Transaction ts = it.next();
			if(ts.getDate().compareTo(tenDaysBefore) >= 0) {
				inRangeTransactions.pushBack(ts);
			}
		}
		
		LinkedListIterator<Transaction> inIt = new LinkedListIterator<Transaction>(inRangeTransactions);
		while(inIt.hasNext()) {
			Transaction ts = inIt.next();
			float tsBalance = ts.getAmount();
			boolean isIngreso = ts.getBoolean();
			if(isIngreso) {
				lastTenDaysBalance += tsBalance;	
			}else {
				lastTenDaysBalance -= tsBalance;
			}
			
		}
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // TamaÃ±o
		welcomeLabel.setText("Ahorro"); // Texto
		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// ------------ Label: Stat1 -------------------
		
		stat1 = new JLabel(); 
		stat1.setBounds(60,120,400,60); // Tama�o
		stat1.setText("Sus gastos en los �ltimos diez d�as suman: $" + lastTenDaysBalance); // Texto
		stat1.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		stat1.setForeground(Color.BLACK); // Color del texto
		stat1.setVisible(true); // Visibilidad
				
		// ------------ Label: Stat1 -------------------
				
		stat2 = new JLabel(); 
		stat2.setBounds(100,170,400,60); // Tama�o
		stat2.setText("Por otro lado, sus ingresos suman: $" + totalBalance); // Texto
		stat2.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		stat2.setForeground(Color.BLACK); // Color del texto
		stat2.setVisible(true); // Visibilidad
		
		// ------------ Labels de tip -------------------
		
		tipLabel1 = new JLabel(); 
		tipLabel1.setBounds(70,330,600,40); // TamaÃ±o
		tipLabel1.setText(""); // Texto
		tipLabel1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		tipLabel1.setForeground(Color.BLACK); // Color del texto
		tipLabel1.setVisible(true); // Visibilidad
		
		tipLabel2 = new JLabel(); 
		tipLabel2.setBounds(70,350,600,40); // TamaÃ±o
		tipLabel2.setText(""); // Texto
		tipLabel2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		tipLabel2.setForeground(Color.BLACK); // Color del texto
		tipLabel2.setVisible(true); // Visibilidad
		
		// ------------ Bot�n: Pagina categor�as -------------------
		
		tipButton = new JButton();
		tipButton.setBounds(300,280,180,30); // TamaÃ±o
		tipButton.setText("Generar tip de ahorro"); // Texto
		tipButton.setBorder(new LineBorder(Color.BLACK)); // Borde
		tipButton.setFont(new Font("Consolas", Font.ITALIC, 12)); // Fuente
		tipButton.setForeground(Color.BLACK); // Color del texto
		tipButton.setBackground(Color.LIGHT_GRAY); // Color del fondo
		tipButton.setFocusable(false); // Quitar cuadro alrededor
		tipButton.addActionListener(this); // AÃ±adir ActionListener 
		tipButton.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
		
		// ================= BOTONES FIJOS =============================
		
		// ------------ Bot�n: Pagina categor�as -------------------
		
		catPage = new JButton();
        catPage.setBounds(22,495,110,40); // TamaÃ±o
        catPage.setText("Categor�as"); // Texto
        catPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        catPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        catPage.setForeground(Color.BLACK); // Color del texto
        catPage.setBackground(Color.WHITE); // Color del fondo
        catPage.setFocusable(false); // Quitar cuadro alrededor
        catPage.addActionListener(this); // AÃ±adir ActionListener 
        catPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
     
        // ------------ Botón: Pagina cuentas -------------------
		
     	accPage = new JButton();
        accPage.setBounds(147,495,110,40); // TamaÃ±o
        accPage.setText("Cuentas"); // Texto
        accPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        accPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        accPage.setForeground(Color.BLACK); // Color del texto
        accPage.setBackground(Color.WHITE); // Color del fondo
        accPage.setFocusable(false); // Quitar cuadro alrededor
        accPage.addActionListener(this); // AÃ±adir ActionListener
        accPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ BotÃ³n: Pagina ahorro -------------------
		
     	savesPage = new JButton();
        savesPage.setBounds(272,495,110,40); // TamaÃ±o
        savesPage.setText("Ahorro"); // Texto
        savesPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        savesPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        savesPage.setForeground(Color.BLACK); // Color del texto
        savesPage.setBackground(Color.LIGHT_GRAY); // Color del fondo
        savesPage.setFocusable(false); // Quitar cuadro alrededor
        savesPage.addActionListener(this); // AÃ±adir ActionListener 
        savesPage.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY)); // Borde
        savesPage.setEnabled(false); // Desabilita el botÃ³n
        
        // ------------ BotÃ³n: Pagina estadÃ­sticas -------------------
		
     	statsPage = new JButton();
        statsPage.setBounds(397,495,110,40); // TamaÃ±o
        statsPage.setText("Resumen"); // Texto
        statsPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        statsPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        statsPage.setForeground(Color.BLACK); // Color del texto
        statsPage.setBackground(Color.WHITE); // Color del fondo
        statsPage.setFocusable(false); // Quitar cuadro alrededor
        statsPage.addActionListener(this); // AÃ±adir ActionListener
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ BotÃ³n: Pagina ajustes -------------------
		
     	settPage = new JButton();
        settPage.setBounds(522,495,40,40); // TamaÃ±o
        settPage.setText("="); // Texto
        settPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        settPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        settPage.setForeground(Color.BLACK); // Color del texto
        settPage.setBackground(Color.WHITE); // Color del fondo
        settPage.setFocusable(false); // Quitar cuadro alrededor
        settPage.addActionListener(this); // AÃ±adir ActionListener
        statsPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
		
		// ------------ BotÃ³n: Crear transacciÃ³n -------------------
	
		addTrans = new JButton();
		addTrans.setBounds(505,440,25,25); // TamaÃ±o
		addTrans.setText("+"); // Texto
		addTrans.setBorder(new LineBorder(Color.BLACK)); // Borde
		addTrans.setFont(new Font("Consolas", Font.BOLD, 14)); // Fuente
		addTrans.setForeground(Color.ORANGE); // Color del texto
		addTrans.setBackground(Color.WHITE); // Color del fondo
		addTrans.setFocusable(false); // Quitar cuadro alrededor
		addTrans.addActionListener(this); // AÃ±adir ActionListener
		addTrans.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		// ------------ BotÃ³n: Obtener ayuda -----------------------
		
		getHelp = new JButton();
		getHelp.setBounds(50,440,25,25); // TamaÃ±o
		getHelp.setText("?"); // Texto
		getHelp.setBorder(new LineBorder(Color.BLACK)); // Borde
		getHelp.setFont(new Font("Consolas", Font.ITALIC, 12)); // Fuente
		getHelp.setForeground(Color.BLACK); // Color del texto
		getHelp.setBackground(Color.WHITE); // Color del fondo
		getHelp.setFocusable(false); // Quitar cuadro alrededor
		getHelp.addActionListener(this); // AÃ±adir ActionListener
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
		this.add(welcomeLabel);
		this.add(tipLabel1);
		this.add(tipLabel2);
		this.add(tipButton);

		
		this.setTitle("Freebee"); // Título
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null); // Layout
		this.setSize(600,600); // Dimensiones
		this.setResizable(false); // No cambia de tamaÃ±o
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

			System.err.println("Error leyendo archivo tips.txt");
			e.printStackTrace();
		}
		
		fillPileWithRandomOrderTips();
	}
	
	private void tokenize(String line) {
		

		System.out.println("Tokenizando línea");
		Scanner sc = new Scanner(line);
		sc.useDelimiter(";");
		
		String cita = sc.next().trim();
		String autor = sc.next().trim();
		
		String tip = cita + " -" + autor;
		

		this.citas.pushBack(tip);
		
		sc.close();

	}
	

	private void fillPileWithRandomOrderTips() {
		Random rdm = new Random();
		int initialCitasSize = citas.size();
		for(int i=0; i< initialCitasSize; i++) {
			int choice = rdm.nextInt(citas.size());
			String insert = citas.get(choice);
			citas.remove(choice);
			tipsToShow.push(insert);
		}
	}
	
	private String printRandomTip() {
		if(tipsToShow.isEmpty()) {
			fillPileWithRandomOrderTips();
		}
		String tipToShow = this.tipsToShow.pop();
		citas.pushBack(tipToShow);
    
		System.out.println(tipToShow);
    return tipToShow;
	}
	
	// Criterio al presionar el botÃ³n
	@Override
	public void actionPerformed(ActionEvent pressed) {
		
		if (pressed.getSource() == tipButton) {
			System.out.println("Nuevo tip");
			changeTipLabel();
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
			printRandomTip();
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displaySavingsHelp();
		}

	}
	

}