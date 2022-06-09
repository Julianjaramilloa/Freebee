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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;


public class NewTrans extends JFrame implements ActionListener {

	JButton saveTrans;
	JButton getHelp;

	JRadioButton income = new JRadioButton();
	JRadioButton outcome = new JRadioButton();
	ButtonGroup grp = new ButtonGroup();

	
	JLabel welcomeLabel;
	JLabel descLabel;
	JLabel valueLabel;
	JLabel warningLabel;
	JLabel dateLabel;
	
	JTextField descField;
	JTextField valueField;
	JTextField dateField;
	
	String desc;
	String selectedCat;
	String selectedAcc;
	Float value;
	Boolean isIncome = false;
	LocalDate date;

	String[] catList = {"Vivienda","Salud","Compras","Comidas","ComidasFuera","Transporte","Arriendo","Educacion","Ocio","Ingresos","Trabajo"};
	JComboBox catSelect = new JComboBox(catList);
	
//	String[] accList = new String[cantidadDeCuentas]
//	// Llenar con las cuentas del usuario
//	for(i = 0; i < cantidadDeCuentas < i++) {
//		// Iterar a través del arbol y agregar las cuentas
//		accList[i] = getAccount;
//	}
	
	String[] accList = {"T1","T2","T3"};
	
	JComboBox accSelect = new JComboBox(accList);

	
	
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

		descLabel.setBounds(130,145,300,70); // Tamaño
		descLabel.setText("Descripción (memo):"); // Texto
		descLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		descLabel.setForeground(Color.BLACK); // Color del texto
		descLabel.setVisible(true); // Visibilidad
		
		valueLabel = new JLabel(); 
		valueLabel.setBounds(130,235,300,70); // Tamaño
		valueLabel.setText("Cantidad:"); // Texto
		valueLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		valueLabel.setForeground(Color.BLACK); // Color del texto
		valueLabel.setVisible(true); // Visibilidad
		dateLabel = new JLabel(); 
		dateLabel.setBounds(160,95,300,70); // Tamaño
		dateLabel.setText("Fecha: (Año-Mes-Día)"); // Texto
		dateLabel.setFont(new Font("Nunito", Font.BOLD, 16)); // Fuente
		dateLabel.setForeground(Color.BLACK); // Color del texto
		dateLabel.setVisible(true); // Visibilidad
		

		warningLabel = new JLabel(); 
		warningLabel.setBounds(165,480,280,60); // Tamaño
		warningLabel.setText("No use el caracter ';' para evitar fallos en la aplicación"); // Texto
		warningLabel.setFont(new Font("Nunito", Font.ITALIC, 10)); // Fuente
		warningLabel.setForeground(Color.BLACK); // Color del texto
		warningLabel.setVisible(true); // Visibilidad
		
		// ------------ Botón: Crear nuevo ususario -----------------------
		
		saveTrans = new JButton();
		saveTrans.setBounds(255,410,70,25); // Tamaño
		saveTrans.setText("GUARDAR"); // Texto

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

		descField.setText(" "); // Texto por defecto
		descField.setBounds(125, 200, 350, 40); // Tamaño
		descField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		descField.setForeground(Color.BLACK);  // Color del texto
		descField.setBackground(Color.WHITE); // Color del fondo
		descField.setCaretColor(Color.DARK_GRAY); // Color del caret

		// Password
		valueField = new JTextField(); 
		valueField.setVisible(true);

		valueField.setText("0"); // Texto por defecto
		valueField.setBounds(220, 250, 100, 40); // Tamaño

		valueField.setFont(new Font("Consolas", Font.PLAIN, 16)); // Fuente
		valueField.setForeground(Color.BLACK);  // Color del texto
		valueField.setBackground(Color.WHITE); // Color del fondo
		valueField.setCaretColor(Color.DARK_GRAY); // Color del caret
		

		// Password 
		LocalDate nowDate = LocalDate.now();//For reference
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String now = nowDate.format(format);
	    
		dateField = new JTextField(); 
		dateField.setVisible(true);
		dateField.setText(now); // Texto por defecto
		dateField.setBounds(340, 115, 90, 35); // Tamaño
		dateField.setFont(new Font("Consolas", Font.PLAIN, 14)); // Fuente
		dateField.setForeground(Color.BLACK);  // Color del texto
		dateField.setBackground(Color.WHITE); // Color del fondo
		dateField.setCaretColor(Color.DARK_GRAY); // Color del caret
		
		
		// ------------- ComboBox: Selección de categoría ------
		
