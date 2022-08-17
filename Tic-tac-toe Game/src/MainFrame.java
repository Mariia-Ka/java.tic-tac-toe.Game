
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame {
	static JLabel whoseMove;
	static JButton but1;
	static JButton but2;
	static JButton but3;
	static JButton but4;
	static JButton but5;
	static JButton but6;
	static JButton but7;
	static JButton but8;
	static JButton but9;
	ArrayList<JButton> listOfButton = new ArrayList<>();

	
	
	private static void addComponentsToPane(Container pane) {
		pane.setLayout(new BoxLayout(pane, BoxLayout.PAGE_AXIS));
		addComponentsToPanelUp(pane);
		addComponentsToPanelDown(pane);
	}
	private static void addComponentsToPanelUp (Container pane) {
		JPanel panelIn = new JPanel();
		panelIn.setPreferredSize(new Dimension(300,100));
		panelIn.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelIn.setAlignmentY(Component.TOP_ALIGNMENT);
		whoseMove = addALabel("COMPUTER", panelIn);
		pane.add(panelIn);
		
	}
	private static void addComponentsToPanelDown (Container pane) {
		JPanel panelIn = new JPanel();
		panelIn.setPreferredSize(new Dimension(300,300));
		panelIn.setAlignmentX(Component.CENTER_ALIGNMENT);
		but1 = addAButton(" ", panelIn);
		but1.setActionCommand("1");
		but2 = addAButton(" ", panelIn);
		but2.setActionCommand("2");
		but3 = addAButton(" ", panelIn);
		but3.setActionCommand("3");
		but4 = addAButton(" ", panelIn);
		but4.setActionCommand("4");
		but5 = addAButton(" ", panelIn);
		but5.setActionCommand("5");
		but6 = addAButton(" ", panelIn);
		but6.setActionCommand("6");
		but7 = addAButton(" ", panelIn);
		but7.setActionCommand("7");
		but8 = addAButton(" ", panelIn);
		but8.setActionCommand("8");
		but9 = addAButton(" ", panelIn);
		but9.setActionCommand("9");
		
		MyListener.addAnActionListenerClear(but1);
		MyListener.addAnActionListenerClear(but2);
		MyListener.addAnActionListenerClear(but3);
		MyListener.addAnActionListenerClear(but4);
		MyListener.addAnActionListenerClear(but5);
		MyListener.addAnActionListenerClear(but6);
		MyListener.addAnActionListenerClear(but7);
		MyListener.addAnActionListenerClear(but8);
		MyListener.addAnActionListenerClear(but9);
		
		pane.add(panelIn);
	}
	private static JLabel addALabel (String text, Container cont) {
		JLabel label = new JLabel(text);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		cont.add(label);
		return label;
	}
	private static JButton addAButton(String text, Container cont) {
		JButton button = new JButton();
		button.setText(text);
		button.setPreferredSize(new Dimension(100,100));
		cont.add(button);
		return button;		
	}
	public static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		JFrame frame = new JFrame("TIC-TAC-TOE GAME");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(400, 500));
		frame.setMinimumSize(new Dimension (400, 500));
		frame.setMaximumSize(new Dimension (400, 500));
		addComponentsToPane(frame.getContentPane());
		frame.pack();
		frame.setVisible(true);
		InGame.graphOfComputer();
	}
}
