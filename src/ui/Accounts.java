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
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import logic.Account;
import logic.UserList;
import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;

public class Accounts extends JFrame implements ActionListener {

	JButton catPage;
	JButton accPage;
	JButton savesPage;
	JButton statsPage;
	JButton settPage;
	JButton addTrans;
	JButton getHelp;
	
	JButton newAcc;
	JButton[] accButs = new JButton[5];
	
	JLabel info;
	JLabel balance;

	JLabel welcomeLabel;
	
	UserList ul;
	DynamicArray<Account> accounts;
	
	public Accounts(UserList ul) {
		this.ul = ul;
		accounts = ul.getUser().getAccounts();
	}
	
	public void accounts(){
		
		System.out.println("Ventana Accounts");
		
		// ------------ Label: Bienvenida -------------------
		
		welcomeLabel = new JLabel(); 
		welcomeLabel.setBounds(50,20,400,60); // TamaÃ±o

		welcomeLabel.setText("Mis cuentas"); // Texto

		welcomeLabel.setFont(new Font("Nunito", Font.BOLD, 24)); // Fuente
		welcomeLabel.setForeground(Color.BLACK); // Color del texto
		welcomeLabel.setVisible(true); // Visibilidad
		
		// ------------ Label: Bienvenida -------------------
		
		info = new JLabel(); 
		info.setBounds(330,20,150,60); // Tamaño
		info.setText("Total disponible: "); // Texto
		info.setFont(new Font("Nunito", Font.PLAIN, 14)); // Fuente
		info.setForeground(Color.BLACK); // Color del texto
		info.setVisible(true); // Visibilidad
				
		// ------------ Label: Bienvenida -------------------
				
		balance = new JLabel(); 
		balance.setBounds(440,20,200,60); // Tamaï¿½o
		balance.setText(String.valueOf(ul.getUser().getTotalBalance())); // Texto
		balance.setFont(new Font("Nunito", Font.BOLD, 15)); // Fuente
		balance.setForeground(Color.BLACK); // Color del texto
		balance.setVisible(true); // Visibilidad
		
		// Cantidad de cuentas del usuario (mï¿½x 5 por ahora)
		int accAmount = ul.getUser().getAccountsSize();
		if (accAmount == 0) {
			JOptionPane.showMessageDialog(null, "Aún no tiene cuentas, cree una", "Cuidado", JOptionPane.WARNING_MESSAGE);
		}
		displayAccButtons(accAmount);
		
		// ------------ Botï¿½n: Nuevo usuario -----------------------
		
		newAcc = new JButton();
		newAcc.setBounds(240,440,95,30); // Tamaï¿½o
		newAcc.setText("Crear cuenta"); // Texto
		newAcc.setBorder(new LineBorder(Color.BLACK)); // Borde
		newAcc.setFont(new Font("Consolas", Font.PLAIN, 12)); // Fuente
		newAcc.setForeground(Color.BLACK); // Color del texto
		newAcc.setBackground(Color.WHITE); // Color del fondo
		newAcc.setFocusable(false); // Quitar cuadro alrededor
		newAcc.addActionListener(this); // Aï¿½adir ActionListener
		newAcc.setBorder(BorderFactory.createEtchedBorder()); // Borde
		
		
		// ================= BOTONES FIJOS =============================
		
		// ------------ Botón: Pagina categorÃ­as -------------------
		
		catPage = new JButton();
        catPage.setBounds(22,495,110,40); // TamaÃ±o
        catPage.setText("Categorías"); // Texto
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
        accPage.setBackground(Color.LIGHT_GRAY); // Color del fondo
        accPage.setFocusable(false); // Quitar cuadro alrededor
        accPage.addActionListener(this); // AÃ±adir ActionListener
        accPage.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.GRAY)); // Borde
        accPage.setEnabled(false); // Desabilita el botón
        
        // ------------ Botón: Pagina ahorro -------------------
		
     	savesPage = new JButton();
        savesPage.setBounds(272,495,110,40); // TamaÃ±o
        savesPage.setText("Ahorro"); // Texto
        savesPage.setBorder(new LineBorder(Color.BLACK)); // Borde
        savesPage.setFont(new Font("Consolas", Font.ITALIC, 15)); // Fuente
        savesPage.setForeground(Color.BLACK); // Color del texto
        savesPage.setBackground(Color.WHITE); // Color del fondo
        savesPage.setFocusable(false); // Quitar cuadro alrededor
        savesPage.addActionListener(this); // AÃ±adir ActionListener
        savesPage.setBorder(BorderFactory.createEtchedBorder(Color.GRAY, Color.LIGHT_GRAY)); // Borde
        
        // ------------ Botón: Pagina estadÃ­sticas -------------------
		
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
        
        // ------------ Botón: Pagina ajustes -------------------
		
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
		
		// ------------ Botón: Crear transacción -------------------
	
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
		
		// ------------ Botón: Obtener ayuda -----------------------
		
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
		
		this.add(welcomeLabel);
		this.add(info);
		this.add(balance);
		this.add(newAcc);


		
		this.setTitle("Freebee"); // TÃ­tulo
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
	

	private void displayAccButtons(int c) {
			
		if (c == 0) {
			return;
		}
		
		// Altura de los botones con relaciï¿½n a cuantos hay (se puede mejorar la anchura)
		int h = 250/c;
		
		for (int i=0; i<c; i++) {
			accButs[i]= new JButton();
			accButs[i].setBounds(160,(110 + (i*(h+10))),250,h); // Tamaï¿½o
			Account acc = accounts.get(i);			
			accButs[i].setText(acc.getName() +  " $" + acc.getBalance()); // Texto
			accButs[i].setBorder(new LineBorder(Color.BLACK)); // Borde
			accButs[i].setFont(new Font("Consolas", Font.BOLD, 16)); // Fuente
			accButs[i].setForeground(Color.BLACK); // Color del texto
			accButs[i].setBackground(Color.WHITE); // Color del fondo
			accButs[i].setFocusable(false); // Quitar cuadro alrededor
			accButs[i].addActionListener(this); // Aï¿½adir ActionListener
			accButs[i].setBorder(BorderFactory.createEtchedBorder()); // Borde
			this.add(accButs[i]);
		}
		
	}

	// Criterio al presionar el botï¿½n

	@Override
	public void actionPerformed(ActionEvent pressed) {
		
		for (JButton b : accButs) {
			if (pressed.getSource() == b){
				System.out.print(b.getLabel() + "\n");
				Transactions tr = new Transactions(this.ul);
				String accName = b.getLabel().replaceFirst("\\s*(\\w+).*", "$1");
				DynamicArrayIterator<Account> it = new DynamicArrayIterator<Account>(this.accounts);
				int id = 0;
				while(it.hasNext()) {
					Account aux = it.next();
					String auxString = aux.getName();
					if(auxString.equals(accName)) {
						id = aux.getId();
					}
				}
				tr.showTrans(accName, id);
			}
		}
			
		if (pressed.getSource() == newAcc) {
			System.out.println("Abriendo creaciï¿½n de nuevo cuenta");
			NewAcc na = new NewAcc(ul); 
			na.createAcc();
		}
		
	
		//--------------------------------------------------------
		
		if (pressed.getSource() == catPage) {
			System.out.println("Ventana Categories");
			Categories ct = new Categories(ul);
			ct.categories();
			this.dispose();
		}
				
		if (pressed.getSource() == accPage) {
			System.out.println("Ventana Accounts");
			Accounts ac = new Accounts(ul);
			ac.accounts();
			this.dispose();
		}
				
		if (pressed.getSource() == savesPage) {
			System.out.println("Ventana Savings");
			Savings sv = new Savings(ul);
			sv.savings();
			this.dispose();
		}
				
		if (pressed.getSource() == statsPage) {
			System.out.println("Ventana Stats");
			Stats st = new Stats(ul);
			st.stats();
			this.dispose();
		}
				
		if (pressed.getSource() == settPage) {
			System.out.println("Ventana Settings");
			Settings st = new Settings(ul);
			st.settings();
			this.dispose();
		}
				
		if (pressed.getSource() == addTrans) {
			System.out.println("Abriendo CreateTrans");
			NewTrans nt = new NewTrans(ul);
			nt.createTrans();
			this.dispose();
		}
				
		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displayAccountsHelp();
		}
		
		
	}	

}