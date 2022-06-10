package ui;

/*
 * Freebie
 * @author Marcos Pinzón Pardo
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logic.Transaction;
import logic.UserList;
import seqDataStructures.DynamicArray;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;


public class Transactions extends JFrame{

	int option;
	
	UserList ul;
	
	public Transactions(UserList ul) {
		this.ul = ul;
	}
	
	public void showTrans(String acc, int id) {

		JTable table;
			
		
		LinkedList<Transaction> transactions = ul.getUser().transactionsInList();
		LinkedListIterator <Transaction> it = new LinkedListIterator<Transaction>(transactions);
		
			
		setSize(650,550);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		this.setTitle("Freebe / Vista de transacciones de " + acc); // Título
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		setResizable(true);
		setLocationRelativeTo(null);
			
		// -------------- Datos de la tabla -----------------------------
					
		// Columnas
		String[] pcolum = {"Fecha", "Cuenta", "Memo", "Categoría", "Valor", "+/-"};
		// Filas
		int a = pcolum.length;
		int b = 50; //t.size(); // Cambiar para variar la cantidad de productos que se muestran
		Object[][] pdata = new Object[b][a];
		
		int i=0;
		while(it.hasNext()){
			
			Transaction t = it.next();
			if(t.getAccountId() == id) {
				pdata[i][0] = t.getDate();
				pdata[i][1] = t.getAccountId();
				pdata[i][2] = t.getDescription();
				pdata[i][3] = t.getCategory();
				pdata[i][4] = t.getAmount();
				pdata[i][5] = t.isIngreso();
				i++;	
			}
			
		}
			
		// --------------------- JTable -------------------------------------
			
		DefaultTableModel tablemodel = new DefaultTableModel(pdata,pcolum) {
			@Override
			public boolean isCellEditable(int filas, int columnas) {
				return false;
			}
		};
		table = new JTable(tablemodel);		
		add(new JScrollPane(table), BorderLayout.CENTER);
			
	}


}