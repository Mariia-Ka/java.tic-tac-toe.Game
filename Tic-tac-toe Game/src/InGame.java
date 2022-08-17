import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.List;

public class InGame {
	private static Hashtable<String, ArrayList<Integer>> graph;
	private static Hashtable<String, JButton> listOfButton;
	private static String lastMove; // ����� ��� �����: "1"
	private static List<String> processed;
	
	public static void graphOfComputer () { 
		graph = new Hashtable<>(); // ���� ��� ������
		System.out.println("�������� �����");

		ArrayList<Integer> b1 = new ArrayList<>();
		b1.add(2);
		b1.add(5);
		b1.add(4);
		graph.put("b1", b1);
		
		ArrayList<Integer> b2 = new ArrayList<>();
		b2.add(1);
		b2.add(3);
		b2.add(5);
		graph.put("b2", b2);
		
		ArrayList<Integer> b3 = new ArrayList<>();
		b3.add(2);
		b3.add(5);
		b3.add(6);
		graph.put("b3", b3);
		
		ArrayList<Integer> b4 = new ArrayList<>();
		b4.add(1);
		b4.add(5);
		b4.add(7);
		graph.put("b4", b4);
		
		ArrayList<Integer> b5 = new ArrayList<>();
		b5.add(1);
		b5.add(2);
		b5.add(3);
		b5.add(4);
		b5.add(6);
		b5.add(7);
		b5.add(8);
		b5.add(9);
		graph.put("b5", b5);
		
		ArrayList<Integer> b6 = new ArrayList<>();
		b6.add(3);
		b6.add(5);
		b6.add(9);
		graph.put("b6", b6);
		
		ArrayList<Integer> b7 = new ArrayList<>();
		b7.add(4);
		b7.add(5);
		b7.add(8);
		graph.put("b7", b7);
		
		ArrayList<Integer> b8 = new ArrayList<>();
		b8.add(5);
		b8.add(7);
		b8.add(9);
		graph.put("b8", b8);
		
		ArrayList<Integer> b9 = new ArrayList<>();
		b9.add(5);
		b9.add(6);
		b9.add(8);
		graph.put("b9", b9);
		
		System.out.println("���� ������");
		System.out.println(graph.values().toString());
		System.out.println(graph.keySet());

		
		listOfButton = new Hashtable<>(); // ������ ���� ������
		listOfButton.put("b1", MainFrame.but1);
		listOfButton.put("b2", MainFrame.but2);
		listOfButton.put("b3", MainFrame.but3);
		listOfButton.put("b4", MainFrame.but4);
		listOfButton.put("b5", MainFrame.but5);
		listOfButton.put("b6", MainFrame.but6);
		listOfButton.put("b7", MainFrame.but7);
		listOfButton.put("b8", MainFrame.but8);
		listOfButton.put("b9", MainFrame.but9);
		
		System.out.println("������ ������ ������");
		System.out.println(listOfButton);
		
		int random = (int) (Math.random() * 9)+1; // ������ � ������� ���������� ����
		String htKey = "b" + random;
		System.out.println(htKey); 
		
		ArrayDeque<Integer> searchQ = new ArrayDeque(); // �������� ������� ��� �����
		searchQ.addAll(graph.get(htKey));
//		System.out.println(graph);
		
		processed = new ArrayList<>(); // ���� ������� ����� �����
		processed.add(htKey); // ������ ��� ��������
		
		getStart(htKey); // ������ ���

		
	}
	public static void getStart (String htKey) { // ��������� ��� ����������
		System.out.println("����� � GET START");
		

				JButton b = listOfButton.get(htKey);
				System.out.println("��� ����� "+htKey);
				b.setEnabled(false);
				b.setText("�������");
				b.setBackground(Color.red);
				MyListener.whoseMoveIs(true);
				lastMove = "" + htKey.charAt(1);
				deleteButAfterComp(lastMove);

	}
	public static void whatMove (String lastMoveHere) { // ��� ����������
		System.out.println("����� � WHAT MOVE");
		System.out.println("��������� ��� "+lastMoveHere);
		String butKey = "b"+lastMoveHere;
		System.out.println("���� ��������� ���� "+butKey);
		processed.add(butKey);
		for (String key : graph.keySet()) { 
			if (key.equals(butKey)) {
				System.out.println("����� ���� ������ � �����");
				ArrayList<Integer> list = graph.get(key); // ������� ������ ������� ��������� ������
				System.out.println("������ ��������� ������ " +list);
				if (list.isEmpty()) list = whichNode ();
				for (Integer butInt : list) { // �������� ��������� ���
					System.out.println("������� ��������� ������: "+butInt);
					String strB = "b"+butInt;						
					JButton b = listOfButton.get(strB);
					b.setEnabled(false);
					b.setText("�������");
					b.setBackground(Color.red);
					MyListener.whoseMoveIs(true);
					lastMove = butInt.toString();
					deleteButAfterComp(lastMove);
					return;
				}
			}
		}
	}
	private static ArrayList<Integer> whichNode () {
		System.out.println("�������� ������ ����");
		for (String s : processed) {
			if (!graph.get(s).isEmpty()) return graph.get(s);
		}
		return graph.get("b5");
	}
	
	public static void setGraph (Hashtable<String, ArrayList<Integer>> ht) {
		graph = ht;
	}
	
