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

import avlTree.AvlTreeIterator;
import logic.Account;
import logic.Transaction;
import logic.UserList;
import seqDataStructures.DynamicArray;
import seqDataStructures.DynamicArrayIterator;
import seqDataStructures.LinkedList;
import seqDataStructures.LinkedListIterator;


public class ShowCategory extends JFrame{
	
	UserList ul;
	DynamicArray<Account> accounts;
	
	public ShowCategory(UserList ul){ 
		this.ul = ul; 
		accounts = ul.getUser().getAccounts();
	}
	
	public void showCat(String cat) {

		System.out.print("Ventana de categoria:" + cat);
		
		JTable table;
			
		AvlTreeIterator<Transaction> it = new AvlTreeIterator<Transaction>(ul.getUser().getTransactions().getRoot());
		
		setSize(650,550);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setVisible(true);
		this.setTitle("Freebe / Vista de transacciones de: " + cat); // Título
		ImageIcon logo = new ImageIcon("Freebee_Icon.png"); // Logo
		this.setIconImage(logo.getImage()); // Poner logo
		setResizable(true);
		setLocationRelativeTo(null);

		// -------------- Datos de la tabla -----------------------------

		// Columnas
		String[] pcolum = {"Fecha", "Memo", "Valor", "+/-", "Cuenta"};
		// Filas
		int a = pcolum.length;
		int b = 50; //t.size(); // Cambiar para variar la cantidad de productos que se muestran
		Object[][] pdata = new Object[b][a];
				
		int i=0;
		while(it.hasNext()){
			Transaction t = it.next();
			if(t.getCategory() == cat) {
			Account acc = accounts.get(i);			
			pdata[i][0] = t.getDate();
			pdata[i][1] = t.getDescription();
			pdata[i][2] = t.getAmount();
			pdata[i][3] = t.isIngreso();
			pdata[i][4] = acc.getName();
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