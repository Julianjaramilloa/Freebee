package rbTree;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackTree testTree = new RedBlackTree();
		LocalDate date1 = LocalDate.parse("2020-06-22");
		LocalDate date2 = LocalDate.parse("2020-06-23");
		LocalDate date3 = LocalDate.parse("2020-06-24");
		LocalDate date4 = LocalDate.parse("2020-06-25");
		LocalDate date5 = LocalDate.parse("2020-06-26");
		testTree.insertNode(date1);
		testTree.insertNode(date2);
		testTree.insertNode(date3);
		testTree.insertNode(date4);
		testTree.insertNode(date5);
		
		System.out.println(testTree.toString());
		
	}

}