	public static Hashtable<String, ArrayList<Integer>> getGraph () {
		return graph;
	}
	public static Hashtable<String, JButton> getListOfButton () {
		return listOfButton;
	}
	public static String getLastMove () {
		return lastMove;
	}
	
	public static void deleteBut (String strBut) { // �������� ������� ������ �� ������
		System.out.println("����� � �������� ������");
		String strButWithB = "b"+strBut;
		graph.remove(strButWithB); // ������� ��� ������� � ����� ������
			
		for (ArrayList<Integer> list : graph.values()) { // �������� ������� ������ �� ������ ������
			if (list.contains(Integer.parseInt(strBut))) {
				list.remove(Integer.valueOf(Integer.parseInt(strBut)));
				System.out.println(strBut +" ������ ������� �� �����");
				System.out.println(list);
			}
		}

	}
	public static void deleteButAfterComp (String strBut) { // �������� ������� ������ �� �������
		System.out.println("����� � �������� ������ ����� �����");
			
		for (ArrayList<Integer> list : graph.values()) { // �������� ������� ������ �� ������ ������
			if (list.contains(Integer.parseInt(strBut))) {
				list.remove(Integer.valueOf(Integer.parseInt(strBut)));
				System.out.println(strBut +" ������ ������� �� �����");
				System.out.println(list);
			}
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void compWin () {
		try {
			if (MainFrame.but1.getText().equals("�������") && MainFrame.but2.getText().equals("�������")) compLastMove ("b3");
			if (MainFrame.but1.getText().equals("�������") && MainFrame.but3.getText().equals("�������")) compLastMove ("b2");
			if (MainFrame.but3.getText().equals("�������") && MainFrame.but2.getText().equals("�������")) compLastMove ("b1");
			if (MainFrame.but4.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b6");
			if (MainFrame.but4.getText().equals("�������") && MainFrame.but6.getText().equals("�������")) compLastMove ("b5");
			if (MainFrame.but6.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b4");
			if (MainFrame.but7.getText().equals("�������") && MainFrame.but8.getText().equals("�������")) compLastMove ("b9");
			if (MainFrame.but9.getText().equals("�������") && MainFrame.but7.getText().equals("�������")) compLastMove ("b8");
			if (MainFrame.but9.getText().equals("�������") && MainFrame.but8.getText().equals("�������")) compLastMove ("b7");
			if (MainFrame.but1.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b9");
			if (MainFrame.but1.getText().equals("�������") && MainFrame.but9.getText().equals("�������")) compLastMove ("b5");
			if (MainFrame.but9.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b1");
			if (MainFrame.but3.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b7");
			if (MainFrame.but3.getText().equals("�������") && MainFrame.but7.getText().equals("�������")) compLastMove ("b5");
			if (MainFrame.but7.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b3");
			if (MainFrame.but1.getText().equals("�������") && MainFrame.but4.getText().equals("�������")) compLastMove ("b7");
			if (MainFrame.but1.getText().equals("�������") && MainFrame.but7.getText().equals("�������")) compLastMove ("b4");
			if (MainFrame.but7.getText().equals("�������") && MainFrame.but4.getText().equals("�������")) compLastMove ("b1");
			if (MainFrame.but2.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b8");
			if (MainFrame.but2.getText().equals("�������") && MainFrame.but8.getText().equals("�������")) compLastMove ("b5");
			if (MainFrame.but8.getText().equals("�������") && MainFrame.but5.getText().equals("�������")) compLastMove ("b2");
			if (MainFrame.but3.getText().equals("�������") && MainFrame.but6.getText().equals("�������")) compLastMove ("b9");
			if (MainFrame.but3.getText().equals("�������") && MainFrame.but9.getText().equals("�������")) compLastMove ("b6");
			if (MainFrame.but9.getText().equals("�������") && MainFrame.but6.getText().equals("�������")) compLastMove ("b3");






















			
		} catch (HeadlessException e) {
			System.out.println("�����");
			e.printStackTrace();
		} 	
	}
	public static void compLastMove (String strB) {
		JButton b = listOfButton.get(strB);
		if (b.getText().equals("�����")) return;
		b.setEnabled(false);
		b.setText("�������");
		b.setBackground(Color.red);
	    JOptionPane.showMessageDialog(null, " �� ��������� ");

	}
	
	
	
	
	
	
	public static void gamerWin () { // ��������� �� ������� ������
		try {
			if (MainFrame.but1.getText().equals("�����") && MainFrame.but2.getText().equals("�����")
			          && MainFrame.but3.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but4.getText().equals("�����") && MainFrame.but5.getText().equals("�����")
			          && MainFrame.but6.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but7.getText().equals("�����") && MainFrame.but8.getText().equals("�����")
			          && MainFrame.but9.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but1.getText().equals("�����") && MainFrame.but4.getText().equals("�����")
			          && MainFrame.but7.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but2.getText().equals("�����") && MainFrame.but5.getText().equals("�����")
			          && MainFrame.but8.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but3.getText().equals("�����") && MainFrame.but6.getText().equals("�����")
			          && MainFrame.but9.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but1.getText().equals("�����") && MainFrame.but5.getText().equals("�����")
			          && MainFrame.but9.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
			if (MainFrame.but3.getText().equals("�����") && MainFrame.but5.getText().equals("�����")
			          && MainFrame.but7.getText().equals("�����")) {
			    JOptionPane.showMessageDialog(null, " �� �������� ");
			}
		} catch (HeadlessException e) {
			System.out.println("�����");
			e.printStackTrace();
		} 		
	}
}