		catSelect.setVisible(true);
		catSelect.setSelectedItem(0);
		catSelect.addActionListener(this);
		catSelect.setBounds(180, 320, 100, 30); // Tamaño
		catSelect.setFont(new Font("Consolas", Font.PLAIN, 14)); // Fuente
		catSelect.setForeground(Color.BLACK);  // Color del texto
		catSelect.setBackground(Color.WHITE); // Color del fondo
		catSelect.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		catSelect.setFocusable(false); // No hace enfasis en el seleccioando
		
		// ------------- ComboBox: Selección de categoría ------
		
		accSelect.setVisible(true);
		accSelect.setSelectedItem(0);
		accSelect.addActionListener(this);
		accSelect.setBounds(320, 320, 100, 30); // Tamaño
		accSelect.setFont(new Font("Consolas", Font.PLAIN, 14)); // Fuente
		accSelect.setForeground(Color.BLACK);  // Color del texto
		accSelect.setBackground(Color.WHITE); // Color del fondo
		accSelect.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
		accSelect.setFocusable(false); // No hace enfasis en el seleccioando
		
		// --------------- CheckBox income y outcome -------------
		
		income.setText("+");
		income.setFont(new Font("Consolas", Font.BOLD, 30)); // Fuente
		income.setForeground(Color.GREEN);  // Color del texto
		income.setBackground(Color.WHITE); // Color del fondo
		income.setBounds(350, 250, 50, 50);
		income.addActionListener(this);
		
		outcome.setText("-");
		outcome.setFont(new Font("Consolas", Font.BOLD, 30)); // Fuente
		outcome.setForeground(Color.RED);  // Color del texto
		outcome.setBackground(Color.WHITE); // Color del fondo
		outcome.setBounds(400, 250, 50, 50);
		outcome.addActionListener(this);
		outcome.setSelected(true);
		
		grp.add(income);
		grp.add(outcome);

					

		// ------------- Frame -------------------------------
		
		this.add(saveTrans);
		this.add(getHelp);
		this.add(welcomeLabel);
		this.add(descLabel);
		this.add(valueLabel);
		this.add(warningLabel);
		this.add(descField);
		this.add(valueField);

		this.add(catSelect);
		this.add(accSelect);
		this.add(income);
		this.add(outcome);
		this.add(dateField);
		this.add(dateLabel);

		
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
		

		if (pressed.getSource() == catSelect) {
			JComboBox cb = (JComboBox)pressed.getSource();
			selectedCat = (String)cb.getSelectedItem();
			System.out.println("Categoría seleccionada: " + selectedCat);
		}
		
		if (pressed.getSource() == income) {
			System.out.println("Es un ingreso");
			isIncome = true;
		}
		
		if (pressed.getSource() == outcome) {
			System.out.println("Es un egreso");
			isIncome = false;
		}
		

		if (pressed.getSource() == accSelect) {
			JComboBox cb = (JComboBox)pressed.getSource();
			selectedAcc = (String)cb.getSelectedItem();
			System.out.println("Cuenta seleccionada: " + selectedAcc);
		}
		
		if (pressed.getSource() == saveTrans) {
			
			if (selectedCat == null || selectedAcc == null) {
				JOptionPane.showMessageDialog(null, "Seleccione categoría y valor", "Datos faltantes", JOptionPane.WARNING_MESSAGE);
			} else {
				desc = descField.getText();
				value = Float.parseFloat(valueField.getText());
				date = LocalDate.parse(dateField.getText());
				if (value == 0) {
					JOptionPane.showMessageDialog(null, "Ingrese un valor", "Datos faltantes", JOptionPane.WARNING_MESSAGE);
				} else {
						System.out.println("Nueva transacción: " + "Fecha: " + date + " Cuenta: " + selectedAcc + " Memo: '" + 
								desc + "' Categoría: " + selectedCat + " Valor: " + value + " isIngreso: " + isIncome);
						
						//Añadir transacción(date,selectedAcc,desc,selectedCat,value,isIncome);
						
						this.dispose();
						
					}	
				}
			}
		

		if (pressed.getSource() == getHelp) {
			System.out.println("Abriendo ayuda");
			HelpMenu hm = new HelpMenu();
			hm.displayNewTransHelp();
		}
		
	}	
}
