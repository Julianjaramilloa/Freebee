package ui;

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
	
	private void displaySupportAndContactHelp() {
		
		System.out.println("Ventana displaySupportAndContactHelp");
			
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
		help2.setText("Si a�n no has creado tu usuario u olvidaste la contrase�a, crea un usuario nuevo"); // Texto
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
	
	public void displaySettingsHelp() {
		
		System.out.println("Ventana displaySettingsHelp");
		
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
		title.setText("Ayuda - Ajustes"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("Selecciona alguna de las cuatro categor�as para hacer ajustes sobre tu usuario,"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("tus cuentas, la app o para conocer los datos de los creadores de la app"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en ajustes"); // T�tulo
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
	
	public void displayCategoriesHelp() {
		
		System.out.println("Ventana displayCategoriesHelp");
		
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
		title.setText("Ayuda - Categorias"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("Selecciona la categor�a que deseas mirar"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("Al seleccionarla, ver�s todas las trasancciones asociadas"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en categor�as"); // T�tulo
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
	
	public void displayAccountsHelp() {
		
		System.out.println("Ventana displayAccountsHelp");
		
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
		title.setText("Ayuda - Cuentas"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("Selecciona la cuenta que deseas revisar"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("Dentro encontrar�s todas las tranascciones asociadas"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en cuentas"); // T�tulo
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

	public void displaySavingsHelp() {
		
		System.out.println("Ventana displaySavesHelp");
		
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
		title.setText("Ayuda - Ahorro"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("En la parte de arriba ver�s estad�sticas de ingresos y egresos"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("Presiona el bot�n para obtener tips de ahorro ;)"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en categor�as"); // T�tulo
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
	
	public void displayStatsHelp() {
		
		System.out.println("Ventana displayStatsHelp");
		
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
		title.setText("Ayuda - Estad�sticas"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("En esta ventana puedes conocer algunas estad�sticas sobre tu"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("cuenta, como el promedio de ingresos y egresos"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en categor�as"); // T�tulo
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
	
	public void displayNewTransHelp() {
		
		System.out.println("Ventana displayNewTransHelp");
		
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
		title.setText("Ayuda - Crear transacci�n"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("Para crear una transacci�n, por favor llena y selecciona todos los campos"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("Si quieres crear una transacci�n a furuo, s�lo asigna la fecha"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en categor�as"); // T�tulo
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
	
	public void displayNewAccHelp() {
		
		System.out.println("Ventana displayNewAccHelp");
		
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
		title.setText("Ayuda - Crear nueva cuenta"); // Texto
		title.setFont(new Font("Nunito", Font.BOLD, 18)); // Fuente
		title.setForeground(Color.BLACK); // Color del texto
		title.setVisible(true); // Visibilidad
		
		// Ayuda 1
		help1 = new JLabel(); 
		help1.setBounds(30,120,550,60); // Tama�o
		help1.setText("Para crear una cuenta llena todos los campos, debes ponerle"); // Texto
		help1.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help1.setForeground(Color.BLACK); // Color del texto
		help1.setVisible(true); // Visibilidad
		
		// Ayuda 2
		help2 = new JLabel(); 
		help2.setBounds(30,150,500,30); // Tama�o
		help2.setText("un nombre y tipo de divisa, puedes dejar el balance en 0"); // Texto
		help2.setFont(new Font("Nunito", Font.PLAIN, 12)); // Fuente
		help2.setForeground(Color.BLACK); // Color del texto
		help2.setVisible(true); // Visibilidad
		
		// ----------------- Frame ------------------------
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setTitle("Freebee / Ayuda en categor�as"); // T�tulo
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == support) {
			System.out.println("Entrando a soporte general");
			this.dispose();
			HelpMenu hm = new HelpMenu();
			hm.displaySupportAndContactHelp();
		}	
	}
	
}	