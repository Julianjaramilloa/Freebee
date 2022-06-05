package userInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpMenu extends JFrame implements ActionListener {

	JLabel title;
	JLabel help1;
	JLabel help2;
	JButton support;
	
	public void displayLogInHelp(){
		
		System.out.println("Ventana displayLogInHelp");
		
		// ----------------- Bot�n: Ayuda y soporte -----------
		support = new JButton();
		support.setBounds(330,40,125,25); // Tama�o
		support.setText("Soporte y contacto"); // Texto
		support.setFont(new Font("Liberation Mono", Font.ITALIC, 11)); // Fuente
		support.setForeground(Color.WHITE); // Color del texto
		support.setBackground(Color.BLACK); // Color del fondo
		support.setFocusable(false); // Quitar cuadro alrededor
		support.addActionListener(this); // A�adir ActionListener
		
		// ------------------- Label ------------------------
		
		// T�tulo
		title = new JLabel(); 
		title.setBounds(30,30,250,40); // Tama�o
		title.setText("Ayuda - Log In"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("En esta ventana debes ingresar tu nombre de usuario y contrase�a"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("Si a�n no has creado tu usuario u olvidaste la contrase�a, por favor crea un usuario nuevo"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda al iniciar sesi�n"); // T�tulo
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setLocationRelativeTo(null);
		this.setSize(500,300);
		this.setResizable(false); // No cambia de tama�o
		this.setLayout(null);
		this.setVisible(true);
		this.add(title);
		this.add(help1);
		this.add(help2);
		this.add(support);
		this.getContentPane().setBackground(Color.WHITE); // Color de fondo
		
	}

	public void displayNewUserHelp(){
		
		System.out.println("Ventana displayNewUserHelp");
		
		// ----------------- Bot�n: Ayuda y soporte -----------
		support = new JButton();
		support.setBounds(330,40,125,25); // Tama�o
		support.setText("Soporte y contacto"); // Texto
		support.setFont(new Font("Liberation Mono", Font.ITALIC, 11)); // Fuente
		support.setForeground(Color.WHITE); // Color del texto
		support.setBackground(Color.BLACK); // Color del fondo
		support.setFocusable(false); // Quitar cuadro alrededor
		support.addActionListener(this); // A�adir ActionListener
		
		// ------------------- Label ------------------------
		
		// T�tulo
		title = new JLabel(); 
		title.setBounds(30,30,250,40); // Tama�o
		title.setText("Ayuda - Nuevo Usuario"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("En esta ventana debes ingresar el nombre de usuario que deseas"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("Adem�s, debes ingresar tu contrase�a dos veces �recuerdala!"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda al crear usuario"); // T�tulo
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setLocationRelativeTo(null);
		this.setSize(500,300);
		this.setResizable(false); // No cambia de tama�o
		this.setLayout(null);
		this.setVisible(true);
		this.add(title);
		this.add(help1);
		this.add(help2);
		this.add(support);
		this.getContentPane().setBackground(Color.WHITE); // Color de fondo
		
	}
	
	private void displaySupportAndContact() {
		
		System.out.println("Ventana displaySupportAndContact");
			
		// ------------------- Label ------------------------
		
		// T�tulo
		title = new JLabel(); 
		title.setBounds(30,30,200,40); // Tama�o
		title.setText("SOPORTE"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 20)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,30); // Tama�o
		help1.setText("Si tienes alg�n problema con la app, reportalo o pide ayuda en:"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 14)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("contacto@freebee.com   o al   +57 3145009475"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 14)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebe / Soporte y contacto"); // T�tulo
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		this.setLocationRelativeTo(null);
		this.setSize(500,300);
		this.setResizable(false); // No cambia de tama�o
		this.setLayout(null);
		this.setVisible(true);
		this.add(title);
		this.add(help1);
		this.add(help2);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == support) {
			System.out.println("Entrando a soporte general");
			this.dispose();
			HelpMenu hm = new HelpMenu();
			hm.displaySupportAndContact();
		}	
	}
	
}

	