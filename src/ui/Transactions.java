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


public class Transactions extends JFrame{

	int option;
	
	public void showTrans(String acc) {

		JTable table;
			
		// Llenar el array a partir del arbol
		//ArrayList<Transaccion> t = null;
			
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
		
		for(int i = 0 ; i < b; i++){
			// Cambiar los gets
			
			pdata[i][0] = "dd/mm/aaa";
			pdata[i][1] = "cuenta";
			pdata[i][2] = "test";
			pdata[i][3] = "categoría";
			pdata[i][4] = "00000";
			pdata[i][5] = "-";
			
//			pdata[i][0] = t.get(i).getDate
//			pdata[i][1] = t.get(i).getAcc
//			pdata[i][2] = t.get(i).getDesc
//			pdata[i][3] = t.get(i).getCat
//			pdata[i][4] = t.get(i).getValue
//			pdata[i][5] = t.get(i).getIsIngreso
			
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